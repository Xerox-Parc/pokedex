package com.xeroxparc.pokedex.data.repository;

import android.content.Context;
import android.os.AsyncTask;

import com.xeroxparc.pokedex.data.database.dao.pokemon.PokemonSpeciesDao;
import com.xeroxparc.pokedex.data.model.pokemon.egggroup.EggGroup;
import com.xeroxparc.pokedex.data.model.pokemon.species.PokemonSpecies;
import com.xeroxparc.pokedex.data.remote.ApiError;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

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
                    speciesDao.insert(apiService.getPokemonSpecies(id));
                } catch (IOException | ApiError e) {
                    e.printStackTrace();
                }
            }
            specie.postValue(Optional.ofNullable(speciesDao.getPokemonSpecies(id)));
        });
        return specie;
    }

    public LiveData<List<Optional<PokemonSpecies>>> getSpeciesByEggGroup(Optional<EggGroup> eggGroup) {
        MutableLiveData<List<Optional<PokemonSpecies>>> species = new MutableLiveData<>(Collections.emptyList());
        if (eggGroup.isPresent()) {
            List<Integer> idList = eggGroup.get()
                    .getPokemonSpeciesList()
                    .stream()
                    .map(PokemonSpecies::getId)
                    .collect(Collectors.toList());

            idList.forEach(id -> {
                AsyncTask.execute(() -> {
                    if (speciesDao.getPokemonSpecies(id) == null) {
                        try {
                            speciesDao.insert(apiService.getPokemonSpecies(id));
                        } catch (IOException | ApiError e) {
                            e.printStackTrace();
                        }
                    }
                    List<Optional<PokemonSpecies>> currentSpecies = species.getValue();
                    if (currentSpecies != null) {
                        currentSpecies.add(Optional.ofNullable(speciesDao.getPokemonSpecies(id)));
                    }
                    species.postValue(currentSpecies);
                });
            });
        }
        return species;
    }


}
