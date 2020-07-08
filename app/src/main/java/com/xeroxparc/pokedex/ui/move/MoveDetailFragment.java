package com.xeroxparc.pokedex.ui.move;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.card.MaterialCardView;
import com.google.android.material.textview.MaterialTextView;
import com.xeroxparc.pokedex.R;
import com.xeroxparc.pokedex.databinding.FragmentMoveDetailBinding;
import com.xeroxparc.pokedex.utils.Utils;

import java.util.ArrayList;
import java.util.List;

public class MoveDetailFragment extends Fragment {

    private FragmentMoveDetailBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        binding = FragmentMoveDetailBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        MaterialTextView textViewMoveName = requireView().findViewById(R.id.text_view_move_name);
        MaterialTextView textViewMoveType = requireView().findViewById(R.id.text_view_move_type);
        MaterialTextView textViewMoveGeneration = requireView().findViewById(R.id.text_view_generation);
        CardView cardViewMoveType = requireView().findViewById(R.id.card_view_move_type);
        MaterialTextView textViewPp = requireView().findViewById(R.id.text_view_pp_value);
        MaterialTextView textViewPower = requireView().findViewById(R.id.text_view_power_value);
        MaterialTextView textViewPriority = requireView().findViewById(R.id.text_view_priority_value);
        MaterialTextView textViewAccuracy = requireView().findViewById(R.id.text_view_accuracy_value);
        MaterialTextView textViewDamageClass = requireView().findViewById(R.id.text_view_damage_class);
        View separator = requireView().findViewById(R.id.view_separator);
        MaterialTextView textViewEffectText = requireView().findViewById(R.id.text_view_effect);

        String moveName = MoveDetailFragmentArgs.fromBundle(requireArguments()).getMoveTitle();
        String moveType = MoveDetailFragmentArgs.fromBundle(requireArguments()).getMoveType();
        String moveEffect = MoveDetailFragmentArgs.fromBundle(requireArguments()).getMoveEffectText();

        String rawGeneration = MoveDetailFragmentArgs.fromBundle(requireArguments()).getMoveGeneration();
        String moveGeneration = GenerationConverter(rawGeneration);

        int movePpValue = MoveDetailFragmentArgs.fromBundle(requireArguments()).getMovePp();
        int movePowerValue = MoveDetailFragmentArgs.fromBundle(requireArguments()).getMovePower();
        int movePriorityValue = MoveDetailFragmentArgs.fromBundle(requireArguments()).getMovePriority();
        int moveAccuracyValue = MoveDetailFragmentArgs.fromBundle(requireArguments()).getMoveAccuracy();
        String moveDamageClass = MoveDetailFragmentArgs.fromBundle(requireArguments()).getMoveDamageClass();


        textViewMoveName.setText(moveName);
        textViewMoveType.setText(moveType);
        textViewEffectText.setText(moveEffect);


        cardViewMoveType.setBackgroundResource(Utils.eggGroupTypeFromTypeId(MoveDetailFragmentArgs.fromBundle(requireArguments()).getMoveTypeId()).getEggGroupColorId());
        separator.setBackgroundResource(Utils.eggGroupTypeFromTypeId(MoveDetailFragmentArgs.fromBundle(requireArguments()).getMoveTypeId()).getEggGroupColorId());


        textViewMoveGeneration.setText(moveGeneration);
        textViewPp.setText("" + movePpValue);
        textViewPower.setText("" + movePowerValue);
        textViewPriority.setText("" + movePriorityValue);
        textViewAccuracy.setText("" + moveAccuracyValue);
        textViewDamageClass.setText(moveDamageClass);

        List<MaterialTextView> tvFlavorList = new ArrayList<>();

