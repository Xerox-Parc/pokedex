package com.xeroxparc.pokedex.ui.egggroups.fragments.details;

import com.xeroxparc.pokedex.data.model.pokemon.species.PokemonSpecies;

public interface EggGroupDetailsLoader {
    void loadDetailedSpecieInAdapter(int id, int position);
    void loadPokemonImageInAdapter(PokemonSpecies specie, int position);
}
