package com.xeroxparc.pokedex.data.entity.berry;

import com.xeroxparc.pokedex.data.entity.utility.common.NamedAPIResource;

public class BerryFlavorMap {

	//Flavors determine whether a Pokémon will benefit or suffer from eating a berry based on their nature. Check out Bulbapedia for greater detail.

	private Integer potency;            //How powerful the referenced flavor is for this berry.
	private NamedAPIResource flavor;    //The referenced berry flavor. (BerryFlavor)
}
