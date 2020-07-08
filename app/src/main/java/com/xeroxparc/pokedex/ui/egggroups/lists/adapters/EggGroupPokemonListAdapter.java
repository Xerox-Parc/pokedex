package com.xeroxparc.pokedex.ui.egggroups.lists.adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;

import com.bumptech.glide.Glide;
import com.xeroxparc.pokedex.data.model.pokemon.species.PokemonSpecies;
import com.xeroxparc.pokedex.databinding.ItemRowEggGroupPokemonBinding;
import com.xeroxparc.pokedex.ui.egggroups.fragments.details.EggGroupDetailsLoader;
import com.xeroxparc.pokedex.ui.egggroups.lists.viewholders.EggGroupPokemonViewHolder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class EggGroupPokemonListAdapter extends RecyclerView.Adapter<EggGroupPokemonViewHolder> implements Filterable, PostFilteringCallBack<List<PokemonSpecies>> {
    private static final String TAG = "EggGroupPokemonListAdap";
    private List<PokemonSpecies> speciesList;
    private Map<String, String> imagesMap;
    private List<PokemonSpecies> filteredList = new ArrayList<>();
    private Map<Integer, Boolean> loadingMap = new HashMap<>();
    private EggGroupDetailsLoader detailsLoader;
    private Context ctx;

    public EggGroupPokemonListAdapter(Context context, EggGroupDetailsLoader loader, List<PokemonSpecies> species) {
        ctx = context;
        speciesList = species;
        filteredList.addAll(species);
        imagesMap = new HashMap<>();
        detailsLoader = loader;
    }

    @NonNull
    @Override
    public EggGroupPokemonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        ItemRowEggGroupPokemonBinding pokemonBinding = ItemRowEggGroupPokemonBinding.inflate(inflater, parent, false);
        return new EggGroupPokemonViewHolder(pokemonBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull EggGroupPokemonViewHolder holder, int position) {
        final int BATCH_SIZE = 5;
        loadBatchIfNeeded(position, BATCH_SIZE);
        PokemonSpecies specie = filteredList.get(position);
        String specieName = specie.getName();
        holder.resetImage();
        holder.setPokemonName(specieName);
        if (imagesMap.get(specieName) != null) {
            Glide.with(ctx).
                    load(imagesMap.get(specieName)).
                    into(holder.getImage());
        }

    }

    @Override
    public int getItemCount() {
        return filteredList.size();
    }

    @Override
    public Filter getFilter() {
        return new EggGroupSpeciesListFilter(speciesList, this);
    }

    @Override
    public void postFiltering(List<PokemonSpecies> filteredData) {
        filteredList.clear();
        filteredList.addAll(filteredData);
        notifyDataSetChanged();
    }

    public void setSpeciesList(List<PokemonSpecies> species) {
        speciesList = species;
        filteredList.clear();
        filteredList.addAll(species);
        notifyDataSetChanged();
    }

    private void loadBatchIfNeeded(int initialPosition, int offset) {
        for (int nextToLoad = initialPosition; nextToLoad <= initialPosition + offset; nextToLoad++) {
            if (nextToLoad < speciesList.size()) {
                loadSingleIfNeeded(nextToLoad);
            }
        }
    }

    private synchronized void loadSingleIfNeeded(int currentPosition) {
        Boolean loadingStatus = loadingMap.get(currentPosition);
        if (loadingStatus == null) {
            PokemonSpecies specie = speciesList.get(currentPosition);
            detailsLoader.loadDetailedSpecieInAdapter(specie.getId(), currentPosition);
            loadingMap.put(currentPosition, false);
            //False means that it started loading and should be set to true when loaded
        }
    }

    public void addImage(String specieName, String imageUrl, int position) {
        imagesMap.put(specieName, imageUrl);
        notifyItemChanged(position);
//        speciesList.
//                parallelStream().
//                filter(current -> current.getName().equalsIgnoreCase(specieName)).
//                findFirst().
//                ifPresent(specie -> {
//                    notifyItemChanged(speciesList.indexOf(specie));
//                });
    }

    public void addSpecie(PokemonSpecies newSpecie, int position) {
        speciesList.set(position, newSpecie);
//        notifyItemChanged(position);

//        speciesList.
//                parallelStream().
//                filter(current -> current.getName().equalsIgnoreCase(newSpecie.getName())).
//                findFirst().
//                ifPresent(specie -> {
//                    int index = speciesList.indexOf(specie);
//                    speciesList.set(index, newSpecie);
//                    notifyItemChanged(index);
//                });
    }
}