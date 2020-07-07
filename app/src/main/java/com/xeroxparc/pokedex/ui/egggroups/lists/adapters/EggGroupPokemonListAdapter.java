package com.xeroxparc.pokedex.ui.egggroups.lists.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;

import com.xeroxparc.pokedex.data.model.pokemon.species.PokemonSpecies;
import com.xeroxparc.pokedex.databinding.ItemRowEggGroupPokemonBinding;
import com.xeroxparc.pokedex.ui.egggroups.lists.viewholders.EggGroupPokemonViewHolder;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class EggGroupPokemonListAdapter extends RecyclerView.Adapter<EggGroupPokemonViewHolder> implements Filterable, PostFilteringCallBack<List<PokemonSpecies>> {
    private static final String TAG = "EggGroupPokemonListAdap";
    private List<PokemonSpecies> speciesList;
    private List<PokemonSpecies> filteredList = new ArrayList<>();
    private Context ctx;

    public EggGroupPokemonListAdapter(Context context, List<PokemonSpecies> species) {
        ctx = context;
        speciesList = species;
        filteredList.addAll(species);
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
//            Glide.with(ctx).load(images.get(specieName)).into(holder.getImage());
//        Glide.with(ctx).load(Utils.imgFromSpecie(specie)).into(holder.getImage());
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
}