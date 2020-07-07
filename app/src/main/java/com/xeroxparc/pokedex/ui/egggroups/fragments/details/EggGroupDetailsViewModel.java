package com.xeroxparc.pokedex.ui.egggroups.fragments.details;

import android.app.Application;

import com.xeroxparc.pokedex.data.model.pokemon.Pokemon;
import com.xeroxparc.pokedex.data.model.pokemon.egggroup.EggGroup;
import com.xeroxparc.pokedex.data.model.pokemon.species.PokemonSpecies;
import com.xeroxparc.pokedex.data.repository.EggGroupsRepository;
import com.xeroxparc.pokedex.data.repository.PokemonRepository;
import com.xeroxparc.pokedex.data.repository.SpeciesRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;

public class EggGroupDetailsViewModel extends AndroidViewModel {
    private static final String TAG = "EggGroupDetailsViewMode";
    private final LiveData<Optional<EggGroup>> eggGroup;
    private final MutableLiveData<Integer> eggGroupId;
    private final LiveData<List<Optional<PokemonSpecies>>> speciesList;
    private final LiveData<List<LiveData<Optional<Pokemon>>>> pokemonList;

    public EggGroupDetailsViewModel(@NonNull Application application) {
        super(application);
        final EggGroupsRepository eggGroupsRepository = new EggGroupsRepository(application);
        final SpeciesRepository speciesRepository = new SpeciesRepository(application);
        final PokemonRepository pokemonRepository = new PokemonRepository(application);
        eggGroupId = new MutableLiveData<>();
        MutableLiveData<List<Integer>> pokemonIdList = new MutableLiveData<>();
        eggGroup = Transformations.switchMap(eggGroupId, eggGroupsRepository::getEggGroup);
        pokemonList = Transformations.switchMap(pokemonIdList, list -> {
            List<LiveData<Optional<Pokemon>>> pokemon = new ArrayList<>();
            list.parallelStream()
                    .forEach(id -> pokemon.add(pokemonRepository.getPokemon(id)));
            return new MutableLiveData<>(pokemon);
        });

        speciesList = Transformations.switchMap(eggGroup, eggGroup -> {
//            List<LiveData<Optional<PokemonSpecies>>> species = new ArrayList<>();
            return speciesRepository.getSpeciesByEggGroup(eggGroup);
//            eggGroup.
//                    map(EggGroup::getPokemonSpeciesList).
//                    get().
//                    parallelStream().forEach(
//                    currentSpecie -> {
//                        LiveData<Optional<PokemonSpecies>> newSpecies = speciesRepository.getSpecie(currentSpecie.getId());
////                        newSpecies.getValue().ifPresent(species1 ->
////                                Log.e(TAG, "EggGroupDetailsViewModel: " + species1));
////                        species.add(speciesRepository.getSpecie(currentSpecie.getId()));
//
                    }
            );

//            return new MutableLiveData<>(species);
//            eggGroup.
//                    map(EggGroup::getPokemonSpeciesList).
//                    get().
//                    parallelStream().
//                    map(PokemonSpecies::getId).
//                    map(speciesRepository::getSpecie).
//                    map(LiveData::getValue).
//                    filter(Objects::nonNull).
//                    forEach(specieOptional ->
//                    {
//                        Log.e(TAG, "EggGroupDetailsViewModel: ");
//                        Objects.requireNonNull(specieOptional).ifPresent(species::add);
//                    });
//            Objects.requireNonNull(this.eggGroup.getValue()).get().setPokemonSpeciesList(species);
//        });
    }

    public void setEggGroupId(int id) {
        eggGroupId.setValue(id);
    }

    public LiveData<Optional<EggGroup>> getEggGroup() {
        return eggGroup;
    }

    public LiveData<List<Optional<PokemonSpecies>>> getSpeciesList() {
        return speciesList;
    }

    public LiveData<List<LiveData<Optional<Pokemon>>>> getPokemonList() {
        return pokemonList;
    }
}
