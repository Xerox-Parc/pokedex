package com.xeroxparc.pokedex.ui.pokedex.detail.moves;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.xeroxparc.pokedex.databinding.ItemPokemonMovesBinding;
/**
 *
 *
 * @author Palmieri Ivan
 */
public class PokemonMovesListItemBinder {
    private final ItemPokemonMovesBinding binding;

    PokemonMovesListItemBinder(Context context, ViewGroup root, Boolean attachToRoot){
        binding = ItemPokemonMovesBinding.inflate(LayoutInflater.from(context), root, attachToRoot);
    }



    View getRoot(){
        return binding.getRoot();
    }

    void bind() {

    }
}
