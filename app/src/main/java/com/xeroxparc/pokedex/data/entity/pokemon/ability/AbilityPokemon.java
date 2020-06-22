package com.xeroxparc.pokedex.data.entity.pokemon.ability;

import com.google.gson.annotations.SerializedName;
import com.xeroxparc.pokedex.data.entity.utility.common.NamedAPIResource;

public class AbilityPokemon {

	@SerializedName("is_hidden")
	private Boolean isHidden;                       // Whether or not this a hidden ability for the
													// referenced Pokémon.

	@SerializedName("slot")
	private Integer slot;                           // Pokémon have 3 ability 'slots' which hold
													// references to possible abilities they could
													// have. This is the slot of this ability for
													// the referenced pokemon.

	@SerializedName("pokemon")
	private NamedAPIResource pokemonResource;       // The Pokémon this ability could belong to.
													// (Pokemon)

}
