package com.xeroxparc.pokedex.ui.ability.detail.filter;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.xeroxparc.pokedex.data.model.pokemon.Pokemon;
import com.xeroxparc.pokedex.databinding.FragmentAbilityFilterBinding;
import com.xeroxparc.pokedex.ui.ability.detail.PokemonDetailsNavigationRequester;

public class AbilityFilterBinder {
    private final FragmentAbilityFilterBinding binding;
    private final AbilityFilterFragment fragment;
    private final AbilityFilterViewModel viewModel;
    private int abilityId;
    private PokemonDetailsNavigationRequester detailsNavigationRequester;


    AbilityFilterBinder(@NonNull AbilityFilterFragment fragment, int abilityId, PokemonDetailsNavigationRequester detailsNavigationRequester) {
        this(fragment);
        this.abilityId = abilityId;
        this.detailsNavigationRequester = detailsNavigationRequester;
    }

    AbilityFilterBinder(@NonNull AbilityFilterFragment fragment) {
        this.fragment = fragment;
        binding = FragmentAbilityFilterBinding.inflate(fragment.getLayoutInflater());
        viewModel = new ViewModelProvider(fragment).get(AbilityFilterViewModel.class);
    }

    View getRoot() {
        return binding.getRoot();
    }

    void bind() {

        final AbilityFilterListAdapter componentListAdapter = new AbilityFilterListAdapter(fragment.getContext()) {
            @Override
            void onClickCallback(Pokemon pokemon) {
                showDetail(pokemon);
            }
        };
        binding.recyclerViewFilter.setAdapter(componentListAdapter);
        binding.recyclerViewFilter.setLayoutManager(new LinearLayoutManager(fragment.getContext()));
        viewModel.getAbility(abilityId).observe(fragment.getViewLifecycleOwner(), ability -> {
            ability.ifPresent(retrievedAbility -> {
                retrievedAbility.getPokemonList().forEach(rawPokemon -> {
                    viewModel.getPokemon(rawPokemon.getPokemon().getId()).observe(fragment.getViewLifecycleOwner(), detailedPokemon -> {
                                detailedPokemon.ifPresent(componentListAdapter::addPokemon);
                            });
                });
            });
        });
    }

    private void showDetail(@NonNull Pokemon pokemon) {
        detailsNavigationRequester.requestNavigationToPokemonDetails(pokemon.getId());
    }


}
