package com.xeroxparc.pokedex.data.entity.pokemon.type;

import com.google.gson.annotations.SerializedName;
import com.xeroxparc.pokedex.data.entity.utility.common.NamedAPIResource;

public class TypePokemon {

	@SerializedName("slot")
	private Integer slot;                           // The order the Pokémon's types are listed in.

	@SerializedName("pokemon")
	private NamedAPIResource pokemonResource;       // The Pokémon that has the referenced type.
													// (Pokemon)

}
