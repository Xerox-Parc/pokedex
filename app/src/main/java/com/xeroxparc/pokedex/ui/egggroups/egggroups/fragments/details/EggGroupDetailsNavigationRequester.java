package com.xeroxparc.pokedex.ui.egggroups.egggroups.fragments.details;

import com.xeroxparc.pokedex.ui.egggroups.constants.EggGroupType;

public interface EggGroupDetailsNavigationRequester {
    void navigateToEggGroup(EggGroupType type);
    void navigateToPokemon(int pokemonId);
}
