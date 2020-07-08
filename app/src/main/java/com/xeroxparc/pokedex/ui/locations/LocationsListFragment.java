package com.xeroxparc.pokedex.ui.locations;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
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

    public String getRegionName(int regionID) {
        String regionName = "";

        switch (regionID) {
            case 1:
                regionName = "kanto";
                break;
            case 2:
                regionName = "johto";
                break;
            case 3:
                regionName = "hoenn";
                break;
            case 4:
                regionName = "sinnoh";
                break;
            case 5:
                regionName = "unova";
                break;
            case 6:
                regionName = "kalos";
                break;
            case 7:
                regionName = "alola";
                break;
        }

        return regionName;
    }

    public void setImageSlider(String regionName, List<SlideModel> slideModels) {
        int resIdMap1 = getResources().getIdentifier("image_region_" + regionName + "1", "drawable", getContext().getPackageName());
        slideModels.add(new SlideModel(resIdMap1));

        if (!regionName.equals("alola") && !regionName.equals("kalos")) {
            int resIdMap2 = getResources().getIdentifier("image_region_" + regionName + "2", "drawable", getContext().getPackageName());
            slideModels.add(new SlideModel(resIdMap2));
        }
    }

    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        final RegionRepository regionRepository = new RegionRepository(getContext());
        //String regionName = "";

        TextView textViewRegionName = requireView().findViewById(R.id.TextView_RegionName);
        int regionId = LocationsListFragmentArgs.fromBundle(requireArguments()).getRegionId();

        regionRepository.getRegion(regionId).observe(getViewLifecycleOwner(), region -> {
            region.
                    ifPresent(retreivedRegion -> {
                        locationListAdapter.setLocationNamesList(retreivedRegion.getLocationList());
                        textViewRegionName.setText(String.format("%s %s", "Region of", Character.toUpperCase(retreivedRegion.getName().charAt(0)) + retreivedRegion.getName().substring(1)));
                        //regionName = String.format("%s", retreivedRegion.getName());
                    });
        });

        String regionName = getRegionName(regionId);


        ImageSlider imageSlider = view.findViewById(R.id.ImageSlider_Map);
        List<SlideModel> slideModels = new ArrayList<>();
        setImageSlider(regionName, slideModels);
        imageSlider.setImageList(slideModels, true);

    }

    class Holder {


        public Holder(FragmentActivity activity) {

            locationListAdapter = new LocationListListAdapter(activity, locationsList, getViewLifecycleOwner());

            binding.recyclerView.setAdapter(locationListAdapter);
            binding.recyclerView.setLayoutManager(new LinearLayoutManager(activity));

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
                locationItemView = itemView.findViewById(R.id.TextView_LocationName);
                itemLayout = itemView.findViewById(R.id.LinearLayout_location);
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

            String currentElement = locationNamesList.get(position);
            currentElement = Character.toUpperCase(currentElement.charAt(0)) + currentElement.substring(1).replace("-", " ");

            holder.locationItemView.setText(currentElement);

            LocationsListFragmentDirections.ActionNavLocationsListToNavLocationsAreaList action = LocationsListFragmentDirections.actionNavLocationsListToNavLocationsAreaList();


            holder.itemView.setOnClickListener(item -> {
                if (locationIDList.size() > position) {

                    locationsRepository.getLocation(locationIDList.get(position)).observe(observationLifeCycle, location -> {
                        location.ifPresent(retrievedLocation -> {
                            List<String> idsChain = retrievedLocation.getAreaList().stream().map(locationArea -> String.valueOf(locationArea.getId())).collect(Collectors.toList());
                            String serializedIds = "";
                            for(int i=0;i<idsChain.size();i++){
                                serializedIds += idsChain.get(i);
                                if(i < idsChain.size() -1){
                                    serializedIds += ",";
                                }
                            }
                            action.setLocationIds(serializedIds);
                            Navigation.findNavController(requireView()).navigate(action);

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
