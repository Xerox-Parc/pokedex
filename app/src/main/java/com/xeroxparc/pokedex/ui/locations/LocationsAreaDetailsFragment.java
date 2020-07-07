package com.xeroxparc.pokedex.ui.locations;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.xeroxparc.pokedex.R;
import com.xeroxparc.pokedex.databinding.FragmentLocationsAreaDetailsBinding;

import java.util.LinkedList;

public class LocationsAreaDetailsFragment extends Fragment {
    private FragmentLocationsAreaDetailsBinding binding;
    final LinkedList<String> locationsAreaList = new LinkedList<>();

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = FragmentLocationsAreaDetailsBinding.inflate(inflater, container, false);
        new Holder(getActivity());
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        TextView textViewAreaName = requireView().findViewById(R.id.TextView_AreaName);
        String areaName = LocationsAreaDetailsFragmentArgs.fromBundle(requireArguments()).getLocationTitle();
        textViewAreaName.setText(areaName + ": Pokemon Ecounter");
    }

    class Holder {


        public Holder(FragmentActivity activity) {

            // placeholder mechanism
            for (int i = 0; i < 20; i++) {
                locationsAreaList.addLast("Pokemon " + i);
            }

            LocationAreaDetailsListAdapter locationAreaDetailsListAdapter = new LocationAreaDetailsListAdapter(activity, locationsAreaList);

            binding.recyclerView.setAdapter(locationAreaDetailsListAdapter);
            binding.recyclerView.setLayoutManager(new LinearLayoutManager(activity));

        }

    }

    private class LocationAreaDetailsListAdapter extends RecyclerView.Adapter<LocationAreaDetailsListAdapter.ViewHolder> {

        private final LinkedList<String> locationAreaList;
        private LayoutInflater mInflater;

        public LocationAreaDetailsListAdapter(Context context, LinkedList<String> moveListDataset){
            mInflater = LayoutInflater.from(context);
            this.locationAreaList = moveListDataset;

        }

        class ViewHolder extends RecyclerView.ViewHolder {

            public final TextView locationItemView;
            public final LinearLayout itemLayout;
            final LocationsAreaDetailsFragment.LocationAreaDetailsListAdapter mAdapter;

            public ViewHolder(View itemView, LocationsAreaDetailsFragment.LocationAreaDetailsListAdapter adapter) {
                super(itemView);
                locationItemView = itemView.findViewById(R.id.TextView_LocationName);
                itemLayout = itemView.findViewById(R.id.LinearLayout_LocationAreaPokemon);
                this.mAdapter = adapter;
            }

        }

        @NonNull
        @Override
        public LocationsAreaDetailsFragment.LocationAreaDetailsListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View mItemView = mInflater.inflate(R.layout.item_locations_area_pokemon,
                    parent, false);
            return new LocationsAreaDetailsFragment.LocationAreaDetailsListAdapter.ViewHolder(mItemView, this);
        }

        @Override
        public void onBindViewHolder(@NonNull LocationsAreaDetailsFragment.LocationAreaDetailsListAdapter.ViewHolder holder, int position) {

            //String currentElement = locationAreaList.get(position);
            //holder.locationItemView.setText(currentElement);

           // LocationsListFragmentDirections.ActionNavMoveToNavMoveDetail action = LocationsListFragmentDirections.actionNavMoveToNavMoveDetail();
            //action.setLocationTitle(currentElement);

            //holder.itemView.setOnClickListener(item-> {
          //      Navigation.findNavController(requireView()).navigate(action);
            //});

        }

        @Override
        public int getItemCount() {
            return locationAreaList.size();
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}