package com.xeroxparc.pokedex.ui.locations;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.xeroxparc.pokedex.R;
import com.xeroxparc.pokedex.databinding.FragmentLocationsFilterBinding;
import com.xeroxparc.pokedex.ui.parents.CustomActionBarFragment;

public class LocationsFilterFragment extends Fragment {

    private FragmentLocationsFilterBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        binding = FragmentLocationsFilterBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }


    public void goToLocationListFragment(int region){
        LocationsFilterFragmentDirections.ActionNavLocationsFilterToNavLocationsList action = LocationsFilterFragmentDirections.actionNavLocationsFilterToNavLocationsList();
        action.setRegionId(region);
        Navigation.findNavController(requireView()).navigate(action);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        // Pass region ID from clickable relative layout
        RelativeLayout layoutGen1 = view.findViewById(R.id.relative_layout_1gen);
        layoutGen1.setOnClickListener(v -> goToLocationListFragment(1));

        RelativeLayout layoutGen2 = view.findViewById(R.id.relative_layout_2gen);
        layoutGen2.setOnClickListener(v -> goToLocationListFragment(2));

        RelativeLayout layoutGen3 = view.findViewById(R.id.relative_layout_3gen);
        layoutGen3.setOnClickListener(v -> goToLocationListFragment(3));

        RelativeLayout layoutGen4 = view.findViewById(R.id.relative_layout_4gen);
        layoutGen4.setOnClickListener(v -> goToLocationListFragment(4));

        RelativeLayout layoutGen5 = view.findViewById(R.id.relative_layout_5gen);
        layoutGen5.setOnClickListener(v -> goToLocationListFragment(5));

        RelativeLayout layoutGen6 = view.findViewById(R.id.relative_layout_6gen);
        layoutGen6.setOnClickListener(v -> goToLocationListFragment(6));

        RelativeLayout layoutGen7 = view.findViewById(R.id.relative_layout_7gen);
        layoutGen7.setOnClickListener(v -> goToLocationListFragment(7));

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}
