package com.xeroxparc.pokedex.data.model.pokemon.stats;

import com.google.gson.annotations.SerializedName;
import com.xeroxparc.pokedex.data.model.move.damageclass.MoveDamageClass;
import com.xeroxparc.pokedex.data.model.pokemon.characteristic.Characteristic;
import com.xeroxparc.pokedex.data.model.utility.common.Name;
import com.xeroxparc.pokedex.data.model.utility.common.NamedAPIResource;

import java.util.List;

/**
 * Stats determine certain aspects of battles. Each Pokémon has a value for each stat which
 * grows as they gain levels and can be altered momentarily by effects in battles.
 *
 * @author Fabio Buracchi
 */
public class Stat extends NamedAPIResource {

	// ID the games use for this stat.
	@SerializedName("game_index")
	private Integer gameIndex;

	// Whether this stat only exists within a battle.
	@SerializedName("is_battle_only")
	private Boolean isBattleOnly;

	// A detail of moves which affect this stat positively or negatively.
	@SerializedName("affecting_moves")
	private MoveStatAffectSets affectingMoves;

	// A detail of natures which affect this stat positively or negatively.
	@SerializedName("affecting_natures")
	private NatureStatAffectSets affectingNatures;

	// A list of characteristics that are set on a Pokémon when its highest base stat is this stat.
	@SerializedName("characteristics")
	private List<Characteristic> characteristicList;

	// The class of damage this stat is directly related to.
	@SerializedName("move_damage_class")
	private MoveDamageClass moveDamageClass;

	// The name of this resource listed in different languages.
	@SerializedName("names")
	private List<Name> nameList;

}
