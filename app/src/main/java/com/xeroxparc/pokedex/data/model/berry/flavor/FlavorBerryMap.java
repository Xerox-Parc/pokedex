package com.xeroxparc.pokedex.data.model.berry.flavor;

import com.google.gson.annotations.SerializedName;
import com.xeroxparc.pokedex.data.model.berry.Berry;

/**
 * @author Fabio Buracchi
 */
public class FlavorBerryMap {

	// How powerful the referenced flavor is for this berry.
	@SerializedName("potency")
	private Integer potency;

	// The berry with the referenced flavor.
	@SerializedName("berry")
	private Berry berry;

}
