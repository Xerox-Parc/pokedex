package com.xeroxparc.pokedex.ui.ability.detail;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.xeroxparc.pokedex.R;


public class AbilityDetailFragment extends Fragment {
    AbilityPagerAdapter viewPagerAdapter;
    ViewPager2 viewPager;
    String[] string = {"Ability","Pokemon With This Ability"};
    //public static final String ARG_OBJECT = "object";

    @Nullable
    @Override
    public View onCreateView( LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_ability_detail, container, false);
    }

    @Override
    public void onViewCreated( View view, Bundle savedInstanceState) {
        int abilityId = AbilityDetailFragmentArgs.fromBundle(requireArguments()).getAbilityId();
        viewPagerAdapter = new AbilityPagerAdapter(this, abilityId);
        viewPager = view.findViewById(R.id.viewPager);
        viewPager.setAdapter(viewPagerAdapter);
        TabLayout tabLayoutDetail = view.findViewById(R.id.tab_layout_detail);
        new TabLayoutMediator(tabLayoutDetail, viewPager,(tab, position) -> tab.setText(string[position])).attach();
    }

}