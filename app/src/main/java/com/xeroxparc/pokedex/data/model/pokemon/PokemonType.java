package com.xeroxparc.pokedex.data.model.pokemon;

import com.google.gson.annotations.SerializedName;
import com.xeroxparc.pokedex.data.model.pokemon.type.Type;

/**
 * @author Fabio Buracchi
 */
public class PokemonType {

	// The order the Pokémon's types are listed in.
	@SerializedName("slot")
	private Integer slot;

	// The type the referenced Pokémon has.
	@SerializedName("type")
	private Type type;

	public Integer getSlot() {
		return slot;
	}

	public Type getType() {
		return type;
	}

}
