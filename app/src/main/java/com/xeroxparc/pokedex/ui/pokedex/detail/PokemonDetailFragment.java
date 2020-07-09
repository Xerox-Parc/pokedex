package com.xeroxparc.pokedex.ui.pokedex.detail;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import com.bumptech.glide.Glide;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.google.android.material.textview.MaterialTextView;
import com.xeroxparc.pokedex.R;
import com.xeroxparc.pokedex.data.model.pokemon.Pokemon;
import com.xeroxparc.pokedex.data.model.pokemon.PokemonType;
import com.xeroxparc.pokedex.data.repository.PokemonRepository;
import com.xeroxparc.pokedex.ui.egggroups.constants.EggGroupType;
import com.xeroxparc.pokedex.utils.Utils;

import java.util.List;

/**
 * @author Palmieri Ivan
 */
public class PokemonDetailFragment extends Fragment {
    private static final String TAG = "PokemonDetailFragment";
    // public static final String KEY_POKEMON_ID = "PokemonIdKey";
    ViewPagerAdapter viewPagerAdapter;
    ViewPager2 viewPager;
    String[] listString = {"About", "Base State", "Evolution", "Moves"};
    Pokemon currentPokemon;
    int visiblePage = 0;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_pokemon_details, container, false);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        viewPagerAdapter = new ViewPagerAdapter(this);
        viewPager = view.findViewById(R.id.viewPager2);
        viewPager.setAdapter(viewPagerAdapter);
        TabLayout tabLayout = view.findViewById(R.id.tabLayout);
        new TabLayoutMediator(tabLayout, viewPager,
                (tab, position) -> {
                    tab.setText(listString[position]);
                }
        ).attach();

        viewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                visiblePage = position;
                loadData();
            }
        });

        /*Qui reperisco i dati dal fragment sorgente*/
        MaterialTextView textViewName = view.findViewById(R.id.textView2);//Nome
        MaterialTextView textViewIdPokemon = view.findViewById(R.id.textView3);//Id
        ImageView pokemonImage = view.findViewById(R.id.imageView);//Immagine

        ConstraintLayout constraintLayout = view.findViewById(R.id.ConstraintLayout1);//Sfondo

        /*Qui inizia l'assegnazione dei dati */
        Integer pokId = PokemonDetailFragmentArgs.fromBundle(requireArguments()).getPokemonId();//Id

        PokemonRepository pokemonRepository = new PokemonRepository(requireContext());
        pokemonRepository.getPokemon(pokId).observe(getViewLifecycleOwner(), pokemon -> {
            pokemon.ifPresent(retrievedPokemon -> {
                currentPokemon = retrievedPokemon;
                /*Imposto il nome del Pokemon*/
                textViewName.setText(retrievedPokemon.getName());
                /*Imposto l'immagine*/
                Glide.with(requireContext()).load(retrievedPokemon.getSprite().getFrontDefault()).into(pokemonImage);
                /*Imposto id*/
                textViewIdPokemon.setText(pokId.toString());
                loadData();
                /*Imposto sfondo*/
                List<PokemonType> typeList = currentPokemon.getTypeList();
                EggGroupType eggGroupTypeStyling = Utils.eggGroupTypeFromTypeId(typeList.get(0).getType().getId());
                constraintLayout.setBackgroundColor(getContext().getColor(eggGroupTypeStyling.getEggGroupColorId()));


            });
        });
    }


    void loadData() {
        if (currentPokemon != null) {
//            Fragment fragment = viewPagerAdapter.getFragment();
//            View view1 = fragment.getView();
            switch (visiblePage) {
                case 0:
                    ProgressBar pokemonHp = viewPager.getRootView().findViewById(R.id.progressBar);//Hp
                    ProgressBar pokemonAttack = viewPager.getRootView().findViewById(R.id.progressBar2);//Attack
                    ProgressBar pokemonDefense = viewPager.getRootView().findViewById(R.id.progressBar3);//Defense
                    ProgressBar pokemonSpAtk = viewPager.getRootView().findViewById(R.id.progressBar4);//SpAtk
                    ProgressBar pokemonSpDef = viewPager.getRootView().findViewById(R.id.progressBar5);//SpDef
                    ProgressBar pokemonSpeed = viewPager.getRootView().findViewById(R.id.progressBar6);//Speed
                    TextView pokemonHpP = viewPager.getRootView().findViewById(R.id.textView23);//Hp
                    TextView pokemonAttackP = viewPager.getRootView().findViewById(R.id.textView24);//Attack
                    TextView pokemonDefenseP = viewPager.getRootView().findViewById(R.id.textView25);//Defense
                    TextView pokemonSpDefP = viewPager.getRootView().findViewById(R.id.textView26);//SpDef
                    TextView pokemonSpAtkP = viewPager.getRootView().findViewById(R.id.textView27);//SpAtk
                    TextView pokemonSpeedP = viewPager.getRootView().findViewById(R.id.textView28);//Speed

                    pokemonHp.setProgress(currentPokemon.getStatList().get(0).getBaseStat());
                    pokemonAttack.setProgress(currentPokemon.getStatList().get(1).getBaseStat());
                    pokemonDefense.setProgress(currentPokemon.getStatList().get(2).getBaseStat());
                    pokemonSpAtk.setProgress(currentPokemon.getStatList().get(3).getBaseStat());
                    pokemonSpDef.setProgress(currentPokemon.getStatList().get(4).getBaseStat());
                    pokemonSpeed.setProgress(currentPokemon.getStatList().get(5).getBaseStat());

                    pokemonHpP.setText(currentPokemon.getStatList().get(0).getBaseStat().toString());
                    pokemonAttackP.setText(currentPokemon.getStatList().get(1).getBaseStat().toString());
                    pokemonDefenseP.setText(currentPokemon.getStatList().get(2).getBaseStat().toString());
                    pokemonSpAtkP.setText(currentPokemon.getStatList().get(3).getBaseStat().toString());
                    pokemonSpDefP.setText(currentPokemon.getStatList().get(4).getBaseStat().toString());
                    pokemonSpeedP.setText(currentPokemon.getStatList().get(5).getBaseStat().toString());
                    break;
                case 1:
//                    TextView pokemonHeight = viewPager.findViewById(R.id.textView15);//Height
                    TextView pokemonWeight = viewPager.getRootView().findViewById(R.id.textView16);//Weight
                    TextView pokemonDescription = viewPager.getRootView().findViewById(R.id.textView5);//Descriptor
//                    pokemonHeight.setText("Height");
//                    pokemonHeight.setText(currentPokemon.getHeight());
//                    pokemonWeight.setText(currentPokemon.getWeight());
//                    pokemonGender.setText(currentPokemon.getWeight());
                    break;
                case 2:
                    break;
                case 3:
                    break;
            }
//            Log.e(TAG, "Page Tag: " + fragment);
//            Log.e(TAG, "Page Tag: " + view1.getTag());
        }
    }


}
