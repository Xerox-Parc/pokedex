package com.xeroxparc.pokedex.ui.egggroups.fragments.details;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.xeroxparc.pokedex.R;
import com.xeroxparc.pokedex.ui.MainActivity;
import com.xeroxparc.pokedex.ui.egggroups.constants.EggGroupType;
import com.xeroxparc.pokedex.ui.parents.CustomActionBarFragment;

import java.io.Serializable;
import java.util.Objects;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SearchView;
import androidx.navigation.Navigation;

public class EggGroupDetailsFragment extends CustomActionBarFragment {
    public static String KEY_EGG_GROUP = "KeyEggGroup";
    private EggGroupDetailsBinder binder;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MainActivity containerActivity = (MainActivity) getActivity();
        if (containerActivity != null && containerActivity.getSupportActionBar() != null) {
            containerActivity.getSupportActionBar().setTitle(null);
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        EggGroupType groupType = getEggGroupTypeFromArgs();
        binder = new EggGroupDetailsBinder(this, Objects.requireNonNull(groupType));
        binder.bind();
        return binder.getRoot();
    }

    private EggGroupType getEggGroupTypeFromArgs() {
        Bundle bundle = getArguments();
        if (bundle != null) {
            Serializable eggGroupType = bundle.getSerializable(KEY_EGG_GROUP);
            if (eggGroupType instanceof EggGroupType) {
                return (EggGroupType) eggGroupType;
            }
        }
        return null;
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(R.menu.menu_egg_group_details, menu);
        SearchView searchView = (SearchView) menu.findItem(R.id.search).getActionView();
        searchView.setOnQueryTextListener(binder);
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                Navigation.findNavController(requireActivity(), R.id.navigation_host_fragment).navigateUp();
                return true;
            case R.id.search:
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        binder.onClean();
        binder = null;
    }
}