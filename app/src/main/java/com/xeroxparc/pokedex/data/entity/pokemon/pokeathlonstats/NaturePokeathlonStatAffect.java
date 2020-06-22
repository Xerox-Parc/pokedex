package com.xeroxparc.pokedex.data.entity.pokemon.pokeathlonstats;


import com.google.gson.annotations.SerializedName;
import com.xeroxparc.pokedex.data.entity.utility.common.NamedAPIResource;

public class NaturePokeathlonStatAffect {

	@SerializedName("max_change")
	private Integer maxChange;                      //The maximum amount of change to the referenced Pokéathlon stat.

	@SerializedName("nature")
	private NamedAPIResource natureResource;        //The nature causing the change.
													// (Nature)

}
