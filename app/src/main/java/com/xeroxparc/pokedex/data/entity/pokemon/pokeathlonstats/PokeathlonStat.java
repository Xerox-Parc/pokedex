package com.xeroxparc.pokedex.data.entity.pokemon.pokeathlonstats;

import com.google.gson.annotations.SerializedName;
import com.xeroxparc.pokedex.data.entity.utility.common.Name;

import java.util.List;

public class PokeathlonStat {

	/*
		Pokeathlon Stats are different attributes of a Pokémon's performance in Pokéathlons.
		In Pokéathlons, competitions happen on different courses; one for each of the different
		Pokéathlon stats.
		See Bulbapedia for greater detail.
	 */

	@SerializedName("id")
	private Integer id;                                         // The identifier for this resource.

	@SerializedName("name")
	private String name;                                        // The name for this resource.

	@SerializedName("names")
	private List<Name> nameList;                                // The name of this resource listed
																// in different languages.

	@SerializedName("affecting_natures")
	private NaturePokeathlonStatAffectSets affectingNatureSet;  // A detail of natures which affect
																// this Pokéathlon stat positively
																// or negatively.

}