        MaterialTextView tvRedBlue =  requireView().findViewById(R.id.text_view_flavor_text_red_blue);
        tvFlavorList.add(tvRedBlue);
        MaterialTextView tvYellow =  requireView().findViewById(R.id.text_view_flavor_text_yellow);
        tvFlavorList.add(tvYellow);
        MaterialTextView tvGoldSilver =  requireView().findViewById(R.id.text_view_flavor_text_gold_silver);
        tvFlavorList.add(tvGoldSilver);
        MaterialTextView tvCrystal =  requireView().findViewById(R.id.text_view_flavor_text_crystal);
        tvFlavorList.add(tvCrystal);
        MaterialTextView tvRubySapphire =  requireView().findViewById(R.id.text_view_flavor_text_ruby_sapphire);
        tvFlavorList.add(tvRubySapphire);
        MaterialTextView tvEmerald =  requireView().findViewById(R.id.text_view_flavor_text_emerald);
        tvFlavorList.add(tvEmerald);
        MaterialTextView tvFireredLeafGreen =  requireView().findViewById(R.id.text_view_flavor_text_firered_leafgreen);
        tvFlavorList.add(tvFireredLeafGreen);
        MaterialTextView tvDiamondPearl =  requireView().findViewById(R.id.text_view_flavor_text_diamond_pearl);
        tvFlavorList.add(tvDiamondPearl);
        MaterialTextView tvPlatinum =  requireView().findViewById(R.id.text_view_flavor_text_platinum);
        tvFlavorList.add(tvPlatinum);
        MaterialTextView tvHeartgoldSoulsilver =  requireView().findViewById(R.id.text_view_flavor_text_heartgold_soulsilver);
        tvFlavorList.add(tvHeartgoldSoulsilver);
        MaterialTextView tvBlackWhite =  requireView().findViewById(R.id.text_view_flavor_text_black_white);
        tvFlavorList.add(tvBlackWhite);
        MaterialTextView tvColosseum =  requireView().findViewById(R.id.text_view_flavor_text_colosseum);
        tvFlavorList.add(tvColosseum);
        MaterialTextView tvXd =  requireView().findViewById(R.id.text_view_flavor_text_xd);
        tvFlavorList.add(tvXd);
        MaterialTextView tvBlack2White2 =  requireView().findViewById(R.id.text_view_flavor_text_black2_white2);
        tvFlavorList.add(tvBlack2White2);
        MaterialTextView tvXY =  requireView().findViewById(R.id.text_view_flavor_text_x_y);
        tvFlavorList.add(tvXY);
        MaterialTextView tvOmegarubyAlphasapphire =  requireView().findViewById(R.id.text_view_flavor_text_omegaruby_alphasapphire);
        tvFlavorList.add(tvOmegarubyAlphasapphire);
        MaterialTextView tvSunMoon =  requireView().findViewById(R.id.text_view_flavor_text_sun_moon);
        tvFlavorList.add(tvSunMoon);
        MaterialTextView tvUltrasunUltramoon =  requireView().findViewById(R.id.text_view_flavor_text_ultrasun_ultramoon);
        tvFlavorList.add(tvUltrasunUltramoon);

        List<String> stringFlavorList = new ArrayList<>();

        String flavorRedBlue =  MoveDetailFragmentArgs.fromBundle(requireArguments()).getFlavorRedBlue();
        stringFlavorList.add(flavorRedBlue);
        String flavorYellow =  MoveDetailFragmentArgs.fromBundle(requireArguments()).getFlavorYellow();
        stringFlavorList.add(flavorYellow);
        String flavorGoldSilver =  MoveDetailFragmentArgs.fromBundle(requireArguments()).getFlavorGoldSilver();
        stringFlavorList.add(flavorGoldSilver);
        String flavorCrystal =  MoveDetailFragmentArgs.fromBundle(requireArguments()).getFlavorCrystal();
        stringFlavorList.add(flavorCrystal);
        String flavorRubySapphire =  MoveDetailFragmentArgs.fromBundle(requireArguments()).getFlavorRubySapphire();
        stringFlavorList.add(flavorRubySapphire);
        String flavorEmerald =  MoveDetailFragmentArgs.fromBundle(requireArguments()).getFlavorEmerald();
        stringFlavorList.add(flavorEmerald);
        String flavorFireredLeafGreen =  MoveDetailFragmentArgs.fromBundle(requireArguments()).getFlavorFireredLeafgreen();
        stringFlavorList.add(flavorFireredLeafGreen);
        String flavorDiamondPearl =  MoveDetailFragmentArgs.fromBundle(requireArguments()).getFlavorDiamondPearl();
        stringFlavorList.add(flavorDiamondPearl);
        String flavorPlatinum =  MoveDetailFragmentArgs.fromBundle(requireArguments()).getFlavorPlatinum();
        stringFlavorList.add(flavorPlatinum);
        String flavorHeartgoldSoulsilver =  MoveDetailFragmentArgs.fromBundle(requireArguments()).getFlavorHeartgoldSoulsilver();
        stringFlavorList.add(flavorHeartgoldSoulsilver);
        String flavorBlackWhite =  MoveDetailFragmentArgs.fromBundle(requireArguments()).getFlavorBlackWhite();
        stringFlavorList.add(flavorBlackWhite);
        String flavorColosseum =  MoveDetailFragmentArgs.fromBundle(requireArguments()).getFlavorColosseum();
        stringFlavorList.add(flavorColosseum);
        String flavorXd =  MoveDetailFragmentArgs.fromBundle(requireArguments()).getFlavorXd();
        stringFlavorList.add(flavorXd);
        String flavorBlack2White2 =  MoveDetailFragmentArgs.fromBundle(requireArguments()).getFlavorBlack2White2();
        stringFlavorList.add(flavorBlack2White2);
        String flavorXY =  MoveDetailFragmentArgs.fromBundle(requireArguments()).getFlavorXY();
        stringFlavorList.add(flavorXY);
        String flavorOmegarubyAlphasapphire = MoveDetailFragmentArgs.fromBundle(requireArguments()).getFlavorOmegarubyAlphasapphire();
        stringFlavorList.add(flavorOmegarubyAlphasapphire);
        String flavorSunMoon =  MoveDetailFragmentArgs.fromBundle(requireArguments()).getFlavorSunMoon();
        stringFlavorList.add(flavorSunMoon);
        String flavorUltrasunUltramoon =  MoveDetailFragmentArgs.fromBundle(requireArguments()).getFlavorUltrasunUltramoon();
        stringFlavorList.add(flavorUltrasunUltramoon);

