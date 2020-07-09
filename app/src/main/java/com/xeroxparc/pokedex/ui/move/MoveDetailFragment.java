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
import com.xeroxparc.pokedex.data.model.move.Move;
import com.xeroxparc.pokedex.data.model.move.MoveFlavorText;
import com.xeroxparc.pokedex.data.model.utility.common.Name;
import com.xeroxparc.pokedex.data.model.utility.common.VerboseEffect;
import com.xeroxparc.pokedex.data.repository.MoveRepository;
import com.xeroxparc.pokedex.databinding.FragmentMoveDetailBinding;
import com.xeroxparc.pokedex.utils.Utils;

import java.util.ArrayList;
import java.util.List;

public class MoveDetailFragment extends Fragment {

    private FragmentMoveDetailBinding binding;
    private Move currentMove;

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

        MoveRepository moveRepository = new MoveRepository(requireContext());
        moveRepository.getMove(MoveDetailFragmentArgs.fromBundle(requireArguments()).getMoveId()).observe(getViewLifecycleOwner(), move -> {
            move.ifPresent(retrievedMove -> {
                currentMove = retrievedMove;
                loadData();
            });
        });
    }

    @SuppressLint("SetTextI18n")
    void loadData(){
        if(currentMove != null){

            MaterialTextView textViewMoveName = requireView().findViewById(R.id.text_view_move_name); //name
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

            // Move Name in the selected language
            List<Name> nameList = currentMove.getNameList();

            for (int i = 0; i < nameList.size(); i++) {
                String languageName = nameList.get(i).getLanguage().getName();
                if(languageName != null && languageName.equalsIgnoreCase(getString(R.string.language))){
                    textViewMoveName.setText(nameList.get(i).getName());
                    break;
                }
            }

            // Move Type
            textViewMoveType.setText(currentMove.getType().getName());

            // Move Effect Text
            List<VerboseEffect> effectList = currentMove.getEffectEntryList();
            String effectChance = String.valueOf(currentMove.getEffectChance());

            for (int i = 0; i < effectList.size(); i++) {
                String languageName = effectList.get(i).getLanguage().getName();
                if(languageName != null && languageName.equalsIgnoreCase(getString(R.string.language))){

                    String effectText = effectList.get(i).getEffect();

                    if(currentMove.getEffectChance() != null) {
                        effectText = effectText.replace("$effect_chance%", effectChance);
                    }
                    textViewEffectText.setText(effectText);
                    break;
                }
            }

            // Move Generation
            String moveGeneration = GenerationConverter(currentMove.getGeneration().getName());
            textViewMoveGeneration.setText(moveGeneration);

            // PP
            textViewPp.setText(String.valueOf(currentMove.getPp()));

            // Power
            textViewPower.setText(String.valueOf(currentMove.getPower()));

            //Priority
            textViewPriority.setText(String.valueOf(currentMove.getPriority()));

            //Accuracy
            textViewAccuracy.setText(String.valueOf(currentMove.getAccuracy()));

            //Damage Class
            textViewDamageClass.setText(String.valueOf(currentMove.getDamageClass().getName()));

            // elements of the ui colored depending on the move type
            cardViewMoveType.setBackgroundResource(Utils.eggGroupTypeFromTypeId(currentMove.getType().getId()).getEggGroupColorId());
            separator.setBackgroundResource(Utils.eggGroupTypeFromTypeId(currentMove.getType().getId()).getEggGroupColorId());

            // Retrieval of data necessary to set the flavor text from available Pokemon games

            List<MaterialTextView> tvFlavorList = new ArrayList<>();

            tvFlavorList.add(requireView().findViewById(R.id.text_view_flavor_text_red_blue));
            tvFlavorList.add(requireView().findViewById(R.id.text_view_flavor_text_yellow));
            tvFlavorList.add(requireView().findViewById(R.id.text_view_flavor_text_gold_silver));
            tvFlavorList.add(requireView().findViewById(R.id.text_view_flavor_text_crystal));
            tvFlavorList.add(requireView().findViewById(R.id.text_view_flavor_text_ruby_sapphire));
            tvFlavorList.add(requireView().findViewById(R.id.text_view_flavor_text_emerald));
            tvFlavorList.add(requireView().findViewById(R.id.text_view_flavor_text_firered_leafgreen));
            tvFlavorList.add(requireView().findViewById(R.id.text_view_flavor_text_diamond_pearl));
            tvFlavorList.add(requireView().findViewById(R.id.text_view_flavor_text_platinum));
            tvFlavorList.add(requireView().findViewById(R.id.text_view_flavor_text_heartgold_soulsilver));
            tvFlavorList.add(requireView().findViewById(R.id.text_view_flavor_text_black_white));
            tvFlavorList.add(requireView().findViewById(R.id.text_view_flavor_text_colosseum));
            tvFlavorList.add(requireView().findViewById(R.id.text_view_flavor_text_xd));
            tvFlavorList.add(requireView().findViewById(R.id.text_view_flavor_text_black2_white2));
            tvFlavorList.add(requireView().findViewById(R.id.text_view_flavor_text_x_y));
            tvFlavorList.add(requireView().findViewById(R.id.text_view_flavor_text_omegaruby_alphasapphire));
            tvFlavorList.add(requireView().findViewById(R.id.text_view_flavor_text_sun_moon));
            tvFlavorList.add(requireView().findViewById(R.id.text_view_flavor_text_ultrasun_ultramoon));

            List<MoveFlavorText> flavorList = currentMove.getFlavorTextEntryList();


            int NUMBER_OF_POKEMON_VERSIONS = 18;
            List<String> orderedFlavorList = new ArrayList<String>(NUMBER_OF_POKEMON_VERSIONS);
            for (int i = 0; i < NUMBER_OF_POKEMON_VERSIONS; i++) {
                orderedFlavorList.add("none");
            }

            for (int i = 0; i < flavorList.size(); i++) {
                String languageName = flavorList.get(i).getLanguage().getName();
                if(languageName != null && languageName.equalsIgnoreCase(getString(R.string.language))){

                    String flavorText = flavorList.get(i).getFlavorText();
                    flavorText = flavorText.replace("\n", "");

                    switch(flavorList.get(i).getVersionGroup().getId()){
                        case 0:
                            orderedFlavorList.set(0, flavorText);
                        case 1:
                            orderedFlavorList.set(1, flavorText);
                        case 2:
                            orderedFlavorList.set(2, flavorText);
                        case 3:
                            orderedFlavorList.set(3, flavorText);
                        case 4:
                            orderedFlavorList.set(4, flavorText);
                        case 5:
                            orderedFlavorList.set(5, flavorText);
                        case 6:
                            orderedFlavorList.set(6, flavorText);
                        case 7:
                            orderedFlavorList.set(7, flavorText);
                        case 8:
                            orderedFlavorList.set(8, flavorText);
                        case 9:
                            orderedFlavorList.set(9, flavorText);
                        case 10:
                            orderedFlavorList.set(10, flavorText);
                        case 11:
                            orderedFlavorList.set(11, flavorText);
                        case 12:
                            orderedFlavorList.set(12, flavorText);
                        case 13:
                            orderedFlavorList.set(13, flavorText);
                        case 14:
                            orderedFlavorList.set(14, flavorText);
                        case 15:
                            orderedFlavorList.set(15, flavorText);
                        case 16:
                            orderedFlavorList.set(16, flavorText);
                        case 17:
                            orderedFlavorList.set(17, flavorText);
                        default:
                    }
                }
            }

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
                if(!orderedFlavorList.get(i).equals("none")){
                    tvFlavorList.get(i).setText(flavorOrigin.get(i) +"\n" + orderedFlavorList.get(i));
                } else{
                    cardViewFlavorlist.get(i).setVisibility(View.GONE);
                }
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