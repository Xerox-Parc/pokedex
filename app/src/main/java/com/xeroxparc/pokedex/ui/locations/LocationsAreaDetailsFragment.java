package com.xeroxparc.pokedex.ui.locations;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.xeroxparc.pokedex.R;
import com.xeroxparc.pokedex.data.model.location.area.PokemonEncounter;
import com.xeroxparc.pokedex.data.repository.PokemonRepository;
import com.xeroxparc.pokedex.data.repository.LocationAreaRepository;
import com.xeroxparc.pokedex.databinding.FragmentLocationsAreaDetailsBinding;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class LocationsAreaDetailsFragment extends Fragment {
    private static final String TAG = "LocationsAreaDetailsFra";
    private FragmentLocationsAreaDetailsBinding binding;
    final LinkedList<String> locationsAreaList = new LinkedList<>();
    final Map<String, String> pokemonImages = new HashMap<>();
    final List<PokemonEncounter> encounterList = new LinkedList<>();
    private LocationAreaDetailsListAdapter locationAreaDetailsListAdapter;


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

        // Get Area ID and Name from "Locations Area List" and "Location List" fragments
        TextView textViewAreaName = requireView().findViewById(R.id.text_view_area_name);
        int areaId = LocationsAreaDetailsFragmentArgs.fromBundle(requireArguments()).getLocationAreaId();
        String areaIdTitle = LocationsAreaDetailsFragmentArgs.fromBundle(requireArguments()).getLocationAreaIdTitle();

        final LocationAreaRepository locationAreaRepository = new LocationAreaRepository(requireContext());
        final PokemonRepository pokemonRepository = new PokemonRepository(requireContext());

        locationAreaRepository.getLocationArea(areaId).observe(getViewLifecycleOwner(), locationArea -> {
            locationArea.ifPresent(area -> {

                encounterList.addAll(area.getPokemonEncounterList());
                locationAreaDetailsListAdapter.notifyDataSetChanged();
                encounterList.forEach(pokemonEncounter -> {
                    pokemonRepository.
                            getPokemon(pokemonEncounter.getPokemon().getId()).
                            observe(getViewLifecycleOwner(), pokemon -> {
                                pokemon.ifPresent(retrievedPokemon -> {
                                    pokemonImages.put(retrievedPokemon.getName(), retrievedPokemon.getSprite().getFrontDefault());
                                    locationAreaDetailsListAdapter.notifyDataSetChanged();
                                });
                            });
                });
            });
        });

        textViewAreaName.setText(areaIdTitle + " Pokemon Ecounter");
    }

    class Holder {


        public Holder(FragmentActivity activity) {

            locationAreaDetailsListAdapter = new LocationAreaDetailsListAdapter(activity, locationsAreaList);

            binding.recycleViewLocationsAreaDetails.setAdapter(locationAreaDetailsListAdapter);
            binding.recycleViewLocationsAreaDetails.setLayoutManager(new LinearLayoutManager(activity));

        }

    }

    private class LocationAreaDetailsListAdapter extends RecyclerView.Adapter<LocationAreaDetailsListAdapter.ViewHolder> {

        private final LinkedList<String> locationAreaList;
        private LayoutInflater mInflater;

        public LocationAreaDetailsListAdapter(Context context, LinkedList<String> moveListDataset) {
            mInflater = LayoutInflater.from(context);
            this.locationAreaList = moveListDataset;

        }

        class ViewHolder extends RecyclerView.ViewHolder {

            public final TextView locationItemView;
            public final LinearLayout itemLayout;
            public ImageView image;
            public TextView pokemonName;
            public TextView game;
            final LocationsAreaDetailsFragment.LocationAreaDetailsListAdapter mAdapter;

            public ViewHolder(View itemView, LocationsAreaDetailsFragment.LocationAreaDetailsListAdapter adapter) {
                super(itemView);
                locationItemView = itemView.findViewById(R.id.text_view_location_name);
                itemLayout = itemView.findViewById(R.id.linear_layout_location_area_pokemon);

                image = itemView.findViewById(R.id.image_view_pokemon_sprite);
                pokemonName = itemView.findViewById(R.id.text_view_pokemon_name);
                this.mAdapter = adapter;
            }

            public ImageView getImage(){
                return image;
            }

            public void setName(String name){
                pokemonName.setText(name);
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
            PokemonEncounter encounter = encounterList.get(position);

            String pokemonName = encounter.getPokemon().getName();
            holder.setName(pokemonName);

            if(pokemonImages.get(pokemonName) != null){
                // Get Pokemon's image
                Glide.with(getContext()).load(pokemonImages.get(pokemonName)).into(holder.getImage());
            }

            binding.listLoadingImg.setVisibility(View.GONE);

        }

        @Override
        public int getItemCount() {
            return encounterList.size();
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}