        List<String> flavorOrigin = new ArrayList<>();

        flavorOrigin.add(getString(R.string.red_and_blue));
        flavorOrigin.add(getString(R.string.yellow));
        flavorOrigin.add(getString(R.string.gold_and_silver));
        flavorOrigin.add(getString(R.string.crystal));
        flavorOrigin.add(getString(R.string.ruby_and_sapphire));
        flavorOrigin.add(getString(R.string.emerald));
        flavorOrigin.add(getString(R.string.firered_and_leafgreen));
        flavorOrigin.add(getString(R.string.diamond_and_pearl));
        flavorOrigin.add(getString(R.string.platinum));
        flavorOrigin.add(getString(R.string.heartgold_and_soulsilver));
        flavorOrigin.add(getString(R.string.black_and_white));
        flavorOrigin.add(getString(R.string.colosseum));
        flavorOrigin.add(getString(R.string.xd));
        flavorOrigin.add(getString(R.string.black2_and_white2));
        flavorOrigin.add(getString(R.string.x_and_y));
        flavorOrigin.add(getString(R.string.omegaruby_and_alphasapphire));
        flavorOrigin.add(getString(R.string.sun_and_moon));
        flavorOrigin.add(getString(R.string.ultrasun_and_ultramoon));

        List<MaterialCardView> cardViewFlavorlist = new ArrayList<>();

        cardViewFlavorlist.add( requireView().findViewById(R.id.card_view_flavor_text));
        cardViewFlavorlist.add( requireView().findViewById(R.id.card_view_flavor_text_2));
        cardViewFlavorlist.add( requireView().findViewById(R.id.card_view_flavor_text_3));
        cardViewFlavorlist.add( requireView().findViewById(R.id.card_view_flavor_text_4));
        cardViewFlavorlist.add( requireView().findViewById(R.id.card_view_flavor_text_5));
        cardViewFlavorlist.add( requireView().findViewById(R.id.card_view_flavor_text_6));
        cardViewFlavorlist.add( requireView().findViewById(R.id.card_view_flavor_text_7));
        cardViewFlavorlist.add( requireView().findViewById(R.id.card_view_flavor_text_8));
        cardViewFlavorlist.add( requireView().findViewById(R.id.card_view_flavor_text_9));
        cardViewFlavorlist.add( requireView().findViewById(R.id.card_view_flavor_text_10));
        cardViewFlavorlist.add( requireView().findViewById(R.id.card_view_flavor_text_11));
        cardViewFlavorlist.add( requireView().findViewById(R.id.card_view_flavor_text_12));
        cardViewFlavorlist.add( requireView().findViewById(R.id.card_view_flavor_text_13));
        cardViewFlavorlist.add( requireView().findViewById(R.id.card_view_flavor_text_14));
        cardViewFlavorlist.add( requireView().findViewById(R.id.card_view_flavor_text_15));
        cardViewFlavorlist.add( requireView().findViewById(R.id.card_view_flavor_text_16));
        cardViewFlavorlist.add( requireView().findViewById(R.id.card_view_flavor_text_17));
        cardViewFlavorlist.add( requireView().findViewById(R.id.card_view_flavor_text_18));


        for(int i = 0; i < tvFlavorList.size(); i++){
            if(!stringFlavorList.get(i).equals("none")){
                tvFlavorList.get(i).setText(flavorOrigin.get(i) +"\n" + stringFlavorList.get(i));
            } else{
                cardViewFlavorlist.get(i).setVisibility(View.GONE);
            }
        }

    }

    public String GenerationConverter(String rawGeneration){
        String generation = getString(R.string.generation);
        switch(rawGeneration){
            case "generation-i":
                return generation + " I";
            case "generation-ii":
                return generation + " II";
            case "generation-iii":
                return generation + " III";
            case "generation-iv":
                return generation + " IV";
            case "generation-v":
                return generation + " V";
            case "generation-vi":
                return generation + " VI";
            case "generation-vii":
                return generation + " VII";
            default:
                return generation + " VIII";

        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}