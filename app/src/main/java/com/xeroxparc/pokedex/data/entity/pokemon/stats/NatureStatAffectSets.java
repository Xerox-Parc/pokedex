package com.xeroxparc.pokedex.data.entity.pokemon.stats;

import com.google.gson.annotations.SerializedName;
import com.xeroxparc.pokedex.data.entity.utility.common.NamedAPIResource;

import java.util.List;

public class NatureStatAffectSets {

	@SerializedName("increase")
	private List<NamedAPIResource> increaseListResource;        // A list of natures and how they
																// change the referenced stat.
																// (Nature)

	@SerializedName("decrease")
	private List<NamedAPIResource> decreaseListResource;        // A list of natures and how they
																// change the referenced stat.
																// (Nature)

}
