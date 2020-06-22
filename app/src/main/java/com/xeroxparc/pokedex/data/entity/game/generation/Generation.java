package com.xeroxparc.pokedex.data.entity.game.generation;

import com.google.gson.annotations.SerializedName;
import com.xeroxparc.pokedex.data.entity.utility.common.Name;
import com.xeroxparc.pokedex.data.entity.utility.common.NamedAPIResource;

import java.util.List;

public class Generation {

	/*
		A generation is a grouping of the Pokémon games that separates them based on the Pokémon
		they include. In each generation, a new set of Pokémon, Moves, Abilities and Types that did
		not exist in the previous generation are released.
	 */

	@SerializedName("id")
	private Integer id;                                         // The identifier for this resource.

	@SerializedName("name")
	private String name;                                        // The name for this resource.

	@SerializedName("abilities")
	private List<NamedAPIResource> abilityListResource;         // A list of abilities that were
																// introduced in this generation.
																// (Ability)

	@SerializedName("names")
	private List<Name> nameList;                                // The name of this resource listed
																// in different languages.

	@SerializedName("main_region")
	private NamedAPIResource mainRegionResource;                // The main region travelled in this
																// generation.
																// (Region)

	@SerializedName("moves")
	private List<NamedAPIResource> moveListResource;            // A list of moves that were
																// introduced in this generation.
																// (Move)

	@SerializedName("pokemon_species")
	private List<NamedAPIResource> pokemonSpeciesListResource;  // A list of Pokémon species that
																// were introduced in this
																// generation.
																// (PokemonSpecies)

	@SerializedName("types")
	private List<NamedAPIResource> typeListResource;            // A list of types that were
																// introduced in this generation.
																// (Type)

	@SerializedName("version_groups")
	private List<NamedAPIResource> versionGroupListResource;    // A list of version groups that
																// were introduced in this
																// generation.
																// (VersionGroup)

}
