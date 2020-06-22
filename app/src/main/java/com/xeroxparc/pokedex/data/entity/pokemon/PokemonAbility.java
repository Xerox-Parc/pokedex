package com.xeroxparc.pokedex.data.entity.pokemon;

import com.google.gson.annotations.SerializedName;
import com.xeroxparc.pokedex.data.entity.utility.common.NamedAPIResource;

public class PokemonAbility {

	@SerializedName("is_hidden")
	private Boolean isHidden;                       // Whether or not this is a hidden ability.

	@SerializedName("slot")
	private Integer slot;                           // The slot this ability occupies in this
													// Pokémon species.

	@SerializedName("ability")
	private NamedAPIResource abilityResource;       // The ability the Pokémon may have.
													// (Ability)

}
