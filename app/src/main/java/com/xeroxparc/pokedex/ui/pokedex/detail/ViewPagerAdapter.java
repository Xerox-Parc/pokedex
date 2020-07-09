package com.xeroxparc.pokedex.ui.pokedex.detail;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.xeroxparc.pokedex.ui.pokedex.detail.evolution.PokemonEvolutionFragment;
import com.xeroxparc.pokedex.ui.pokedex.detail.moves.PokemonMovesFragment;

import java.util.ArrayList;
import java.util.List;

/**
 *
 *
 * @author Palmieri Ivan
 */
public class ViewPagerAdapter extends FragmentStateAdapter {
    List<Fragment> fragments = new ArrayList<>();

    public ViewPagerAdapter(Fragment fragment) {
        super(fragment);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        // Return a NEW fragment instance in createFragment(int)
        Fragment fragment;
        Bundle args = new Bundle();
        switch (position){
            case 1:
                fragment = new PokemonAboutFragment();
                break;
            case 2:
                fragment= new PokemonEvolutionFragment();
                break;
            case 3:
                fragment = new PokemonMovesFragment();
                break;
            default:
                fragment = new PokemonBaseStatsFragment();
        }

        // Our object is just an integer :-P
        args.putInt(PokemonAboutFragment.ARG_OBJECT, position + 1);
        fragment.setArguments(args);
        fragments.add(fragment);
        return fragment;
    }


    @Override
    public int getItemCount() {
        return 4;
    }



    public Fragment getFragment(int position) {
        return fragments.get(position);
    }
}