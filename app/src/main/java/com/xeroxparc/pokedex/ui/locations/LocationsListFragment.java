package com.xeroxparc.pokedex.ui.locations;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.models.SlideModel;
import com.xeroxparc.pokedex.R;
import com.xeroxparc.pokedex.data.model.location.Location;
import com.xeroxparc.pokedex.data.repository.LocationsRepository;
import com.xeroxparc.pokedex.data.repository.RegionRepository;
import com.xeroxparc.pokedex.databinding.FragmentLocationsListBinding;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;


public class LocationsListFragment extends Fragment {
    private static final String TAG = "LocationsListFragment";
    private FragmentLocationsListBinding binding;
    final LinkedList<String> locationsList = new LinkedList<>();
    LocationListListAdapter locationListAdapter;

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

        regionRepository.getRegion(regionId).observe(getViewLifecycleOwner(), region -> {
            region.
                    ifPresent(retreivedRegion -> {
                        locationListAdapter.setLocationNamesList(retreivedRegion.getLocationList());
                        String formattedRegionName = String.format("%s %s", "Region of", Character.toUpperCase(retreivedRegion.getName().charAt(0)) + retreivedRegion.getName().substring(1));
                        textViewRegionName.setText(formattedRegionName);

                        setImageSlider(retreivedRegion.getName(), slideModels);
                        imageSlider.setImageList(slideModels, true);
                    });
        });
    }

    class Holder {


        public Holder(FragmentActivity activity) {

            locationListAdapter = new LocationListListAdapter(activity, locationsList, getViewLifecycleOwner());

            binding.recycleViewLocationsList.setAdapter(locationListAdapter);
            binding.recycleViewLocationsList.setLayoutManager(new LinearLayoutManager(activity));

        }

    }

    private class LocationListListAdapter extends RecyclerView.Adapter<LocationListListAdapter.ViewHolder> {

        private final List<String> locationNamesList;
        private final List<Integer> locationIDList;

        private LayoutInflater mInflater;

        private final LocationsRepository locationsRepository;
        private LifecycleOwner observationLifeCycle;


        public LocationListListAdapter(Context context, List<String> moveListDataset, LifecycleOwner lifeCycle) {
            mInflater = LayoutInflater.from(context);

            this.locationNamesList = moveListDataset;
            locationsRepository = new LocationsRepository(getContext());

            locationIDList = new ArrayList<>();
            observationLifeCycle = lifeCycle;
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

            LocationsListFragmentDirections.ActionNavLocationsListToNavLocationsAreaList action = LocationsListFragmentDirections.actionNavLocationsListToNavLocationsAreaList();
            LocationsListFragmentDirections.ActionNavLocationsListToNavLocationsAreaDetails action1 = LocationsListFragmentDirections.actionNavLocationsListToNavLocationsAreaDetails();

            String currentElement = locationNamesList.get(position);
            currentElement = capitalize(currentElement).replace("-", " ");

            action.setLocationIdName(currentElement);
            holder.locationItemView.setText(currentElement);


            holder.itemView.setOnClickListener(item -> {
                if (locationIDList.size() > position) {

                    locationsRepository.getLocation(locationIDList.get(position)).observe(observationLifeCycle, location -> {
                        location.ifPresent(retrievedLocation -> {

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

                                if(serializedIds.contains(",")){
                                    // If the "," character is present, multiple location areas are
                                    // associated to the string, so pass the ids to "Location Area List" fragment
                                    action.setLocationIds(serializedIds);
                                    Navigation.findNavController(requireView()).navigate(action);
                                }else{
                                    // There is only one location area so go directly to his area details
                                    action1.setLocationAreaId(Integer.parseInt(serializedIds));
                                    Navigation.findNavController(requireView()).navigate(action1);
                                }


                            }else{
                                // Show toast message when a location that has no other details is clicked
                                Toast.makeText(getContext(),R.string.locations_not_implemented,Toast.LENGTH_LONG).show();
                            }

                        });
                    });

                }

            });

        }


        public void setLocationNamesList(List<Location> locations) {
            List<String> locationNames = locations.stream().map(Location::getName).collect(Collectors.toList());
            List<Integer> locationIDs = locations.stream().map(Location::getId).collect(Collectors.toList());

            locationNamesList.clear();
            locationNamesList.addAll(locationNames);

            locationIDList.clear();
            locationIDList.addAll(locationIDs);

            notifyDataSetChanged();
        }

        @Override
        public int getItemCount() {
            return locationNamesList.size();
        }
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
