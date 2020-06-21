package com.xeroxparc.pokedex.data.entity.game;

import com.xeroxparc.pokedex.data.entity.utility.Name;
import com.xeroxparc.pokedex.data.entity.utility.NamedAPIResource;

import java.util.List;

public class Generation {

	//A generation is a grouping of the Pokémon games that separates them based on the Pokémon they include. In each generation, a new set of Pokémon, Moves, Abilities and Types that did not exist in the previous generation are released.

	private Integer id;                                 //The identifier for this resource.
	private String name;                                //The name for this resource.
	private List<NamedAPIResource> abilities;           //A list of abilities that were introduced in this generation. (Ability)
	private List<Name> names;                           //The name of this resource listed in different languages.
	private NamedAPIResource main_region;               //The main region travelled in this generation. (Region)
	private List<NamedAPIResource> moves;               //A list of moves that were introduced in this generation. (Move)
	private List<NamedAPIResource> pokemon_species;     //A list of Pokémon species that were introduced in this generation. (PokemonSpecies)
	private List<NamedAPIResource> types;               //A list of types that were introduced in this generation. (Type)
	private List<NamedAPIResource> version_groups;      //A list of version groups that were introduced in this generation. (VersionGroup)

}
