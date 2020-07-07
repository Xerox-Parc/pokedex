package com.xeroxparc.pokedex.ui.egggroups.lists.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;

import com.bumptech.glide.Glide;
import com.xeroxparc.pokedex.data.model.pokemon.species.PokemonSpecies;
import com.xeroxparc.pokedex.databinding.ItemRowEggGroupPokemonBinding;
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
    private Context ctx;

    public EggGroupPokemonListAdapter(Context context, List<PokemonSpecies> species) {
        ctx = context;
        speciesList = species;
        filteredList.addAll(species);
        imagesMap = new HashMap<>();
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
        PokemonSpecies specie = filteredList.get(position);
        String specieName = specie.getName();
        holder.setPokemonName(specieName);
        if (imagesMap.get(specieName) != null) {
            Glide.with(ctx).load(imagesMap.get(specieName)).into(holder.getImage());
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

    public void addImage(String specieName, String imageUrl) {
        imagesMap.put(specieName, imageUrl);
        speciesList.
                parallelStream().
                filter(current -> current.getName().equalsIgnoreCase(specieName)).
                findFirst().
                ifPresent(specie -> {
                    notifyItemChanged(speciesList.indexOf(specie));
                });
    }

    public void addSpecie(PokemonSpecies newSpecie){
        speciesList.
                parallelStream().
                filter(current -> current.getName().equalsIgnoreCase(newSpecie.getName())).
                findFirst().
                ifPresent(specie -> {
                    int index = speciesList.indexOf(specie);
                    speciesList.set(index,newSpecie);
                    notifyItemChanged(index);
                });
    }
}