package com.xeroxparc.pokedex.data;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.xeroxparc.pokedex.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PokemonRepository {
    private final List<String> pokemonNameList;


    public PokemonRepository(@NonNull Application application) {
        pokemonNameList = Arrays.asList(application.getResources().getStringArray(R.array.pokemon));
    }

    @NonNull
    public LiveData<List<Pokemon>> getAllComponentList() {
        List<Pokemon> listPokemon = new ArrayList<>();
        Pokemon pokemon;
        for (String pokemonName : pokemonNameList) {
            pokemon = new Pokemon();
            pokemon.setName(pokemonName);
            listPokemon.add(pokemon);
        }
        return new MutableLiveData<>(listPokemon);
    }

    @NonNull
    public LiveData<List<Pokemon>> getComponentListByName(@NonNull String name) {
        List<Pokemon> listPokemon = new ArrayList<>();
        Pokemon pokemon;
        for (String pokemonName : pokemonNameList) {
            if (pokemonName.toLowerCase().contains(name.toLowerCase())) {
                pokemon = new Pokemon();
                pokemon.setName(pokemonName);
                listPokemon.add(pokemon);
            }
        }
        return new MutableLiveData<>(listPokemon);
    }
    @NonNull
    public LiveData<List<Pokemon>> getComponentListByPrefer() {
        List<Pokemon> listPokemon = new ArrayList<>();
        Pokemon pokemon;
        for (String pokemonName : pokemonNameList) {
                pokemon = new Pokemon();
                if(pokemon.getPrefer()) {
                    pokemon.setName(pokemonName);
                    listPokemon.add(pokemon);
                }
                else{
                    listPokemon.remove(pokemon);
                }
        }
        return new MutableLiveData<>(listPokemon);
    }
}
