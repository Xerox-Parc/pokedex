package com.xeroxparc.pokedex.data.entity.pokemon;

import com.xeroxparc.pokedex.data.entity.utility.Name;
import com.xeroxparc.pokedex.data.entity.utility.NamedAPIResource;
import com.xeroxparc.pokedex.data.entity.utility.VersionGameIndex;

import java.util.List;

public class Pokemon {

	//Pokémon are the creatures that inhabit the world of the Pokémon games. They can be caught using Pokéballs and trained by battling with other Pokémon. Each Pokémon belongs to a specific species but may take on a variant which makes it differ from other Pokémon of the same species, such as base stats, available abilities and typings. See Bulbapedia for greater detail.

	private Integer id;                             //The identifier for this resource.
	private String name;                            //The name for this resource.
	private Integer base_experience;                //The base experience gained for defeating this Pokémon.
	private Integer height;                         //The height of this Pokémon in decimetres.
	private Boolean is_default;                     //Set for exactly one Pokémon used as the default for each species.
	private Integer order;                          //Order for sorting. Almost national order, except families are grouped together.
	private Integer weight;                         //The weight of this Pokémon in hectograms.
	private List<PokemonAbility> abilities;         //The stat increased by 10% in Pokémon with this nature. (Stat)
	private List<NamedAPIResource> forms;           //A list of forms this Pokémon can take on. (PokemonForm)
	private List<VersionGameIndex> game_indices;    //A list of game indices relevent to Pokémon item by generation.
	private List<PokemonHeldItem> held_items;       //A list of items this Pokémon may be holding when encountered.
	private String location_area_encounters;        //A link to a list of location areas, as well as encounter details pertaining to specific versions.
	private List<PokemonMove> moves;                //A list of moves along with learn methods and level details pertaining to specific version groups.
	private PokemonSprites sprites;                 //A set of sprites used to depict this Pokémon in the game.
	private NamedAPIResource species;               //The species this Pokémon belongs to. (PokemonSpecies)
	private List<PokemonStat> stats;                //A list of base stat values for this Pokémon.
	private List<PokemonType> types;                //A list of details showing types this Pokémon has.

}
