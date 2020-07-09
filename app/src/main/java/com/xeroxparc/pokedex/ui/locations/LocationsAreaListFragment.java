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
        String areListTitle = LocationsAreaListFragmentArgs.fromBundle(requireArguments()).getLocationIdName();

        String[] areasIds = areaListName.split(",");
        List<Integer> idsList = new ArrayList<>();

        //Ids.length == 1) {
        //d = Integer.parseInt(areasIds[0]);

        //ionsAreaListFragmentDirections.ActionNavLocationsAreaListToNavLocationsAreaDetails action = LocationsAreaListFragmentDirections.actionNavLocationsAreaListToNavLocationsAreaDetails();
        //n.setLocationAreaId(id);
        //ation.findNavController(requireView()).navigate(action);

        //
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
                                    binding.listLoadingImg.setVisibility(View.GONE);
                                }));
            });
       // }

        textViewAreaListName.setText(areListTitle);
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


        private String capitalize(final String line) {
            return Character.toUpperCase(line.charAt(0)) + line.substring(1);
        }

        @Override
        public void onBindViewHolder(@NonNull LocationsAreaListFragment.LocationAreaListListAdapter.ViewHolder holder, int position) {

            LocationArea currentElement = locationAreaList.get(position);
            holder.locationItemView.setText(capitalize(currentElement.getName()).replace("-", " "));



            LocationsAreaListFragmentDirections.ActionNavLocationsAreaListToNavLocationsAreaDetails action = LocationsAreaListFragmentDirections.actionNavLocationsAreaListToNavLocationsAreaDetails();
            action.setLocationAreaId(currentElement.getId());

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