package com.xeroxparc.pokedex.data.repository;

import android.content.Context;
import android.os.AsyncTask;

import com.xeroxparc.pokedex.R;
import com.xeroxparc.pokedex.data.database.dao.pokemon.PokemonDao;
import com.xeroxparc.pokedex.data.model.pokemon.Pokemon;
import com.xeroxparc.pokedex.data.remote.ApiError;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

public class PokemonRepository extends BaseRepository {
    private PokemonDao pokemonDao;
    private final List<String> pokemonNameList;
    public PokemonRepository(Context context) {
        super(context);
        pokemonDao = database.pokemonDao();
        pokemonNameList = Arrays.asList(context.getResources().getStringArray(R.array.pokemon));
    }

    public LiveData<Optional<Pokemon>> getPokemon(int id) {
        MutableLiveData<Optional<Pokemon>> pokemon = new MutableLiveData<>();
        AsyncTask.execute(() -> {
            if (pokemonDao.getPokemon(id) == null) {
                try {
                    pokemonDao.insert(apiService.getPokemon(id));
                } catch (IOException | ApiError e) {
                    e.printStackTrace();
                }
            }
            pokemon.postValue(Optional.ofNullable(pokemonDao.getPokemon(id)));
        });
        return pokemon;
    }


    @NonNull
    public LiveData<List<com.xeroxparc.pokedex.data.Pokemon>> getAllComponentList() {
        List<com.xeroxparc.pokedex.data.Pokemon> listPokemon = new ArrayList<>();
        com.xeroxparc.pokedex.data.Pokemon pokemon;
        for (String pokemonName : pokemonNameList) {
            pokemon = new com.xeroxparc.pokedex.data.Pokemon();
            pokemon.setName(pokemonName);
            listPokemon.add(pokemon);
        }
        return new MutableLiveData<>(listPokemon);
    }

    @NonNull
    public LiveData<List<com.xeroxparc.pokedex.data.Pokemon>> getComponentListByName(@NonNull String name) {
        List<com.xeroxparc.pokedex.data.Pokemon> listPokemon = new ArrayList<>();
        com.xeroxparc.pokedex.data.Pokemon pokemon;
        for (String pokemonName : pokemonNameList) {
            if (pokemonName.toLowerCase().contains(name.toLowerCase())) {
                pokemon = new com.xeroxparc.pokedex.data.Pokemon();
                pokemon.setName(pokemonName);
                listPokemon.add(pokemon);
            }
        }
        return new MutableLiveData<>(listPokemon);
    }
    @NonNull
    public LiveData<List<com.xeroxparc.pokedex.data.Pokemon>> getComponentListByPrefer() {
        List<com.xeroxparc.pokedex.data.Pokemon> listPokemon = new ArrayList<>();
        com.xeroxparc.pokedex.data.Pokemon pokemon;
        for (String pokemonName : pokemonNameList) {
            pokemon = new com.xeroxparc.pokedex.data.Pokemon();
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
