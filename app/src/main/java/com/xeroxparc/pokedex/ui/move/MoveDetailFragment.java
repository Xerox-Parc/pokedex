package com.xeroxparc.pokedex.ui.move;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.textview.MaterialTextView;
import com.xeroxparc.pokedex.R;
import com.xeroxparc.pokedex.databinding.FragmentMoveDetailBinding;

public class MoveDetailFragment extends Fragment {

    private FragmentMoveDetailBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        binding = FragmentMoveDetailBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        MaterialTextView textViewMoveName = requireView().findViewById(R.id.text_view_move_name);
        String moveName = MoveDetailFragmentArgs.fromBundle(requireArguments()).getMoveTitle();
        textViewMoveName.setText(moveName);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}