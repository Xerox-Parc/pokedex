package com.xeroxparc.pokedex.ui.egggroups.fragments.menu;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.xeroxparc.pokedex.R;
import com.xeroxparc.pokedex.databinding.FragmentEggGroupsMenuBinding;
import com.xeroxparc.pokedex.ui.egggroups.constants.EggGroupType;
import com.xeroxparc.pokedex.ui.egggroups.fragments.details.EggGroupDetailsFragment;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

public class EggGroupsMenuFragment extends Fragment {
    private static final String TAG = "EggGroupFragment";
    private FragmentEggGroupsMenuBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = FragmentEggGroupsMenuBinding.inflate(inflater, container, false);
        binding.setFragment(this);
        return binding.getRoot();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    public void onEggGroupSelected(EggGroupType eggGroupType) {
        if (getActivity() != null) {
            Bundle bundle = new Bundle();
            bundle.putSerializable(EggGroupDetailsFragment.KEY_EGG_GROUP,eggGroupType);
            Navigation.findNavController(getActivity(), R.id.navigation_host_fragment).navigate(R.id.nav_egg_group_details,bundle);
        }
    }
}
