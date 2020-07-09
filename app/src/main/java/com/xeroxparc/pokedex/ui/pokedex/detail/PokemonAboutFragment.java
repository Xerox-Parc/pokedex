package com.xeroxparc.pokedex.ui.pokedex.detail;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;
import com.xeroxparc.pokedex.R;
import com.xeroxparc.pokedex.data.model.pokemon.Pokemon;
import com.xeroxparc.pokedex.data.model.pokemon.PokemonType;
import com.xeroxparc.pokedex.data.repository.PokemonRepository;
import com.xeroxparc.pokedex.ui.egggroups.constants.EggGroupType;
import com.xeroxparc.pokedex.utils.Utils;

import java.util.List;

/**
 *
 *
 * @author Palmieri Ivan
 */
public class PokemonAboutFragment extends Fragment {

    public static final String ARG_OBJECT = "object";
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
                TextView pokemonHeight = getView().findViewById(R.id.textView15);//Height
                TextView pokemonWeight = getView().findViewById(R.id.textView16);//Weight
               // TextView pokemonDescription = getView().getRootView().findViewById(R.id.textView5);//Descriptor

                pokemonHeight.setText("ciao");/*Funziona*/
                //pokemonWeight.setText(currentPokemon.getWeight());/*Non funziona*/


            });
        });
        return inflater.inflate(R.layout.fragment_pokemon_about, container, false);
    }

}