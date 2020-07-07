package com.xeroxparc.pokedex.ui.pokedex.detail.evolution;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.xeroxparc.pokedex.databinding.ItemPokemonEvolutionBinding;

public class PokemonEvolutionListItemBinder {

    private final ItemPokemonEvolutionBinding binding;

    PokemonEvolutionListItemBinder(Context context, ViewGroup root, Boolean attachToRoot){
        binding = ItemPokemonEvolutionBinding.inflate(LayoutInflater.from(context), root, attachToRoot);
    }



    View getRoot(){
        return binding.getRoot();
    }

    void bind() {

        binding.textView31.setText("Level");
        /*binding.imageView2.setImageResource(R.drawable.pngguru);
        binding.imageView4.setImageResource(R.drawable.pngguru);*/

    }
}
