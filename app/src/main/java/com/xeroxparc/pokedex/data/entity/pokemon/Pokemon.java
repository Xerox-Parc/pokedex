package com.xeroxparc.pokedex.data.entity.pokemon;

import com.google.gson.annotations.SerializedName;
import com.xeroxparc.pokedex.data.entity.utility.common.NamedAPIResource;
import com.xeroxparc.pokedex.data.entity.utility.common.VersionGameIndex;

import java.util.List;

public class Pokemon {

	/*
		Pokémon are the creatures that inhabit the world of the Pokémon games. They can be caught
		using Pokéballs and trained by battling with other Pokémon. Each Pokémon belongs to a
		specific species but may take on a variant which makes it differ from other Pokémon of the
		same species, such as base stats, available abilities and typings.
		See Bulbapedia for greater detail.
	*/

	@SerializedName("id")
	private Integer id;                                 // The identifier for this resource.

	@SerializedName("name")
	private String name;                                // The name for this resource.

	@SerializedName("base_experience")
	private Integer baseExperience;                     // The base experience gained for defeating
														// this Pokémon.

	@SerializedName("height")
	private Integer height;                             // The height of this Pokémon in decimetres.

	@SerializedName("is_default")
	private Boolean isDefault;                          // Set for exactly one Pokémon used as the
														// default for each species.

	@SerializedName("order")
	private Integer order;                              // Order for sorting. Almost national order,
														// except families are grouped together.

	@SerializedName("weight")
	private Integer weight;                             // The weight of this Pokémon in hectograms.

	@SerializedName("abilities")
	private List<PokemonAbility> abilityList;           // A list of abilities this Pokémon could
														// potentially have.

	@SerializedName("forms")
	private List<NamedAPIResource> formResourceList;    // A list of forms this Pokémon can take on.
														// (PokemonForm)

	@SerializedName("game_indices")
	private List<VersionGameIndex> gameIndexList;       // A list of game indices relevent to
														// Pokémon item by generation.

	@SerializedName("held_items")
	private List<PokemonHeldItem> heldItemList;         // A list of items this Pokémon may be
														// holding when encountered.

	@SerializedName("location_area_encounters")
	private String locationAreaEncounters;              // A link to a list of location areas, as
														// well as encounter details pertaining to
														// specific versions.

	@SerializedName("moves")
	private List<PokemonMove> moveList;                 // A list of moves along with learn methods
														// and level details pertaining to specific
														// version groups.

	@SerializedName("sprites")
	private PokemonSprites sprite;                      // A set of sprites used to depict this
														// Pokémon in the game.

	@SerializedName("species")
	private NamedAPIResource speciesResource;           // The species this Pokémon belongs to.
														// (PokemonSpecies)

	@SerializedName("stats")
	private List<PokemonStat> stats;                    // A list of base stat values for this
														// Pokémon.

	@SerializedName("types")
	private List<PokemonType> typeList;                 // A list of details showing types this
														// Pokémon has.

}
