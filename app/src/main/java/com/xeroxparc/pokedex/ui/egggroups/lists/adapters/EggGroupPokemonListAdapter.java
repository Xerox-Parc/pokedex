package com.xeroxparc.pokedex.ui.egggroups.lists.adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Filter;

import com.bumptech.glide.Glide;
import com.xeroxparc.pokedex.data.model.pokemon.species.PokemonSpecies;
import com.xeroxparc.pokedex.databinding.ItemRowEggGroupPokemonBinding;
import com.xeroxparc.pokedex.ui.egggroups.components.EggGroupChip;
import com.xeroxparc.pokedex.ui.egggroups.constants.EggGroupType;
import com.xeroxparc.pokedex.ui.egggroups.fragments.details.EggGroupDetailsLoader;
import com.xeroxparc.pokedex.ui.egggroups.fragments.details.EggGroupDetailsNavigationRequester;
import com.xeroxparc.pokedex.ui.egggroups.lists.adapters.EggGroupSpeciesListFilter.FilterMode;
import com.xeroxparc.pokedex.ui.egggroups.lists.viewholders.EggGroupPokemonViewHolder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class EggGroupPokemonListAdapter extends RecyclerView.Adapter<EggGroupPokemonViewHolder>
        implements TypeAndTextFilterable, PostFilteringCallBack<List<PokemonSpecies>>, OnClickListener {
    private static final String TAG = "EggGroupPokemonListAdap";
    private final int BIG_BATCH_SIZE = 5;
    private final int SMALL_BATCH_SIZE = 2;
    private Context ctx;
    private EggGroupDetailsLoader detailsLoader;
    private EggGroupDetailsNavigationRequester navigationRequester;
    private List<PokemonSpecies> simpleSpeciesList;
    private List<PokemonSpecies> filteredList;
    private Map<String, String> imagesMap;
    private Map<String, Boolean> loadingMap;
    private Map<String, PokemonSpecies> detailedSpecies;
    private int lastLoadedItem = 5;


    public EggGroupPokemonListAdapter(Context context, EggGroupDetailsLoader loader,
                                      List<PokemonSpecies> species, EggGroupDetailsNavigationRequester navigationRequester) {
        filteredList = new ArrayList<>();
        imagesMap = new HashMap<>();
        loadingMap = new HashMap<>();
        simpleSpeciesList = species;
        ctx = context;
        filteredList.addAll(species);
        detailedSpecies = new HashMap<>();
        detailsLoader = loader;
        this.navigationRequester = navigationRequester;
    }

    @NonNull
    @Override
    public EggGroupPokemonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        ItemRowEggGroupPokemonBinding pokemonBinding = ItemRowEggGroupPokemonBinding.inflate(inflater, parent, false);
        return new EggGroupPokemonViewHolder(pokemonBinding, this);
    }

    @Override
    public void onBindViewHolder(@NonNull EggGroupPokemonViewHolder holder, int position) {
        loadBatchIfNeeded(position, BIG_BATCH_SIZE);
        holder.resetImage();
        holder.resetEggGroups();
        PokemonSpecies specie = filteredList.get(position);
        String specieName = specie.getName();
        holder.setPokemonName(specieName);
        if (imagesMap.get(specieName) != null) {
            Glide.with(ctx).
                    load(imagesMap.get(specieName)).
                    into(holder.getImage());
            detailedSpecies.get(specieName).getEggGroupsList().forEach(eggGroup -> {
                EggGroupType type = EggGroupType.getEggGroupTypeById(eggGroup.getId());
                holder.addEggGroupChip(new EggGroupChip(ctx, type, this));
            });
        }
    }

    @Override
    public int getItemCount() {
        return filteredList.size();
    }

    @Override
    public void postFiltering(List<PokemonSpecies> filteredData) {
        filteredList.clear();
        filteredList.addAll(filteredData);
        notifyDataSetChanged();
    }

    public void setSimpleSpeciesList(List<PokemonSpecies> species) {
        simpleSpeciesList = species;
        filteredList.clear();
        filteredList.addAll(species);
        notifyDataSetChanged();
    }

    private void loadBatchIfNeeded(int initialPosition, int offset) {
        for (int nextToLoad = initialPosition; nextToLoad <= initialPosition + offset; nextToLoad++) {
            if (nextToLoad < filteredList.size()) {
                loadSingleIfNeeded(nextToLoad);
            }
        }
    }

    private synchronized void loadSingleIfNeeded(int currentPosition) {
        Boolean loadingStatus = loadingMap.get(filteredList.get(currentPosition).getName());
        if (loadingStatus == null) {
            PokemonSpecies specie = filteredList.get(currentPosition);
            detailsLoader.loadDetailedSpecieInAdapter(specie.getId(), currentPosition);
            loadingMap.put(specie.getName(), false);
            Log.e(TAG, "loadSingleIfNeeded[LAST:" + lastLoadedItem + "]: " + currentPosition);
            if (lastLoadedItem < currentPosition) {
                Log.e(TAG, "loadSingleIfNeeded:LOADED LAST:"+ currentPosition);
                lastLoadedItem = currentPosition;
            } else if (imagesMap.get(filteredList.get(lastLoadedItem - BIG_BATCH_SIZE).getName()) != null) {
                Log.e(TAG, "loadSingleIfNeeded:UPDATE LAST LOADED ITEM:"+ currentPosition);
                loadBatchIfNeeded(lastLoadedItem, SMALL_BATCH_SIZE);
            }
            //False means that it started loading and should be set to true when loaded
        }
    }

    public void addImage(String specieName, String imageUrl, int position) {
        imagesMap.put(specieName, imageUrl);
        loadingMap.put(specieName, true);
        notifyItemChanged(position);
    }

    public void addSpecie(PokemonSpecies newSpecie, int position) {
        detailedSpecies.put(newSpecie.getName(), newSpecie);
        notifyItemChanged(position);
    }

    @Override
    public void onClick(View view) {
        if (view.getTag() == EggGroupChip.TAG) {
            if (view instanceof EggGroupChip) {
                EggGroupChip eggGroupChip = (EggGroupChip) view;
                navigationRequester.navigateToEggGroup(eggGroupChip.getEggGroupType());
            }
        } else {
            /*Card was clicked*/
            Log.e(TAG, "onClick: " + view.getTag());
        }
    }

    @Override
    public Filter getFilter(FilterMode filterMode) {
        return new EggGroupSpeciesListFilter(simpleSpeciesList, detailedSpecies, filterMode, this);
    }
}