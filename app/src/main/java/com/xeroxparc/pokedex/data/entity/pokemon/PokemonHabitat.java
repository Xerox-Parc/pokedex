package com.xeroxparc.pokedex.data.entity.pokemon;

import com.xeroxparc.pokedex.data.entity.utility.Name;
import com.xeroxparc.pokedex.data.entity.utility.NamedAPIResource;

import java.util.List;

public class PokemonHabitat {

	//Habitats are generally different terrain Pokémon can be found in but can also be areas designated for rare or legendary Pokémon.

	private Integer id;                             //The identifier for this resource.
	private String name;                            //The name for this resource.
	private List<Name> names;                       //The name of this resource listed in different languages.
	private List<NamedAPIResource> pokemon_species; //A list of the Pokémon species that can be found in this habitat. (PokemonSpecies)

}
