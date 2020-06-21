package com.xeroxparc.pokedex.data.entity.pokemon;

import com.xeroxparc.pokedex.data.entity.utility.Name;
import com.xeroxparc.pokedex.data.entity.utility.NamedAPIResource;

import java.util.List;

public class PokemonColor {

	//Colors used for sorting Pokémon in a Pokédex. The color listed in the Pokédex is usually the color most apparent or covering each Pokémon's body. No orange category exists; Pokémon that are primarily orange are listed as red or brown.

	private Integer id;                                 //The identifier for this resource.
	private String name;                                //The name for this resource.
	private List<Name> names;                           //The name of this resource listed in different languages.
	private List<NamedAPIResource> pokemon_species;     //A list of the Pokémon species that have this color. (PokemonSpecies)

}
