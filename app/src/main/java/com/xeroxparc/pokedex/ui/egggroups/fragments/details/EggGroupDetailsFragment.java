package com.xeroxparc.pokedex.ui.egggroups.fragments.details;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.xeroxparc.pokedex.ui.MainActivity;
import com.xeroxparc.pokedex.ui.egggroups.constants.EggGroupType;
import com.xeroxparc.pokedex.ui.parents.SearchableFragment;

import java.util.Objects;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/*
 * This fragment initializes the binder and does the needed visual setup for the Egg Group Details
 *
 * @author Abdelrahman Abdelrahman (CptPackage)
 * */
public class EggGroupDetailsFragment extends SearchableFragment {

    private EggGroupDetailsBinder binder;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        MainActivity containerActivity = (MainActivity) getActivity();
        if (containerActivity != null && containerActivity.getSupportActionBar() != null) {
            containerActivity.getSupportActionBar().setTitle(null);
        }
        int eggGroupId = EggGroupDetailsFragmentArgs.fromBundle(requireArguments()).getEggGroupTypeId();
        EggGroupType groupType = EggGroupType.getEggGroupTypeById(eggGroupId);
        binder = new EggGroupDetailsBinder(this, Objects.requireNonNull(groupType));
        binder.bind();
        return binder.getRoot();
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        onQueryTextChange(query);
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        binder.getSpeciesListAdapter().getFilter(null).filter(newText);
        return false;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (isRemoving()) {
            binder.onClean();
            binder = null;
        }
    }

}