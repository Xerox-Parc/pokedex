package com.xeroxparc.pokedex.ui.locations;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.models.SlideModel;
import com.xeroxparc.pokedex.R;
import com.xeroxparc.pokedex.data.filtering.FilterableResourceProvider;
import com.xeroxparc.pokedex.data.filtering.TextFilter;
import com.xeroxparc.pokedex.data.filtering.TextFilterable;
import com.xeroxparc.pokedex.data.model.location.Location;
import com.xeroxparc.pokedex.data.repository.LocationsRepository;
import com.xeroxparc.pokedex.data.repository.RegionRepository;
import com.xeroxparc.pokedex.databinding.FragmentLocationsListBinding;
import com.xeroxparc.pokedex.ui.parents.SearchableFragment;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class LocationsListFragment extends SearchableFragment {
    private LocationListListAdapter locationListAdapter;
    private FragmentLocationsListBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = FragmentLocationsListBinding.inflate(inflater, container, false);
        new Holder(getActivity());
        return binding.getRoot();
    }

    public void setImageSlider(String regionName, List<SlideModel> slideModels) {
        // Pass name of drawable image for get and set maps
        int resIdMap1 = getResources().getIdentifier("image_region_" + regionName + "1", "drawable", getContext().getPackageName());
        slideModels.add(new SlideModel(resIdMap1));
        if (!regionName.equals("alola") && !regionName.equals("kalos")) {
            // Alola and Kalos Region have only 1 map
            int resIdMap2 = getResources().getIdentifier("image_region_" + regionName + "2", "drawable", getContext().getPackageName());
            slideModels.add(new SlideModel(resIdMap2));
        }
    }

    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        final RegionRepository regionRepository = new RegionRepository(getContext());
        TextView textViewRegionName = requireView().findViewById(R.id.text_view_region_name);
        ImageSlider imageSlider = view.findViewById(R.id.image_slider_map);
        List<SlideModel> slideModels = new ArrayList<>();
        // Get region ID from "Filter by generation" fragment
        int regionId = LocationsListFragmentArgs.fromBundle(requireArguments()).getRegionId();
        // From Region ID make API request to get Region ID to set Title
        regionRepository.getRegion(regionId).observe(getViewLifecycleOwner(), region -> {
            region.
                    ifPresent(retreivedRegion -> {
                        locationListAdapter.setLocationsList(retreivedRegion.getLocationList());
                        String formattedRegionName = String.format("%s %s", getString(R.string.locations_list_region_title), Character.toUpperCase(retreivedRegion.getName().charAt(0)) + retreivedRegion.getName().substring(1));
                        textViewRegionName.setText(formattedRegionName);
                        setImageSlider(retreivedRegion.getName(), slideModels);
                        imageSlider.setImageList(slideModels, true);
                    });
        });
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        onQueryTextChange(query);
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        if (locationListAdapter != null) {
            locationListAdapter.getFilter().filter(newText);
        }
        return true;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    class Holder {

        public Holder(FragmentActivity activity) {
            locationListAdapter = new LocationListListAdapter(activity, getViewLifecycleOwner());
            binding.recycleViewLocationsList.setAdapter(locationListAdapter);
            binding.recycleViewLocationsList.setLayoutManager(new LinearLayoutManager(activity));
        }
    }

    private class LocationListListAdapter extends RecyclerView.Adapter<LocationListListAdapter.ViewHolder>
            implements TextFilterable<Location>, FilterableResourceProvider<Location> {
        private final List<Location> locationsList;
        private final List<Location> filteredLocationsList;
        private final LocationsRepository locationsRepository;
        private LayoutInflater mInflater;
        private LifecycleOwner observationLifeCycle;

        public LocationListListAdapter(Context context, LifecycleOwner lifeCycle) {
            mInflater = LayoutInflater.from(context);
            locationsRepository = new LocationsRepository(getContext());
            locationsList = new ArrayList<>();
            filteredLocationsList = new ArrayList<>();
            observationLifeCycle = lifeCycle;
        }

        @Override
        public TextFilter<Location> getFilter() {
            return new TextFilter<>(locationsList, this, this);
        }


        @Override
        public void postFiltering(List<Location> filteredData) {
            filteredLocationsList.clear();
            filteredLocationsList.addAll(filteredData);
            notifyDataSetChanged();
        }

        @NonNull
        @Override
        public LocationListListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View mItemView = mInflater.inflate(R.layout.item_locations,
                    parent, false);
            return new ViewHolder(mItemView, this);
        }

        private String capitalize(final String line) {
            return Character.toUpperCase(line.charAt(0)) + line.substring(1);
        }

        @Override
        public void onBindViewHolder(@NonNull LocationListListAdapter.ViewHolder holder, int position) {
            Location currentElement = filteredLocationsList.get(position);

            // Capitalize the firs character and remove "-" characters
            String locationName = capitalize(currentElement.getName()).replace("-", " ");

            holder.locationItemView.setText(locationName);

            holder.itemView.setOnClickListener(item -> {
                if (filteredLocationsList.size() > position) {
                    LocationsListFragmentDirections.ActionNavLocationsListToNavLocationsAreaList action = LocationsListFragmentDirections.actionNavLocationsListToNavLocationsAreaList();
                    LocationsListFragmentDirections.ActionNavLocationsListToNavLocationsAreaDetails action1 = LocationsListFragmentDirections.actionNavLocationsListToNavLocationsAreaDetails();
                    action.setLocationIdName(locationName);

                    locationsRepository.getLocation(filteredLocationsList.get(position).getId()).observe(observationLifeCycle, location -> {
                        location.ifPresent(retrievedLocation -> {
                            //Retrieval of Location ID to make IDs string
                            List<String> idsChain = retrievedLocation.getAreaList().stream().map(locationArea -> String.valueOf(locationArea.getId())).collect(Collectors.toList());
                            // Concatenate ids separated by the character "," into a string
                            if (idsChain.size() > 0) {
                                String serializedIds = "";
                                for (int i = 0; i < idsChain.size(); i++) {
                                    serializedIds += idsChain.get(i);
                                    if (i < idsChain.size() - 1) {
                                        serializedIds += ",";
                                    }
                                }

                                if (serializedIds.contains(",")) {

                                    // If the "," character is present, multiple location areas are
                                    // associated to the string, so pass the ids to "Location Area List" fragment
                                    action.setLocationIds(serializedIds);
                                    Navigation.findNavController(requireView()).navigate(action);
                                } else {
                                    // There is only one location area so go directly to his area details
                                    action1.setLocationAreaId(Integer.parseInt(serializedIds));
                                    Navigation.findNavController(requireView()).navigate(action1);
                                }

                            } else {
                                // Show toast message when a location that has no other details is clicked
                                Toast.makeText(getContext(), R.string.locations_not_implemented, Toast.LENGTH_LONG).show();
                            }
                        });
                    });
                }
            });
        }

        public void setLocationsList(List<Location> locations) {
            filteredLocationsList.clear();
            filteredLocationsList.addAll(locations);
            locationsList.clear();
            locationsList.addAll(locations);
            notifyDataSetChanged();
        }

        @Override
        public int getItemCount() {
            return filteredLocationsList.size();
        }

        @Override
        public String getFilterableResource(Location source) {
            return source.getName().toLowerCase();
        }

        class ViewHolder extends RecyclerView.ViewHolder {

            public final TextView locationItemView;
            public final LinearLayout itemLayout;
            final LocationListListAdapter mAdapter;


            public ViewHolder(View itemView, LocationListListAdapter adapter) {
                super(itemView);
                locationItemView = itemView.findViewById(R.id.text_view_location_name);
                itemLayout = itemView.findViewById(R.id.linear_layout_location);
                this.mAdapter = adapter;
            }

        }

    }
}