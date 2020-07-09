package com.xeroxparc.pokedex.ui.egggroups.fragments.details;

import com.xeroxparc.pokedex.ui.egggroups.constants.EggGroupType;
/*
 * Interface that can navigate to the selected Pokemon Details or to the selected Egg Group
 *
 * @author Abdelrahman Abdelrahman (CptPackage)
 * */
public interface EggGroupDetailsNavigationRequester {
    void navigateToEggGroup(EggGroupType type);
    void navigateToPokemon(int pokemonId);
}
