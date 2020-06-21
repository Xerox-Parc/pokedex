package com.xeroxparc.pokedex.data.entity.pokemon;

import com.xeroxparc.pokedex.data.entity.utility.Name;
import com.xeroxparc.pokedex.data.entity.utility.NamedAPIResource;

import java.util.List;

public class PokemonShape {

	//Shapes used for sorting Pokémon in a Pokédex.

	private Integer id;                             //The identifier for this resource.
	private String name;                            //The name for this resource.
	private List<AwesomeName> awesome_names;        //The "scientific" name of this Pokémon shape listed in different languages.
	private List<Name> names;                       //The name of this resource listed in different languages.
	private List<NamedAPIResource> pokemon_species; //A list of the Pokémon species that have this shape. (PokemonSpecies)

}
