package com.xeroxparc.pokedex.data.model.pokemon.stats;

import com.google.gson.annotations.SerializedName;
import com.xeroxparc.pokedex.data.model.pokemon.nature.Nature;

import java.util.List;

/**
 * @author Fabio Buracchi
 */
public class NatureStatAffectSets {

	// A list of natures and how they change the referenced stat.
	@SerializedName("increase")
	private List<Nature> increaseList;

	// A list of natures and how they change the referenced stat.
	@SerializedName("decrease")
	private List<Nature> decreaseList;

}
