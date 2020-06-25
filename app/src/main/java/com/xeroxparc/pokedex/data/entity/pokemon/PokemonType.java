package com.xeroxparc.pokedex.data.entity.pokemon;

import com.google.gson.annotations.SerializedName;
import com.xeroxparc.pokedex.data.entity.utility.common.NamedAPIResource;

public class PokemonType {

	@SerializedName("slot")
	private Integer slot;                       // The order the Pokémon's types are listed in.
												// species.

	@SerializedName("type")
	private NamedAPIResource typeResource;      // The type the referenced Pokémon has.
												// (Type)

}
