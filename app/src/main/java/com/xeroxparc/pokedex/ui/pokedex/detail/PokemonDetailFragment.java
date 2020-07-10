package com.xeroxparc.pokedex.ui.pokedex.detail;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.bumptech.glide.Glide;
import com.google.android.material.textview.MaterialTextView;
import com.xeroxparc.pokedex.R;
import com.xeroxparc.pokedex.data.model.pokemon.Pokemon;
import com.xeroxparc.pokedex.data.repository.PokemonRepository;
import com.xeroxparc.pokedex.databinding.FragmentPokemonDetailsBinding;

/**
 * @author Palmieri Ivan
 */
public class PokemonDetailFragment extends Fragment {
    Pokemon currentPokemon;
     FragmentPokemonDetailsBinding binding;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_pokemon_details, container, false);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        CardView cardView = view.findViewById(R.id.card_view_pokemon_base_state);
        CardView cardView1 = view.findViewById(R.id.card_view_pokemon_details);
        CardView cardView3 = view.findViewById(R.id.card_view_pokemon_moves);


        /*Qui reperisco i dati dal fragment sorgente*/
        MaterialTextView textViewName = view.findViewById(R.id.text_view_pokemon_name_value);//Nome
        MaterialTextView textViewIdPokemon = view.findViewById(R.id.text_view_pokemon_id_value);//Id
        ImageView pokemonImage = view.findViewById(R.id.image_view_pokemon_loading);//Immagine

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
            });
        });
    }
}