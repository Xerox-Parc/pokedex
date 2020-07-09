package com.xeroxparc.pokedex.ui.ability.detail.filter;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.xeroxparc.pokedex.ui.ability.detail.AbilityDetailedFragment;


public class AbilityFilterFragment extends Fragment {
    private AbilityFilterBinder binder;
    @Nullable
    @Override
    public View onCreateView( LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState){
        int abilityId = getArguments().getInt(AbilityDetailedFragment.ARG_OBJECT);
        binder = new AbilityFilterBinder(this,abilityId);
        binder.bind();
        return binder.getRoot();

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binder = null;
    }


}