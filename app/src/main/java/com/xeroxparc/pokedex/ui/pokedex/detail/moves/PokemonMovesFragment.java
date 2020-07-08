package com.xeroxparc.pokedex.ui.pokedex.detail.moves;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

/**
 *
 *
 * @author Palmieri Ivan
 */
public class PokemonMovesFragment extends Fragment {
    private PokemonMovesBinder binder;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binder = new PokemonMovesBinder(this);
        binder.bind();
        return binder.getRoot();

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binder = null;
    }
}
