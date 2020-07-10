package com.xeroxparc.pokedex.ui.ability.detail;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.xeroxparc.pokedex.data.repository.AbilityRepository;
import com.xeroxparc.pokedex.databinding.FragmentAbilityDetailedBinding;


public class AbilityDetailedFragment extends Fragment {
    public static final String ARG_OBJECT = "object";
    private FragmentAbilityDetailedBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = FragmentAbilityDetailedBinding.inflate(getLayoutInflater(), container, false);
        TextView abilityName = binding.textViewAbility;
        TextView generation = binding.textViewGenerationAbility;
        TextView flavour = binding.textViewFlavorTextAbility;
        TextView effect = binding.textViewEffectAbility;
        AbilityRepository abilityRepository = new AbilityRepository(requireContext());
        int abilityId = getArguments().getInt(AbilityDetailedFragment.ARG_OBJECT);
        abilityRepository.getAbility(abilityId).observe(getViewLifecycleOwner(), ability ->
            ability.ifPresent(detailedAbility -> {
                abilityName.setText(detailedAbility.getName());
                generation.setText(detailedAbility.getGeneration().getName());
                flavour.setText(detailedAbility.getFlavorTextEntryList().get(1).getFlavorText());
                effect.setText(detailedAbility.getEffectEntryList().get(1).getEffect());
                abilityName.setText(String.format("%s%s", Character.toUpperCase(detailedAbility.getName().charAt(0)), detailedAbility.getName().substring(1)));

            })
        );
        return binding.getRoot();
    }


}