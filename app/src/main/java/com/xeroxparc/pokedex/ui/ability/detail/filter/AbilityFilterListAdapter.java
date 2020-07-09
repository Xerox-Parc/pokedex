package com.xeroxparc.pokedex.ui.ability.detail.filter;

import android.content.Context;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.xeroxparc.pokedex.data.model.pokemon.Pokemon;

import java.util.ArrayList;
import java.util.List;

public abstract class AbilityFilterListAdapter  extends RecyclerView.Adapter<AbilityFilterListAdapter.AbilityFilterViewHolder> {
    private List<Pokemon> pokemonList = new ArrayList<>();
    private Context ctx;

    public AbilityFilterListAdapter(Context ctx) {
        this.ctx = ctx;
    }

    abstract void onClickCallback(Pokemon pokemon);

    @NonNull
    @Override
    public AbilityFilterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new AbilityFilterViewHolder(new AbilityFilterListItemBinder(parent.getContext(), parent, false));
    }

    @Override
    public int getItemCount() {
        return (pokemonList != null) ? pokemonList.size() : 0;
    }


    @Override
    public void onBindViewHolder(@NonNull AbilityFilterViewHolder holder, int position) {
        if (pokemonList != null) {
            Pokemon pokemon = pokemonList.get(position);
            holder.binder.bind();
            holder.binder.getNameView().setText(pokemon.getName());
            Glide.with(ctx).load(pokemon.getSprite().getFrontDefault()).into(holder.binder.getImageView());
            holder.binder.getRoot().setOnClickListener(c -> onClickCallback(pokemon));
        }
    }

    void addPokemon(Pokemon pokemon) {
        pokemonList.add(pokemon);
        notifyItemInserted(pokemonList.size());
    }

    static class AbilityFilterViewHolder extends RecyclerView.ViewHolder {

        final AbilityFilterListItemBinder binder;

        AbilityFilterViewHolder(@NonNull AbilityFilterListItemBinder binder) {
            super(binder.getRoot());
            this.binder = binder;
        }


    }


}
