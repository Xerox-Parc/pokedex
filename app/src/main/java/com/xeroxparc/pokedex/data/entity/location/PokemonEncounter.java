package com.xeroxparc.pokedex.data.entity.location;

import com.xeroxparc.pokedex.data.entity.utility.NamedAPIResource;

import java.util.List;

public class PokemonEncounter {

	private NamedAPIResource pokemon;                       //The Pokémon being encountered. (Pokemon)
	private List<EncounterVersionDetails> version_details;  //A list of versions and encounters with Pokémon that might happen in the referenced location area.

}
