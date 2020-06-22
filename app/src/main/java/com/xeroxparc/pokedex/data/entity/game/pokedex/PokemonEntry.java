package com.xeroxparc.pokedex.data.entity.game.pokedex;

import com.google.gson.annotations.SerializedName;
import com.xeroxparc.pokedex.data.entity.utility.common.NamedAPIResource;

public class PokemonEntry {

	@SerializedName("entry_number")
	private Integer entryNumber;                        // The index of this Pokémon species entry
														// within the Pokédex.

	@SerializedName("pokemon_species")
	private NamedAPIResource pokemonSpeciesResource;    // The Pokémon species being encountered.
														// (PokemonSpecies)

}
