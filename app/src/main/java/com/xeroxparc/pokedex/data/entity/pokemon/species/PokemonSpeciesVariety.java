package com.xeroxparc.pokedex.data.entity.pokemon.species;

import com.google.gson.annotations.SerializedName;
import com.xeroxparc.pokedex.data.entity.utility.common.NamedAPIResource;

public class PokemonSpeciesVariety {

	@SerializedName("is_default")
	private Integer isDefault;                      //Whether this variety is the default variety.

	@SerializedName("pokemon")
	private NamedAPIResource pokemonResource;       //The Pokémon variety.
													// (Pokemon)

}
