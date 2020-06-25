package com.xeroxparc.pokedex.data.entity.pokemon.nature;

import com.google.gson.annotations.SerializedName;
import com.xeroxparc.pokedex.data.entity.utility.common.NamedAPIResource;

public class MoveBattleStylePreference {

	@SerializedName("low_hp_preference")
	private Integer lowHpPreference;                        // Chance of using the move, in percent,
															// if HP is under one half.

	@SerializedName("high_hp_preference")
	private Integer highHpPreference;                       // Chance of using the move, in percent,
															// if HP is over one half.

	@SerializedName("move_battle_style")
	private NamedAPIResource moveBattleStyleResource;       // The move battle style.
															// (MoveBattleStyle)


}
