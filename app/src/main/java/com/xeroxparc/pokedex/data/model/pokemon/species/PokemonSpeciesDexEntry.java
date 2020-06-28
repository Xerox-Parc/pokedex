package com.xeroxparc.pokedex.data.model.pokemon.species;

import com.google.gson.annotations.SerializedName;
import com.xeroxparc.pokedex.data.model.game.pokedex.Pokedex;

/**
 * @author Fabio Buracchi
 */
public class PokemonSpeciesDexEntry {

	// The index number within the Pokédex.
	@SerializedName("entry_number")
	private Integer entryNumber;

	// The Pokédex the referenced Pokémon species can be found in.
	@SerializedName("pokedex")
	private Pokedex pokedex;

}
