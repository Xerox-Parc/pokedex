package com.xeroxparc.pokedex.data.model.pokemon.ability;

import com.google.gson.annotations.SerializedName;
import com.xeroxparc.pokedex.data.model.pokemon.Pokemon;

/**
 * @author Fabio Buracchi
 */
public class AbilityPokemon {

	// Whether or not this a hidden ability for the referenced Pokémon.
	@SerializedName("is_hidden")
	private Boolean isHidden;

	// Pokémon have 3 ability 'slots' which hold references to possible abilities they could have. This is the slot of this ability for the referenced pokemon.
	@SerializedName("slot")
	private Integer slot;

	// The Pokémon this ability could belong to.
	@SerializedName("pokemon")
	private Pokemon pokemon;

	public Boolean getHidden() {
		return isHidden;
	}

	public Integer getSlot() {
		return slot;
	}

	public Pokemon getPokemon() {
		return pokemon;
	}

}
