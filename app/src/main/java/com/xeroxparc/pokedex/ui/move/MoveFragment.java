package com.xeroxparc.pokedex.ui.move;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;

import com.xeroxparc.pokedex.R;
import com.xeroxparc.pokedex.data.repository.MoveRepository;
import com.xeroxparc.pokedex.databinding.FragmentMoveBinding;
import com.xeroxparc.pokedex.ui.parents.CustomActionBarFragment;


public class MoveFragment extends Fragment {

    private FragmentMoveBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        binding = FragmentMoveBinding.inflate(inflater, container, false);
        new Holder(getActivity(), this);
        return binding.getRoot();
    }

    class Holder {

        static final int MAX_MOVES_ID = 728;

        public Holder(FragmentActivity activity, MoveFragment moveFragment) {

            MoveListAdapter moveListAdapter = new MoveListAdapter(moveFragment, activity);
            binding.recyclerView.setAdapter(moveListAdapter);
            binding.recyclerView.setLayoutManager(new LinearLayoutManager(activity));

            // Request to take Moves from either the database or the web
            final MoveRepository moveRepository = new MoveRepository(activity);
            for (int i = 1; i < MAX_MOVES_ID + 1; i++) {
                moveRepository.getMove(i).observe(activity, move ->
                        move.ifPresent(moveListAdapter::addMove)
                );
            }
        }

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}