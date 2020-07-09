package com.xeroxparc.pokedex.data.repository;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.xeroxparc.pokedex.R;
import com.xeroxparc.pokedex.data.database.dao.pokemon.PokemonDao;
import com.xeroxparc.pokedex.data.model.pokemon.Pokemon;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PagedList;

import retrofit2.HttpException;

public class PokemonRepository extends BaseRepository {
    private static final String TAG = "PokemonRepository";
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
            if (pokemon.isFavourite()) {
                pokemon.setName(pokemonName);
                listPokemon.add(pokemon);
            } else {
                listPokemon.remove(pokemon);
            }
        }
        return new MutableLiveData<>(listPokemon);
    }

    public LiveData<PagedList<Pokemon>> getPokemonList() {
        AsyncTask.execute(() -> {
            if (database.pokemonDao().getPagedList() == null) {
                try {
                    database.pokemonDao().insert(
                            service.getPokemonList(-1, 0).result().getResults()
                    );
                } catch (IOException | HttpException e) {
                    e.printStackTrace();
                }
            }
        });
        return new LivePagedListBuilder<>(
                database.pokemonDao().getPagedList(),
                new PagedList.Config.Builder()
                        .setPageSize(15)
                        .setPrefetchDistance(100)
                        .setEnablePlaceholders(true)
                        .build()
        ).build();
    }

    public void fetchPokemonList() {
        AsyncTask.execute(() -> {
            List<Pokemon> list;
            try {
                database.pokemonDao().insert(
                        service.getPokemonList(-1, 0).result().getResults()
                );
            } catch (IOException | HttpException e) {
                e.printStackTrace();
            }
        });
    }


}
