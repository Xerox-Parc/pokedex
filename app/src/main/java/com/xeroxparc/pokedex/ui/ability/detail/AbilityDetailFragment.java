package com.xeroxparc.pokedex.ui.ability.detail;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.xeroxparc.pokedex.R;
import com.xeroxparc.pokedex.ui.egggroups.fragments.details.EggGroupDetailsFragmentDirections;


public class AbilityDetailFragment extends Fragment implements PokemonDetailsNavigator {
    AbilityPagerAdapter viewPagerAdapter;
    ViewPager2 viewPager;
    String[] string = {"Ability", "Pokemon With This Ability"};

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_ability_detail, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        int abilityId = AbilityDetailFragmentArgs.fromBundle(requireArguments()).getAbilityId();
        viewPagerAdapter = new AbilityPagerAdapter(this, abilityId, this);
        viewPager = view.findViewById(R.id.view_pager_ability);
        viewPager.setAdapter(viewPagerAdapter);
        TabLayout tabLayoutDetail = view.findViewById(R.id.tab_layout_ability_detail);
        new TabLayoutMediator(tabLayoutDetail, viewPager, (tab, position) -> tab.setText(string[position])).attach();
    }

    @Override
    public void navigateToPokemonDetails(int pokemonId) {
        AbilityDetailFragmentDirections.ActionNavAbilityDetailToNavPokemonDetail action = AbilityDetailFragmentDirections.actionNavAbilityDetailToNavPokemonDetail();
        action.setPokemonId(pokemonId);
        Navigation.findNavController(requireView()).
                navigate(action);
    }
}