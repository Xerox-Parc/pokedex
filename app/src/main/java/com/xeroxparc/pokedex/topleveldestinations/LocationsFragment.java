package com.xeroxparc.pokedex.topleveldestinations;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.xeroxparc.pokedex.R;
import com.xeroxparc.pokedex.databinding.FragmentBerryBinding;
import com.xeroxparc.pokedex.databinding.FragmentLocationsBinding;

public class LocationsFragment extends Fragment {

    private FragmentLocationsBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentLocationsBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}