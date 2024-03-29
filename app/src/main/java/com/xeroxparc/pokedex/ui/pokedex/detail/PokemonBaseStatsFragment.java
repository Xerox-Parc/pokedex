package com.xeroxparc.pokedex.ui.pokedex.detail;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.xeroxparc.pokedex.R;
import com.xeroxparc.pokedex.data.model.pokemon.Pokemon;
import com.xeroxparc.pokedex.data.repository.PokemonRepository;

/**
 *
 *
 * @author Palmieri Ivan
 */
public class PokemonBaseStatsFragment extends Fragment {
    Pokemon currentPokemon;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        int pokeId = PokemonBaseStatsFragmentArgs.fromBundle(requireArguments()).getPokemonId();
        Log.d("Base state InfoPokemon", String.valueOf(pokeId));
        PokemonRepository pokemonRepository = new PokemonRepository(requireContext());
        pokemonRepository.getPokemon(pokeId).observe(getViewLifecycleOwner(), pokemon -> {
            pokemon.ifPresent(retrievedPokemon -> {
                currentPokemon = retrievedPokemon;

                /*Dichiaro le variabili*/
                ProgressBar pokemonHp = getView().findViewById(R.id.progress_bar_pokemon_hp);//Hp
                ProgressBar pokemonAttack = getView().findViewById(R.id.progress_bar_pokemon_attack);//Attack
                ProgressBar pokemonDefense = getView().findViewById(R.id.progress_bar_pokemon_defense);//Defense
                ProgressBar pokemonSpAtk = getView().findViewById(R.id.progress_bar_pokemon_sp_atk);//SpAtk
                ProgressBar pokemonSpDef = getView().findViewById(R.id.progress_bar_pokemon_sp_def);//SpDef
                ProgressBar pokemonSpeed = getView().findViewById(R.id.progress_bar_pokemon_speed);//Speed

                TextView pokemonHpP = getView().findViewById(R.id.text_view_pokemon_hp_int);//Hp
                TextView pokemonAttackP = getView().findViewById(R.id.text_view_pokemon_attack_int);//Attack
                TextView pokemonDefenseP = getView().findViewById(R.id.text_view_pokemon_defense_int);//Defense
                TextView pokemonSpDefP = getView().findViewById(R.id.text_view_pokemon_sp_atk_int);//SpDef
                TextView pokemonSpAtkP = getView().findViewById(R.id.text_view_pokemon_sp_def_int);//SpAtk
                TextView pokemonSpeedP =getView().findViewById(R.id.text_view_pokemon_speed_int);//Speed

                /*Setto i valori*/
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

            });
        });
        return inflater.inflate(R.layout.fragment_pokemon_base_stats, container, false);
    }
}