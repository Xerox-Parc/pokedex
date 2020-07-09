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
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.viewpager2.widget.ViewPager2;

import com.bumptech.glide.Glide;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.google.android.material.textview.MaterialTextView;
import com.xeroxparc.pokedex.R;
import com.xeroxparc.pokedex.data.model.pokemon.Pokemon;
import com.xeroxparc.pokedex.data.model.pokemon.PokemonType;
import com.xeroxparc.pokedex.data.repository.PokemonRepository;
import com.xeroxparc.pokedex.databinding.FragmentPokemonDetailsBinding;
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
    FragmentPokemonDetailsBinding binding;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_pokemon_details, container, false);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {



      //  viewPagerAdapter = new ViewPagerAdapter(this);
       // viewPager = view.findViewById(R.id.viewPager2);
       // viewPager.setAdapter(viewPagerAdapter);
       // TabLayout tabLayout = view.findViewById(R.id.tabLayout);
        //new TabLayoutMediator(tabLayout, viewPager,
      //          (tab, position) -> {
     //               tab.setText(listString[position]);
        //       }
       // ).attach();

        /*viewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                visiblePage = position;
                //loadData();
            }
        });*/
        CardView cardView = view.findViewById(R.id.cardView);
        CardView cardView1 = view.findViewById(R.id.cardView5);
        CardView cardView2 = view.findViewById(R.id.cardView4);
        CardView cardView3 = view.findViewById(R.id.cardView3);


        /*Qui reperisco i dati dal fragment sorgente*/
        MaterialTextView textViewName = view.findViewById(R.id.textView2);//Nome
        MaterialTextView textViewIdPokemon = view.findViewById(R.id.textView3);//Id
        ImageView pokemonImage = view.findViewById(R.id.imageView);//Immagine

        ConstraintLayout constraintLayout = view.findViewById(R.id.ConstraintLayout1);//Sfondo

        /*Qui inizia l'assegnazione dei dati */
        Integer pokId = PokemonDetailFragmentArgs.fromBundle(requireArguments()).getPokemonId();//Id

        cardView.setOnClickListener(item->{
            PokemonDetailFragmentDirections.ActionNavPokemonDetailToNavAboutFragment action =  PokemonDetailFragmentDirections.actionNavPokemonDetailToNavAboutFragment();
            action.setPokemonId(pokId);
            Navigation.findNavController(requireView()).navigate(action);
            //Apro fragment Pokemon About
        });
        cardView1.setOnClickListener(item->{
            PokemonDetailFragmentDirections.ActionNavPokemonDetailToNavBaseStateFragment action =  PokemonDetailFragmentDirections.actionNavPokemonDetailToNavBaseStateFragment();
            action.setPokemonId(pokId);
            Navigation.findNavController(requireView()).navigate(action);
            //Apro fragment Pokemon Base state
        });
        cardView2.setOnClickListener(item->{
            PokemonDetailFragmentDirections.ActionNavPokemonDetailToNavEvolutionFragment action =  PokemonDetailFragmentDirections.actionNavPokemonDetailToNavEvolutionFragment();
            action.setPokemonId(pokId);
            Navigation.findNavController(requireView()).navigate(action);
            //Apro fragment Pokemon Evolution
        });
        cardView3.setOnClickListener(item->{
            PokemonDetailFragmentDirections.ActionNavPokemonDetailToNavPokemonMovesFragment action =  PokemonDetailFragmentDirections.actionNavPokemonDetailToNavPokemonMovesFragment();
            action.setPokemonId(pokId);
            Navigation.findNavController(requireView()).navigate(action);
            //Apro fragment Pokemon Moves
        });



        /*Modifiche sulla pokemon_detail statica*/
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
               // loadData();
                /*Imposto sfondo*/
                List<PokemonType> typeList = currentPokemon.getTypeList();
                EggGroupType eggGroupTypeStyling = Utils.eggGroupTypeFromTypeId(typeList.get(0).getType().getId());
                constraintLayout.setBackgroundColor(getContext().getColor(eggGroupTypeStyling.getEggGroupColorId()));
                cardView.setBackgroundColor(getContext().getColor(eggGroupTypeStyling.getEggGroupColorId()));
                cardView1.setBackgroundColor(getContext().getColor(eggGroupTypeStyling.getEggGroupColorId()));
                cardView2.setBackgroundColor(getContext().getColor(eggGroupTypeStyling.getEggGroupColorId()));
                cardView3.setBackgroundColor(getContext().getColor(eggGroupTypeStyling.getEggGroupColorId()));




            });
        });
    }
}