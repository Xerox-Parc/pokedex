package com.xeroxparc.pokedex.data.entity.pokemon.stats;

import com.google.gson.annotations.SerializedName;
import com.xeroxparc.pokedex.data.entity.utility.common.APIResource;
import com.xeroxparc.pokedex.data.entity.utility.common.Name;
import com.xeroxparc.pokedex.data.entity.utility.common.NamedAPIResource;

import java.util.List;

public class Stat {

	/*
		Stats determine certain aspects of battles. Each Pokémon has a value for each stat which
		grows as they gain levels and can be altered momentarily by effects in battles.
	 */

	@SerializedName("id")
	private Integer id;                                         // The identifier for this resource.
	
	@SerializedName("name")
	private String name;                                        // The name for this resource.
	
	@SerializedName("game_index")
	private Integer gameIndex;                                  // ID the games use for this stat.

	@SerializedName("is_battle_only")
	private Boolean isBattleOnly;                               // Whether this stat only exists
																// within a battle.

	@SerializedName("affecting_moves")
	private Boolean affectingMoves;                             // A detail of moves which affect
																// this stat positively or
																// negatively.

	@SerializedName("affecting_natures")
	private Integer affectingNatures;                           // A detail of natures which affect
																// this stat positively or
																// negatively.

	@SerializedName("characteristics")
	private List<APIResource> characteristicListResource;       // A list of characteristics that
																// are set on a Pokémon when its
																// highest base stat is this stat.
																// (Characteristic)

	@SerializedName("move_damage_class")
	private NamedAPIResource moveDamageClassResource;           // The class of damage this stat is
																// directly related to.
																// (MoveDamageClass)
	
	@SerializedName("names")
	private List<Name> nameList;                                // The name of this resource listed
																// in different languages.
																// (PokemonForm)

}
