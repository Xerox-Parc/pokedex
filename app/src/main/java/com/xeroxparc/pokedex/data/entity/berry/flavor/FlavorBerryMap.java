package com.xeroxparc.pokedex.data.entity.berry.flavor;

import com.google.gson.annotations.SerializedName;
import com.xeroxparc.pokedex.data.entity.utility.common.NamedAPIResource;

public class FlavorBerryMap {

	@SerializedName("potency")
	private Integer potency;                    // How powerful the referenced flavor is for this
												// berry.

	@SerializedName("berry")
	private NamedAPIResource berryResource ;    // The berry with the referenced flavor.
												// (Berry)

}
