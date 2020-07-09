package com.xeroxparc.pokedex.ui.home;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * View class.
 * Handle lifecycle event, receives the user's interaction and it forwards the handling of these
 * to the view model via the data binding.
 *
 * @author Fabio Buracchi
 */
public class HomeFragment extends Fragment {

    private HomeBinder binder;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binder = new HomeBinder(this);
        binder.bind();
        return binder.getRoot();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binder.clear();
        binder = null;
    }
}