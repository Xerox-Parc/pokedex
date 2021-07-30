package com.xeroxparc.pokedex.ui.ability.detail;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.xeroxparc.pokedex.ui.ability.detail.filter.AbilityFilterFragment;

public class AbilityPagerAdapter extends FragmentStateAdapter implements PokemonDetailsNavigationRequester {

    private int abilityId = 0;

    private final PokemonDetailsNavigator pokemonDetailsNavigator;

    public AbilityPagerAdapter(Fragment fragment, int abilityId, PokemonDetailsNavigator detailsNavigator) {
        super(fragment);
        this.abilityId = abilityId;
        this.pokemonDetailsNavigator = detailsNavigator;
    }

    public AbilityPagerAdapter(Fragment fragment, PokemonDetailsNavigator pokemonDetailsNavigator) {
        super(fragment);
        this.pokemonDetailsNavigator = pokemonDetailsNavigator;
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        // Return a NEW fragment instance in createFragment(int)
        Fragment fragment;
        Bundle args = new Bundle();
        if (position == 1) {
            fragment = new AbilityFilterFragment(this);
        } else {
            fragment = new AbilityDetailedFragment();
        }

        // Our object is just an integer :-P
        args.putInt(AbilityDetailedFragment.ARG_OBJECT, abilityId);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getItemCount() {
        return 2;
    }

    @Override
    public void requestNavigationToPokemonDetails(int pokemonId) {
        pokemonDetailsNavigator.navigateToPokemonDetails(pokemonId);
    }
}