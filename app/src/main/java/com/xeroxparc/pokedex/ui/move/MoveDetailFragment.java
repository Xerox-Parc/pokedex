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

        // API request to obtain the current move object
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
                    textViewMoveName.setText(nameList.get(i).getText());
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
            String moveGeneration = generationConverter(currentMove.getGeneration().getName());
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

            List<MaterialTextView> flavorTextList = new ArrayList<>();
            fillFlavorList(flavorTextList);

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
                            break;
                        case 1:
                            orderedFlavorList.set(1, flavorText);
                            break;
                        case 2:
                            orderedFlavorList.set(2, flavorText);
                            break;
                        case 3:
                            orderedFlavorList.set(3, flavorText);
                            break;
                        case 4:
                            orderedFlavorList.set(4, flavorText);
                            break;
                        case 5:
                            orderedFlavorList.set(5, flavorText);
                            break;
                        case 6:
                            orderedFlavorList.set(6, flavorText);
                            break;
                        case 7:
                            orderedFlavorList.set(7, flavorText);
                            break;
                        case 8:
                            orderedFlavorList.set(8, flavorText);
                            break;
                        case 9:
                            orderedFlavorList.set(9, flavorText);
                            break;
                        case 10:
                            orderedFlavorList.set(10, flavorText);
                            break;
                        case 11:
                            orderedFlavorList.set(11, flavorText);
                            break;
                        case 12:
                            orderedFlavorList.set(12, flavorText);
                            break;
                        case 13:
                            orderedFlavorList.set(13, flavorText);
                            break;
                        case 14:
                            orderedFlavorList.set(14, flavorText);
                            break;
                        case 15:
                            orderedFlavorList.set(15, flavorText);
                            break;
                        case 16:
                            orderedFlavorList.set(16, flavorText);
                            break;
                        case 17:
                            orderedFlavorList.set(17, flavorText);
                            break;
                        default:
                            break;
                    }
                }
            }

            List<String> pokemonVersionList = new ArrayList<>();
            fillPokemonVersionList(pokemonVersionList);

            List<MaterialCardView> cardViewFlavorList = new ArrayList<>();
            fillCardViewFlavorList(cardViewFlavorList);

            // set flavor texts from available games into corresponding card views, hide them id there's not available text
            for(int i = 0; i < flavorTextList.size(); i++){
                if(!orderedFlavorList.get(i).equals("none")){
                    flavorTextList.get(i).setText(pokemonVersionList.get(i) +"\n" + orderedFlavorList.get(i));
                } else{
                    cardViewFlavorList.get(i).setVisibility(View.GONE);
                }
            }
        }

    }

    private void fillCardViewFlavorList(List<MaterialCardView> cardViewFlavorList) {

        cardViewFlavorList.add( requireView().findViewById(R.id.card_view_flavor_text_red_blue));
        cardViewFlavorList.add( requireView().findViewById(R.id.card_view_flavor_text_yellow));
        cardViewFlavorList.add( requireView().findViewById(R.id.card_view_flavor_text_gold_silver));
        cardViewFlavorList.add( requireView().findViewById(R.id.card_view_flavor_text_crystal));
        cardViewFlavorList.add( requireView().findViewById(R.id.card_view_flavor_text_ruby_sapphire));
        cardViewFlavorList.add( requireView().findViewById(R.id.card_view_flavor_text_emerald));
        cardViewFlavorList.add( requireView().findViewById(R.id.card_view_flavor_text_firered_leafgreen));
        cardViewFlavorList.add( requireView().findViewById(R.id.card_view_flavor_text_diamond_pearl));
        cardViewFlavorList.add( requireView().findViewById(R.id.card_view_flavor_text_platinum));
        cardViewFlavorList.add( requireView().findViewById(R.id.card_view_flavor_text_heartgold_soulsilver));
        cardViewFlavorList.add( requireView().findViewById(R.id.card_view_flavor_text_black_white));
        cardViewFlavorList.add( requireView().findViewById(R.id.card_view_flavor_text_colosseum));
        cardViewFlavorList.add( requireView().findViewById(R.id.card_view_flavor_text_xd));
        cardViewFlavorList.add( requireView().findViewById(R.id.card_view_flavor_text_black2_white2));
        cardViewFlavorList.add( requireView().findViewById(R.id.card_view_flavor_text_x_y));
        cardViewFlavorList.add( requireView().findViewById(R.id.card_view_flavor_text_omegaruby_alphasapphire));
        cardViewFlavorList.add( requireView().findViewById(R.id.card_view_flavor_text_sun_moon));
        cardViewFlavorList.add( requireView().findViewById(R.id.card_view_flavor_text_ultrasun_ultramoon));
    }

    private void fillPokemonVersionList(List<String> pokemonVersionList) {

        pokemonVersionList.add(getString(R.string.red_and_blue));
        pokemonVersionList.add(getString(R.string.yellow));
        pokemonVersionList.add(getString(R.string.gold_and_silver));
        pokemonVersionList.add(getString(R.string.crystal));
        pokemonVersionList.add(getString(R.string.ruby_and_sapphire));
        pokemonVersionList.add(getString(R.string.emerald));
        pokemonVersionList.add(getString(R.string.firered_and_leafgreen));
        pokemonVersionList.add(getString(R.string.diamond_and_pearl));
        pokemonVersionList.add(getString(R.string.platinum));
        pokemonVersionList.add(getString(R.string.heartgold_and_soulsilver));
        pokemonVersionList.add(getString(R.string.black_and_white));
        pokemonVersionList.add(getString(R.string.colosseum));
        pokemonVersionList.add(getString(R.string.xd));
        pokemonVersionList.add(getString(R.string.black2_and_white2));
        pokemonVersionList.add(getString(R.string.x_and_y));
        pokemonVersionList.add(getString(R.string.omegaruby_and_alphasapphire));
        pokemonVersionList.add(getString(R.string.sun_and_moon));
        pokemonVersionList.add(getString(R.string.ultrasun_and_ultramoon));
    }

    private void fillFlavorList(List<MaterialTextView> flavorTextViewList) {

        flavorTextViewList.add(requireView().findViewById(R.id.text_view_flavor_text_red_blue));
        flavorTextViewList.add(requireView().findViewById(R.id.text_view_flavor_text_yellow));
        flavorTextViewList.add(requireView().findViewById(R.id.text_view_flavor_text_gold_silver));
        flavorTextViewList.add(requireView().findViewById(R.id.text_view_flavor_text_crystal));
        flavorTextViewList.add(requireView().findViewById(R.id.text_view_flavor_text_ruby_sapphire));
        flavorTextViewList.add(requireView().findViewById(R.id.text_view_flavor_text_emerald));
        flavorTextViewList.add(requireView().findViewById(R.id.text_view_flavor_text_firered_leafgreen));
        flavorTextViewList.add(requireView().findViewById(R.id.text_view_flavor_text_diamond_pearl));
        flavorTextViewList.add(requireView().findViewById(R.id.text_view_flavor_text_platinum));
        flavorTextViewList.add(requireView().findViewById(R.id.text_view_flavor_text_heartgold_soulsilver));
        flavorTextViewList.add(requireView().findViewById(R.id.text_view_flavor_text_black_white));
        flavorTextViewList.add(requireView().findViewById(R.id.text_view_flavor_text_colosseum));
        flavorTextViewList.add(requireView().findViewById(R.id.text_view_flavor_text_xd));
        flavorTextViewList.add(requireView().findViewById(R.id.text_view_flavor_text_black2_white2));
        flavorTextViewList.add(requireView().findViewById(R.id.text_view_flavor_text_x_y));
        flavorTextViewList.add(requireView().findViewById(R.id.text_view_flavor_text_omegaruby_alphasapphire));
        flavorTextViewList.add(requireView().findViewById(R.id.text_view_flavor_text_sun_moon));
        flavorTextViewList.add(requireView().findViewById(R.id.text_view_flavor_text_ultrasun_ultramoon));
    }


    public String generationConverter(String rawGeneration){
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