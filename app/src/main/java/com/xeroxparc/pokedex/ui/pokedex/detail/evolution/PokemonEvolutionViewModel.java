package com.xeroxparc.pokedex.ui.pokedex.detail.evolution;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.xeroxparc.pokedex.data.repository.PokemonRepository;

/**
 *
 *
 * @author Palmieri Ivan
 */
public class PokemonEvolutionViewModel extends AndroidViewModel {


    private final PokemonRepository repository;

    private final MutableLiveData<String> filterPokemonName;

//    private final LiveData<List<Pokemon>> listPokemon;

    public PokemonEvolutionViewModel(@NonNull Application application) {
        super(application);
        repository = new PokemonRepository(application);
        filterPokemonName = new MutableLiveData<>("");
//        listPokemon = Transformations.switchMap(filterPokemonName, name -> name.isEmpty()?
//                repository.getAllComponentList() :
//                repository.getComponentListByName(name));
    }



//     public LiveData<List<Pokemon>> getListComponent() { return listPokemon; }



}
