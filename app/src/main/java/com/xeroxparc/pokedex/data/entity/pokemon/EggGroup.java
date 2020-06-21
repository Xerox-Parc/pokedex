package com.xeroxparc.pokedex.data.entity.pokemon;

import com.xeroxparc.pokedex.data.entity.utility.Name;
import com.xeroxparc.pokedex.data.entity.utility.NamedAPIResource;

import java.util.List;

public class EggGroup {

	//Egg Groups are categories which determine which Pokémon are able to interbreed. Pokémon may belong to either one or two Egg Groups. Check out Bulbapedia for greater detail.

	private Integer id;                                 //The identifier for this resource.
	private String name;                                //The name for this resource.
	private List<Name> names;                           //The name of this resource listed in different languages.
	private List<NamedAPIResource> pokemon_species;     //A list of all Pokémon species that are members of this egg group. (PokemonSpecies)

}
