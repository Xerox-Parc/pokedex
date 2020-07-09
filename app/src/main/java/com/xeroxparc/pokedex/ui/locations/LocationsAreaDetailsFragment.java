package com.xeroxparc.pokedex.ui.locations;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
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
import com.xeroxparc.pokedex.data.Pokemon;
import com.xeroxparc.pokedex.data.model.location.area.PokemonEncounter;
import com.xeroxparc.pokedex.data.model.utility.common.Encounter;
import com.xeroxparc.pokedex.data.model.utility.common.VersionEncounterDetail;
import com.xeroxparc.pokedex.data.repository.PokemonRepository;
import com.xeroxparc.pokedex.data.repository.LocationAreaRepository;
import com.xeroxparc.pokedex.databinding.FragmentLocationsAreaDetailsBinding;

import java.util.ArrayList;
import java.util.Collections;
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

        TextView textViewAreaName = requireView().findViewById(R.id.TextView_AreaName);
        int areaId = LocationsAreaDetailsFragmentArgs.fromBundle(requireArguments()).getLocationAreaId();
        String areaIdTitle = LocationsAreaDetailsFragmentArgs.fromBundle(requireArguments()).getLocationAreaIdTitle();

        final LocationAreaRepository locationAreaRepository = new LocationAreaRepository(requireContext());
        final PokemonRepository pokemonRepository = new PokemonRepository(requireContext());

        locationAreaRepository.getLocationArea(areaId).observe(getViewLifecycleOwner(), locationArea -> {
            locationArea.ifPresent(area -> {
//                List<PokemonEncounter> encounters = new ArrayList<>();
//                area.getPokemonEncounterList().forEach(pokemonEncounter -> {
//                    List<VersionEncounterDetail> encounterDetails = pokemonEncounter.getVersionDetailList();
//                    for(int i = 0; i<encounterDetails.size();i++){
//                        PokemonEncounter encounter = new PokemonEncounter();
//                        encounter.setPokemon(pokemonEncounter.getPokemon());
//                        List<VersionEncounterDetail> details = new ArrayList<>();
//                        details.add(encounterDetails.get(i));
//                        encounter.setVersionDetailList(details);
//                        encounters.add(encounter);
//                    }
//                });
//                encounterList.addAll(encounters);
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

            // placeholder mechanism
//            for (int i = 0; i < 20; i++) {
//                locationsAreaList.addLast("Pokemon " + i);
//            }

            locationAreaDetailsListAdapter = new LocationAreaDetailsListAdapter(activity, locationsAreaList);

            binding.recycleViewPokemonEncounter.setAdapter(locationAreaDetailsListAdapter);
            binding.recycleViewPokemonEncounter.setLayoutManager(new LinearLayoutManager(activity));

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
                locationItemView = itemView.findViewById(R.id.TextView_LocationName);
                itemLayout = itemView.findViewById(R.id.LinearLayout_LocationAreaPokemon);

                image = itemView.findViewById(R.id.pokemonImage);
                pokemonName = itemView.findViewById(R.id.TextView_PokemonName);
               // game = itemView.findViewById(R.id.TextView_Game);
                this.mAdapter = adapter;
            }

            public ImageView getImage(){
                return image;
            }

            public void setName(String name){
                pokemonName.setText(name);
            }

            //public void setGame(String game) {
//                this.game.setText(game);
//            }
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
            //VersionEncounterDetail encounterDetail = encounter.getVersionDetailList().get(0);
            String pokemonName = encounter.getPokemon().getName();
            holder.setName(pokemonName);
            //holder.setGame(encounterDetail.getVersion().getName());
            if(pokemonImages.get(pokemonName) != null){
                Glide.with(getContext()).load(pokemonImages.get(pokemonName)).into(holder.getImage());
            }
            //String currentElement = locationAreaList.get(position);
            //holder.locationItemView.setText(currentElement);

            // LocationsListFragmentDirections.ActionNavMoveToNavMoveDetail action = LocationsListFragmentDirections.actionNavMoveToNavMoveDetail();
            //action.setLocationTitle(currentElement);

            //holder.itemView.setOnClickListener(item-> {
            //      Navigation.findNavController(requireView()).navigate(action);
            //});
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