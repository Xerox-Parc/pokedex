package com.xeroxparc.pokedex.ui.egggroups.egggroups.lists.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Filter;

import com.bumptech.glide.Glide;
import com.xeroxparc.pokedex.data.model.pokemon.Pokemon;
import com.xeroxparc.pokedex.data.model.pokemon.species.PokemonSpecies;
import com.xeroxparc.pokedex.databinding.ItemRowEggGroupPokemonBinding;
import com.xeroxparc.pokedex.ui.egggroups.components.EggGroupChip;
import com.xeroxparc.pokedex.ui.egggroups.constants.EggGroupType;
import com.xeroxparc.pokedex.ui.egggroups.fragments.details.EggGroupDetailsLoader;
import com.xeroxparc.pokedex.ui.egggroups.fragments.details.EggGroupDetailsNavigationRequester;
import com.xeroxparc.pokedex.ui.egggroups.lists.adapters.EggGroupSpeciesListFilter;
import com.xeroxparc.pokedex.ui.egggroups.lists.adapters.EggGroupSpeciesListFilter.FilterMode;
import com.xeroxparc.pokedex.ui.egggroups.lists.adapters.PostFilteringCallBack;
import com.xeroxparc.pokedex.ui.egggroups.lists.adapters.TypeAndTextFilterable;
import com.xeroxparc.pokedex.ui.egggroups.lists.viewholders.EggGroupPokemonViewHolder;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class EggGroupPokemonListAdapter extends RecyclerView.Adapter<EggGroupPokemonViewHolder>
        implements TypeAndTextFilterable, PostFilteringCallBack<List<PokemonSpecies>>, OnClickListener {
    private static final int BIG_BATCH_SIZE = 5;
    private static final int SMALL_BATCH_SIZE = 2;
    private Context ctx;
    private EggGroupDetailsLoader detailsLoader;
    private EggGroupDetailsNavigationRequester navigationRequester;
    private List<PokemonSpecies> simpleSpeciesList;
    private List<PokemonSpecies> filteredList;
    private Map<String, Pokemon> pokemonMap;
    private Map<String, Boolean> loadingMap;
    private Map<String, PokemonSpecies> detailedSpecies;


    public EggGroupPokemonListAdapter(Context context, EggGroupDetailsLoader loader,
                                      List<PokemonSpecies> rawSpecies,
                                      Map<String, PokemonSpecies> detailedSpeciesMap,
                                      Map<String, Pokemon> detailedPokemonMap,
                                      Map<String, Boolean> loadingStatusMap,
                                      EggGroupDetailsNavigationRequester navigationRequester) {
        ctx = context;
        filteredList = new ArrayList<>();
        loadingMap = loadingStatusMap;
        pokemonMap = detailedPokemonMap;
        simpleSpeciesList = rawSpecies;
        filteredList.addAll(rawSpecies);
        detailedSpecies = detailedSpeciesMap;
        detailsLoader = loader;
        this.navigationRequester = navigationRequester;
    }

    @NonNull
    @Override
    public EggGroupPokemonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        ItemRowEggGroupPokemonBinding pokemonBinding = ItemRowEggGroupPokemonBinding.inflate(inflater, parent, false);
        return new EggGroupPokemonViewHolder(pokemonBinding, navigationRequester);
    }

    @Override
    public void onBindViewHolder(@NonNull EggGroupPokemonViewHolder holder, int position) {
        loadBatchIfNeeded(position, BIG_BATCH_SIZE);
        holder.resetImage();
        holder.resetEggGroups();
        holder.resetPokemonId();
        PokemonSpecies specie = filteredList.get(position);
        String specieName = specie.getName();
        holder.setPokemonName(specieName);
        if (pokemonMap.get(specieName) != null) {
            holder.setPokemonId(pokemonMap.get(specieName).getId());
            String imageUrl = Objects.
                    requireNonNull(pokemonMap.get(specieName)).
                    getSprite().getFrontDefault();
            Glide.with(ctx).
                    load(imageUrl).
                    into(holder.getImage());

            Objects.
                    requireNonNull(detailedSpecies.get(specieName)).
                    getEggGroupsList().forEach(eggGroup -> {
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
        if (loadingStatus == null && filteredList.size() > currentPosition) {
            PokemonSpecies specie = filteredList.get(currentPosition);
            detailsLoader.loadDetailedSpecieInAdapter(specie.getId(), currentPosition);
            loadingMap.put(specie.getName(), false);
        }
    }

    public void addImage(String specieName, Pokemon pokemon, int position) {
        pokemonMap.put(specieName, pokemon);
        loadingMap.put(specieName, true);
        if (filteredList.size() != simpleSpeciesList.size()) {
            filteredList.parallelStream().filter(specie -> specie.getName().equalsIgnoreCase(specieName)
            ).findFirst().ifPresent(foundSpecie -> notifyItemChanged(simpleSpeciesList.indexOf(foundSpecie)));
        } else {
            notifyItemChanged(position);
        }


        int starterPositionFlag = position - SMALL_BATCH_SIZE;
        if (starterPositionFlag > 0 && starterPositionFlag < filteredList.size()
                && detailedSpecies.get(filteredList.get(starterPositionFlag).getName()) != null) {
            loadBatchIfNeeded(position, SMALL_BATCH_SIZE);
        }
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
        }
    }

    @Override
    public Filter getFilter(FilterMode filterMode) {
        return new EggGroupSpeciesListFilter(simpleSpeciesList, detailedSpecies, filterMode, this);
    }
}