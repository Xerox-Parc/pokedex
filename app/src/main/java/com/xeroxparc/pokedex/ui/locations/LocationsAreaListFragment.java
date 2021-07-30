package com.xeroxparc.pokedex.ui.locations;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.xeroxparc.pokedex.R;
import com.xeroxparc.pokedex.data.filtering.FilterableResourceProvider;
import com.xeroxparc.pokedex.data.filtering.TextFilter;
import com.xeroxparc.pokedex.data.filtering.TextFilterable;
import com.xeroxparc.pokedex.data.model.location.area.LocationArea;
import com.xeroxparc.pokedex.data.repository.LocationAreaRepository;
import com.xeroxparc.pokedex.databinding.FragmentLocationsAreaListBinding;
import com.xeroxparc.pokedex.ui.parents.SearchableFragment;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class LocationsAreaListFragment extends SearchableFragment {
    Holder holder;
    private FragmentLocationsAreaListBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = FragmentLocationsAreaListBinding.inflate(inflater, container, false);
        holder = new Holder(getActivity());
        requireActivity().invalidateOptionsMenu();
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //Get the Location Area ID and string name from "Location List" fragment
        TextView textViewAreaListName = requireView().findViewById(R.id.text_view_area_list_name);
        String areaListName = LocationsAreaListFragmentArgs.fromBundle(requireArguments()).getLocationIds();
        String areListTitle = LocationsAreaListFragmentArgs.fromBundle(requireArguments()).getLocationIdName();

        //Split ID strings and get single location area ID
        String[] areasIds = areaListName.split(",");
        List<Integer> idsList = new ArrayList<>();


        for (String id : areasIds) {
            idsList.add(Integer.parseInt(id));
        }

        //For each splitted id get the corresponding area object
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


        textViewAreaListName.setText(areListTitle);
    }


    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        if (holder != null && holder.locationAreaListListAdapter != null) {
            holder.locationAreaListListAdapter.getFilter().filter(newText);
        }
        return false;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    class Holder {
        LocationAreaListListAdapter locationAreaListListAdapter;

        public Holder(FragmentActivity activity) {

            locationAreaListListAdapter = new LocationsAreaListFragment.LocationAreaListListAdapter(activity);

            binding.recycleViewLocationsAreaList.setAdapter(locationAreaListListAdapter);
            binding.recycleViewLocationsAreaList.setLayoutManager(new LinearLayoutManager(activity));

        }

        LocationAreaListListAdapter getListAdapter() {
            return locationAreaListListAdapter;
        }

    }

    private class LocationAreaListListAdapter
            extends RecyclerView.Adapter<LocationsAreaListFragment.LocationAreaListListAdapter.ViewHolder>
            implements TextFilterable<LocationArea>, FilterableResourceProvider<LocationArea> {

        private final List<LocationArea> locationAreaList;
        private List<LocationArea> filteredList;
        private LayoutInflater mInflater;

        public LocationAreaListListAdapter(Context context) {
            mInflater = LayoutInflater.from(context);
            locationAreaList = new ArrayList<>();
            filteredList = new ArrayList<>();
        }

        @Override
        public TextFilter<LocationArea> getFilter() {
            return new TextFilter<>(locationAreaList, this, this);
        }

        @Override
        public void postFiltering(List<LocationArea> filteredData) {
            filteredList.clear();
            filteredList.addAll(filteredData);
            notifyDataSetChanged();
        }


        @Override
        public String getFilterableResource(LocationArea source) {
            return source.getName();
        }

        @NonNull
        @Override
        public LocationsAreaListFragment.LocationAreaListListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View mItemView = mInflater.inflate(R.layout.item_locations,
                    parent, false);
            return new LocationsAreaListFragment.LocationAreaListListAdapter.ViewHolder(mItemView, this);
        }

        private String capitalize(final String line) {
            // Capitalize the first character of passed string
            return Character.toUpperCase(line.charAt(0)) + line.substring(1);
        }

        @Override
        public void onBindViewHolder(@NonNull LocationsAreaListFragment.LocationAreaListListAdapter.ViewHolder holder, int position) {

            LocationsAreaListFragmentDirections.ActionNavLocationsAreaListToNavLocationsAreaDetails action = LocationsAreaListFragmentDirections.actionNavLocationsAreaListToNavLocationsAreaDetails();

            LocationArea currentElement = filteredList.get(position);

            // Capitalize the first character and remove "-" character from Loacation Area Name
            holder.locationItemView.setText(capitalize(currentElement.getName()).replace("-", " "));

            action.setLocationAreaIdTitle(capitalize(currentElement.getName()).replace("-", " "));
            action.setLocationAreaId(currentElement.getId());

            holder.itemView.setOnClickListener(item -> {
                Navigation.findNavController(requireView()).navigate(action);
            });
        }

        @Override
        public int getItemCount() {
            return filteredList.size();
        }

        public void addLocationArea(LocationArea area) {
            if (filteredList.size() == locationAreaList.size()) {
                filteredList.add(area);
            }
            locationAreaList.add(area);
            notifyDataSetChanged();
        }

        class ViewHolder extends RecyclerView.ViewHolder {

            public final TextView locationItemView;
            public final LinearLayout itemLayout;
            final LocationsAreaListFragment.LocationAreaListListAdapter mAdapter;


            public ViewHolder(View itemView, LocationsAreaListFragment.LocationAreaListListAdapter adapter) {
                super(itemView);
                locationItemView = itemView.findViewById(R.id.text_view_location_name);
                itemLayout = itemView.findViewById(R.id.linear_layout_location);

                this.mAdapter = adapter;
            }

        }
    }
}