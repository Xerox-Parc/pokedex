package com.xeroxparc.pokedex.ui.locations;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.xeroxparc.pokedex.R;
import com.xeroxparc.pokedex.databinding.FragmentLocationsFilterBinding;

public class LocationsFilterFragment extends Fragment {

    private FragmentLocationsFilterBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        binding = FragmentLocationsFilterBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        RelativeLayout layoutGen1 = view.findViewById(R.id.RelativeLayout_1Gen);
        layoutGen1.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                Toast.makeText(getActivity(), "This is my Toast message!",
                        Toast.LENGTH_LONG).show();
            }
        });

        RelativeLayout layoutGen2 = view.findViewById(R.id.RelativeLayout_2Gen);

        RelativeLayout layoutGen3 = view.findViewById(R.id.RelativeLayout_3Gen);

        RelativeLayout layoutGen4 = view.findViewById(R.id.RelativeLayout_4Gen);
        RelativeLayout layoutGen5 = view.findViewById(R.id.RelativeLayout_5Gen);
        RelativeLayout layoutGen6 = view.findViewById(R.id.RelativeLayout_6Gen);
        RelativeLayout layoutGen7 = view.findViewById(R.id.RelativeLayout_7Gen);
        RelativeLayout layoutGen8 = view.findViewById(R.id.RelativeLayout_8Gen);


    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}