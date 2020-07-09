package com.xeroxparc.pokedex.ui.home;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;

import com.xeroxparc.pokedex.data.model.pokemon.Pokemon;
import com.xeroxparc.pokedex.databinding.ItemPokemonBinding;

public class PokemonItemBinder {

	private ItemPokemonBinding binding;

	PokemonItemBinder(Context context, ViewGroup root, Boolean attachToRoot){
		binding = ItemPokemonBinding.inflate(LayoutInflater.from(context), root, attachToRoot);
	}

	View getRoot(){
		return binding.getRoot();
	}

	void clear() {
		//binding = null;
	}

	void bind(@NonNull Pokemon pokemon) {
		binding.textView.setText(pokemon.getName());
	}

}
