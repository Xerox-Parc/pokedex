package com.xeroxparc.pokedex.ui.locations;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.models.SlideModel;
import com.xeroxparc.pokedex.R;
import com.xeroxparc.pokedex.data.model.location.Location;
import com.xeroxparc.pokedex.data.model.location.area.LocationArea;
import com.xeroxparc.pokedex.data.repository.LocationAreaRepository;
import com.xeroxparc.pokedex.data.repository.RegionRepository;
import com.xeroxparc.pokedex.databinding.FragmentLocationsAreaDetailsBinding;
import com.xeroxparc.pokedex.databinding.FragmentLocationsAreaListBinding;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import pl.droidsonroids.gif.GifImageView;

public class LocationsAreaListFragment extends DialogFragment {
    private FragmentLocationsAreaListBinding binding;
    final LinkedList<String> locationsAreaList = new LinkedList<>();
    Holder holder;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = FragmentLocationsAreaListBinding.inflate(inflater, container, false);
        holder = new Holder(getActivity());
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        TextView textViewAreaListName = requireView().findViewById(R.id.TextView_AreaListName);
        String areaListName = LocationsAreaListFragmentArgs.fromBundle(requireArguments()).getLocationIds();

        String[] areasIds = areaListName.split(",");
        List<Integer> idsList = new ArrayList<>();

        if (areasIds.length == 1) {
            int id = Integer.parseInt(areasIds[0]);

            LocationsAreaListFragmentDirections.ActionNavLocationsAreaListToNavLocationsAreaDetails action = LocationsAreaListFragmentDirections.actionNavLocationsAreaListToNavLocationsAreaDetails();
            action.setLocationAreaId(id);
            Navigation.findNavController(requireView()).navigate(action);

        } else {
            for (String id : areasIds) {
                idsList.add(Integer.parseInt(id));
            }

            LocationAreaRepository locationAreaRepository = new LocationAreaRepository(requireContext());
            idsList.forEach(id -> {
                locationAreaRepository.
                        getLocationArea(id).
                        observe(getViewLifecycleOwner(),
                                locationArea -> locationArea.ifPresent(retrievedArea -> {
                                    holder.getListAdapter().addLocationArea(retrievedArea);
                                }));
            });
        }

        textViewAreaListName.setText("Area List:" + areaListName);
    }

    class Holder {
        LocationAreaListListAdapter locationAreaListListAdapter;

        public Holder(FragmentActivity activity) {

            locationAreaListListAdapter = new LocationsAreaListFragment.LocationAreaListListAdapter(activity);

            binding.recyclerView.setAdapter(locationAreaListListAdapter);
            binding.recyclerView.setLayoutManager(new LinearLayoutManager(activity));

        }

        LocationAreaListListAdapter getListAdapter() {
            return locationAreaListListAdapter;
        }

    }

    private class LocationAreaListListAdapter extends RecyclerView.Adapter<LocationsAreaListFragment.LocationAreaListListAdapter.ViewHolder> {

        private final List<LocationArea> locationAreaList;
        private LayoutInflater mInflater;

        public LocationAreaListListAdapter(Context context) {
            mInflater = LayoutInflater.from(context);
            locationAreaList = new ArrayList<>();
        }

        class ViewHolder extends RecyclerView.ViewHolder {

            public final TextView locationItemView;
            public final LinearLayout itemLayout;
            final LocationsAreaListFragment.LocationAreaListListAdapter mAdapter;


            public ViewHolder(View itemView, LocationsAreaListFragment.LocationAreaListListAdapter adapter) {
                super(itemView);
                locationItemView = itemView.findViewById(R.id.TextView_LocationName);
                itemLayout = itemView.findViewById(R.id.LinearLayout_location);
                this.mAdapter = adapter;
            }

        }

        @NonNull
        @Override
        public LocationsAreaListFragment.LocationAreaListListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View mItemView = mInflater.inflate(R.layout.item_locations,
                    parent, false);
            return new LocationsAreaListFragment.LocationAreaListListAdapter.ViewHolder(mItemView, this);
        }

        @Override
        public void onBindViewHolder(@NonNull LocationsAreaListFragment.LocationAreaListListAdapter.ViewHolder holder, int position) {

            LocationArea currentElement = locationAreaList.get(position);
            holder.locationItemView.setText(currentElement.getName());



            LocationsAreaListFragmentDirections.ActionNavLocationsAreaListToNavLocationsAreaDetails action = LocationsAreaListFragmentDirections.actionNavLocationsAreaListToNavLocationsAreaDetails();
            action.setLocationAreaId(21);

            holder.itemView.setOnClickListener(item -> {
               // locationArea
                Navigation.findNavController(requireView()).navigate(action);
            });

        }

        @Override
        public int getItemCount() {
            return locationAreaList.size();
        }

        public void addLocationArea(LocationArea area) {
            locationAreaList.add(area);
            notifyItemInserted(locationAreaList.size());
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }


}