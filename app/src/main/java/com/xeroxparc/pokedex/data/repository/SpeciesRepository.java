package com.xeroxparc.pokedex.data.repository;

import android.content.Context;
import android.os.AsyncTask;

import com.xeroxparc.pokedex.data.database.dao.pokemon.PokemonSpeciesDao;
import com.xeroxparc.pokedex.data.model.pokemon.species.PokemonSpecies;

import java.io.IOException;
import java.util.Optional;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import retrofit2.HttpException;

/*
 *
 *
 * @author Abdelrahman Abdelrahman (CptPackage)
 * */
public class SpeciesRepository extends BaseRepository {
    private PokemonSpeciesDao speciesDao;

    public SpeciesRepository(Context context) {
        super(context);
        speciesDao = database.pokemonSpeciesDao();
    }

    public LiveData<Optional<PokemonSpecies>> getSpecie(int id) {
        MutableLiveData<Optional<PokemonSpecies>> specie = new MutableLiveData<>();
        AsyncTask.execute(() -> {
            if (speciesDao.getPokemonSpecies(id) == null) {
                try {
                    speciesDao.insert(service.getPokemonSpecies(id).result());
                } catch (IOException | HttpException e) {
                    e.printStackTrace();
                }
            }
            specie.postValue(Optional.ofNullable(speciesDao.getPokemonSpecies(id)));
        });
        return specie;
    }
}
