package com.xeroxparc.pokedex.ui.pokedex.detail;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.xeroxparc.pokedex.R;
import com.xeroxparc.pokedex.data.model.pokemon.Pokemon;
import com.xeroxparc.pokedex.data.repository.PokemonRepository;

/**
 *
 *
 * @author Palmieri Ivan
 */
public class PokemonAboutFragment extends Fragment {
    Pokemon currentPokemon;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,@Nullable Bundle savedInstanceState) {
        int pokeId = PokemonAboutFragmentArgs.fromBundle(requireArguments()).getPokemonId();
        Log.d("About InfoPokemon", String.valueOf(pokeId));
        PokemonRepository pokemonRepository = new PokemonRepository(requireContext());
        pokemonRepository.getPokemon(pokeId).observe(getViewLifecycleOwner(), pokemon -> {
            pokemon.ifPresent(retrievedPokemon -> {
                currentPokemon = retrievedPokemon;

                /*Dichiaro le variabili*/
                TextView pokemonHeight = getView().findViewById(R.id.text_view_pokemon_height_value);//Height
                TextView pokemonWeight = getView().findViewById(R.id.text_view_pokemon_weight_value);//Weight


                pokemonHeight.setText(String.valueOf(currentPokemon.getHeight()));/*Funziona*/
                pokemonWeight.setText(String.valueOf(currentPokemon.getWeight()));/*Non funziona*/


            });
        });
        return inflater.inflate(R.layout.fragment_pokemon_about, container, false);
    }

}