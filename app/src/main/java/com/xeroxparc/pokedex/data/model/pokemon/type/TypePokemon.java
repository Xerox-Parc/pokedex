package com.xeroxparc.pokedex.data.model.pokemon.type;

import com.google.gson.annotations.SerializedName;
import com.xeroxparc.pokedex.data.model.pokemon.Pokemon;

/**
 * @author Fabio Buracchi
 */
public class TypePokemon {

	// The order the Pokémon's types are listed in.
	@SerializedName("slot")
	private Integer slot;

	// The Pokémon that has the referenced type.
	@SerializedName("pokemon")
	private Pokemon pokemon;

	public Integer getSlot() {
		return slot;
	}

	public Pokemon getPokemon() {
		return pokemon;
	}

}
