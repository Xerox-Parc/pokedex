package com.xeroxparc.pokedex.ui.egggroups.fragments.details;

import android.app.Application;

import com.xeroxparc.pokedex.data.model.pokemon.Pokemon;
import com.xeroxparc.pokedex.data.model.pokemon.egggroup.EggGroup;
import com.xeroxparc.pokedex.data.model.pokemon.species.PokemonSpecies;
import com.xeroxparc.pokedex.data.repository.EggGroupsRepository;
import com.xeroxparc.pokedex.data.repository.PokemonRepository;
import com.xeroxparc.pokedex.data.repository.SpeciesRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
/*
 * Encapsulated the Egg Group Details Data, and provides methods to request data
 *
 * @author Abdelrahman Abdelrahman (CptPackage)
 * */
public class EggGroupDetailsViewModel extends AndroidViewModel {
    private static final String TAG = "EggGroupDetailsViewMode";
    private final SpeciesRepository speciesRepository;
    private final PokemonRepository pokemonRepository;
    private final LiveData<Optional<EggGroup>> eggGroup;
    private final MutableLiveData<Integer> eggGroupId;
    private final List<PokemonSpecies> rawSpeciesList;
    private final HashMap<String, Pokemon> pokemonMap;
    private final Map<String, PokemonSpecies> detailedSpeciesMap;
    private final Map<String, Boolean> loadingMap;


    public EggGroupDetailsViewModel(@NonNull Application application) {
        super(application);
        final EggGroupsRepository eggGroupsRepository = new EggGroupsRepository(application);
        speciesRepository = new SpeciesRepository(application);
        pokemonRepository = new PokemonRepository(application);
        pokemonMap = new HashMap<>();
        loadingMap = new HashMap<>();
        rawSpeciesList = new ArrayList<>();
        detailedSpeciesMap = new HashMap<>();
        eggGroupId = new MutableLiveData<>();
        eggGroup = Transformations.switchMap(eggGroupId, eggGroupsRepository::getEggGroup);
    }

    public void setEggGroupId(int id) {
        eggGroupId.setValue(id);
    }

    public LiveData<Optional<EggGroup>> getEggGroup() {
        return eggGroup;
    }

    public Map<String, Pokemon> getPokemonMap() {
        return pokemonMap;
    }

    public Map<String, Boolean> getLoadingMap() {
        return loadingMap;
    }

    public List<PokemonSpecies> getRawSpeciesList() {
        return rawSpeciesList;
    }

    public Map<String, PokemonSpecies> getDetailedSpeciesMap() {
        return detailedSpeciesMap;
    }

    public LiveData<Optional<PokemonSpecies>> getSpecie(int id) {
        return speciesRepository.getSpecie(id);
    }

    public LiveData<Optional<Pokemon>> getPokemon(int id) {
        return pokemonRepository.getPokemon(id);
    }
}
