package com.xeroxparc.pokedex.data.entity.pokemon.species;

import com.google.gson.annotations.SerializedName;
import com.xeroxparc.pokedex.data.entity.utility.common.NamedAPIResource;

public class PokemonSpeciesDexEntry {

	@SerializedName("entry_number")
	private Integer entryNumber;                    // The index number within the Pokédex.

	@SerializedName("pokedex")
	private NamedAPIResource pokedexResource;       // The Pokédex the referenced Pokémon species
													// can be found in.
													// (Pokedex)

}
