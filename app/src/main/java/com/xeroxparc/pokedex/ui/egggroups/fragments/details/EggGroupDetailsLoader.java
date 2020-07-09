package com.xeroxparc.pokedex.ui.egggroups.fragments.details;

import com.xeroxparc.pokedex.data.model.pokemon.species.PokemonSpecies;
/*
 *  The implementing class should be able to load the egg group required data
 *
 * @author Abdelrahman Abdelrahman (CptPackage)
 * */
public interface EggGroupDetailsLoader {
    void loadDetailedSpecieInAdapter(int id, int position);
    void loadPokemonImageInAdapter(PokemonSpecies specie, int position);
}
