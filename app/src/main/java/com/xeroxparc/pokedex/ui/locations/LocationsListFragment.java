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
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.models.SlideModel;
import com.xeroxparc.pokedex.R;
import com.xeroxparc.pokedex.databinding.FragmentLocationsListBinding;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


public class LocationsListFragment extends Fragment {

    private FragmentLocationsListBinding binding;
    final LinkedList<String> locationsList = new LinkedList<>();

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = FragmentLocationsListBinding.inflate(inflater, container, false);
        new Holder(getActivity());
        return binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        ImageSlider imageSlider=view.findViewById(R.id.ImageSlider_Map);

        List<SlideModel> slideModels= new ArrayList<>();
        slideModels.add(new SlideModel(R.drawable.image_region_kanto1));
        slideModels.add(new SlideModel(R.drawable.image_region_kanto2));

        imageSlider.setImageList(slideModels, true);

    }

    class Holder {


        public Holder(FragmentActivity activity) {

            // placeholder mechanism
            for (int i = 0; i < 20; i++) {
                locationsList.addLast("Poke City " + i);
            }

            LocationListListAdapter locationsListListAdapter = new LocationListListAdapter(activity, locationsList);

            binding.recyclerView.setAdapter(locationsListListAdapter);
            binding.recyclerView.setLayoutManager(new LinearLayoutManager(activity));

        }

    }

    private class LocationListListAdapter extends RecyclerView.Adapter<LocationListListAdapter.ViewHolder> {

        private final LinkedList<String> locationList;
        private LayoutInflater mInflater;

        public LocationListListAdapter(Context context, LinkedList<String> moveListDataset){
            mInflater = LayoutInflater.from(context);
            this.locationList = moveListDataset;

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

        @Override
        public void onBindViewHolder(@NonNull LocationListListAdapter.ViewHolder holder, int position) {

            String currentElement = locationList.get(position);
            holder.locationItemView.setText(currentElement);

            LocationsListFragmentDirections.ActionNavMoveToNavMoveDetail action = LocationsListFragmentDirections.actionNavMoveToNavMoveDetail();
            action.setLocationTitle(currentElement);

            holder.itemView.setOnClickListener(item-> {
                Navigation.findNavController(requireView()).navigate(action);
            });

        }

        @Override
        public int getItemCount() {
            return locationList.size();
        }
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}