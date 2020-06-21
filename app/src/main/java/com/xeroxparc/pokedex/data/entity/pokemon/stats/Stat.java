package com.xeroxparc.pokedex.data.entity.pokemon.stats;

import com.xeroxparc.pokedex.data.entity.utility.common.APIResource;
import com.xeroxparc.pokedex.data.entity.utility.common.Name;
import com.xeroxparc.pokedex.data.entity.utility.common.NamedAPIResource;

import java.util.List;

public class Stat {

	//Stats determine certain aspects of battles. Each Pokémon has a value for each stat which grows as they gain levels and can be altered momentarily by effects in battles.

	private Integer id;                             //The identifier for this resource.
	private String name;                            //The name for this resource.
	private Integer game_index;                     //ID the games use for this stat.
	private Boolean is_battle_only;                 //Whether this stat only exists within a battle.
	private Boolean affecting_moves;                //A detail of moves which affect this stat positively or negatively.
	private Integer affecting_natures;              //A detail of natures which affect this stat positively or negatively.
	private List<APIResource> characteristics;      //A list of characteristics that are set on a Pokémon when its highest base stat is this stat. (Characteristic)
	private NamedAPIResource move_damage_class;     //The class of damage this stat is directly related to. (MoveDamageClass)
	private List<Name> names;                       //The name of this resource listed in different languages. (PokemonForm)

}
