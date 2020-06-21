package com.xeroxparc.pokedex.data.entity.pokemon;

import com.xeroxparc.pokedex.data.entity.utility.NamedAPIResource;

public class MoveBattleStylePreference {

	private Integer low_hp_preference;              //Chance of using the move, in percent, if HP is under one half.
	private Integer high_hp_preference;             //Chance of using the move, in percent, if HP is over one half.
	private NamedAPIResource move_battle_style;     //The move battle style. (MoveBattleStyle)

}
