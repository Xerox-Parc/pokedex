package com.xeroxparc.pokedex.ui.pokedex.detail.evolution;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.xeroxparc.pokedex.data.Pokemon;

import java.util.List;

public abstract class PokemonEvolutionListAdapter  extends RecyclerView.Adapter<PokemonEvolutionListAdapter.PokemonEvolutionViewHolder> {

    private List<Pokemon> pokemonList;

    abstract void onClickCallback(Pokemon pokemon);

    @NonNull
    @Override
    public PokemonEvolutionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new PokemonEvolutionViewHolder(new PokemonEvolutionListItemBinder(parent.getContext(), parent, false));
    }

    @Override
    public int getItemCount() {
        return (pokemonList != null) ? pokemonList.size() : 0;
    }

    @Override
    public void onBindViewHolder(@NonNull PokemonEvolutionViewHolder holder, int position) {
        if (pokemonList != null) {
            Pokemon pokemon = pokemonList.get(position);
            holder.binder.bind();
            holder.binder.getRoot().setOnClickListener(c -> onClickCallback(pokemon));
        }
    }

    void setComponentList(List<Pokemon> componentList) {
        this.pokemonList = componentList;
        notifyDataSetChanged();
    }

    static class PokemonEvolutionViewHolder extends RecyclerView.ViewHolder {

        final PokemonEvolutionListItemBinder binder;

        PokemonEvolutionViewHolder(@NonNull PokemonEvolutionListItemBinder binder) {
            super(binder.getRoot());
            this.binder = binder;
        }
    }
}