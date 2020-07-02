package com.xeroxparc.pokedex.data.model.berry;

import com.google.gson.annotations.SerializedName;
import com.xeroxparc.pokedex.data.model.berry.flavor.BerryFlavor;

/**
 * Flavors determine whether a Pokémon will benefit or suffer from eating a berry based on
 * their nature. Check out Bulbapedia for greater detail.
 *
 * @author Fabio Buracchi
 */
public class BerryFlavorMap {

	// How powerful the referenced flavor is for this berry.
	@SerializedName("potency")
	private Integer potency;

	// The referenced berry flavor.
	@SerializedName("flavor")
	private BerryFlavor flavor;

	public Integer getPotency() {
		return potency;
	}

	public BerryFlavor getFlavor() {
		return flavor;
	}

}
