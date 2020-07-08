package com.xeroxparc.pokedex.ui.pokedex.detail.moves;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.xeroxparc.pokedex.data.Pokemon;

import java.util.List;
/**
 *
 *
 * @author Palmieri Ivan
 */
public abstract class PokemonMovesListAdapter  extends RecyclerView.Adapter<PokemonMovesListAdapter.PokemonMovesViewHolder> {

    private List<Pokemon> pokemonList;

    abstract void onClickCallback(Pokemon pokemon);

    @NonNull
    @Override
    public PokemonMovesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new PokemonMovesViewHolder(new PokemonMovesListItemBinder(parent.getContext(), parent, false));
    }

    @Override
    public int getItemCount() {
        return (pokemonList != null) ? pokemonList.size() : 0;
    }


    @Override
    public void onBindViewHolder(@NonNull PokemonMovesViewHolder holder, int position) {
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

    static class PokemonMovesViewHolder extends RecyclerView.ViewHolder {

        final PokemonMovesListItemBinder binder;

        PokemonMovesViewHolder(@NonNull PokemonMovesListItemBinder binder) {
            super(binder.getRoot());
            this.binder = binder;
        }
    }


}
