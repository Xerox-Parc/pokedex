package com.xeroxparc.pokedex.data.repository;

import android.content.Context;
import android.os.AsyncTask;

import com.xeroxparc.pokedex.data.database.dao.pokemon.PokemonDao;
import com.xeroxparc.pokedex.data.model.pokemon.Pokemon;

import java.io.IOException;
import java.util.Optional;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import retrofit2.HttpException;

public class PokemonRepository extends BaseRepository {
    private PokemonDao pokemonDao;

    public PokemonRepository(Context context) {
        super(context);
        pokemonDao = database.pokemonDao();
    }


    public LiveData<Optional<Pokemon>> getPokemon(int id) {
        MutableLiveData<Optional<Pokemon>> pokemon = new MutableLiveData<>();
        AsyncTask.execute(() -> {
            if (pokemonDao.getPokemon(id) == null) {
                try {
                    pokemonDao.insert(service.getPokemon(id).result());
                } catch (IOException | HttpException e) {
                    e.printStackTrace();
                }
            }
            pokemon.postValue(Optional.ofNullable(pokemonDao.getPokemon(id)));
        });
        return pokemon;
    }

    public void updatePokemon(Pokemon pokemon) {
        AsyncTask.execute(() -> pokemonDao.insert(pokemon));
    }

}
