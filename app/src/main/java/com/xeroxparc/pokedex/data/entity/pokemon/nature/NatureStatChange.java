package com.xeroxparc.pokedex.data.entity.pokemon.nature;

import com.google.gson.annotations.SerializedName;
import com.xeroxparc.pokedex.data.entity.utility.common.NamedAPIResource;

public class NatureStatChange {

	@SerializedName("max_change")
	private Integer maxChange;                              // The amount of change.

	@SerializedName("pokeathlon_stat")
	private NamedAPIResource pokeathlonStatResource;        // The stat being affected.
															// (PokeathlonStat)

}
