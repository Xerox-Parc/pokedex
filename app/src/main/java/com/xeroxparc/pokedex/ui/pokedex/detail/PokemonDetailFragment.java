package com.xeroxparc.pokedex.ui.pokedex.detail;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.google.android.material.textview.MaterialTextView;
import com.xeroxparc.pokedex.R;


public class PokemonDetailFragment extends Fragment {
    ViewPagerAdapter viewPagerAdapter;
    ViewPager2 viewPager;
    String[] listString = {"About", "Base State", "Evolution", "Moves"};


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,@Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_pokemon_details, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        //super.onViewCreated(view, savedInstanceState);
        MaterialTextView textViewMoveName = requireView().findViewById(R.id.textView2);
        String moveName = PokemonDetailFragmentArgs.fromBundle(requireArguments()).getDetailsPokemon();
        textViewMoveName.setText(moveName);
        viewPagerAdapter = new ViewPagerAdapter(this);
        viewPager = view.findViewById(R.id.viewPager2);
        viewPager.setAdapter(viewPagerAdapter);
        TabLayout tabLayout = view.findViewById(R.id.tabLayout);
        new TabLayoutMediator(tabLayout, viewPager,
                (tab, position) -> tab.setText(listString[position])
        ).attach();


    }




}