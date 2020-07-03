package com.xeroxparc.pokedex.data.model.pokemon.species;

import com.google.gson.annotations.SerializedName;
import com.xeroxparc.pokedex.data.model.pokemon.Pokemon;

/**
 * @author Fabio Buracchi
 */
public class PokemonSpeciesVariety {

	// Whether this variety is the default variety.
	@SerializedName("is_default")
	private Boolean isDefault;

	// The Pokémon variety.
	@SerializedName("pokemon")
	private Pokemon pokemon;

	public Boolean getDefault() {
		return isDefault;
	}

	public Pokemon getPokemon() {
		return pokemon;
	}

}
