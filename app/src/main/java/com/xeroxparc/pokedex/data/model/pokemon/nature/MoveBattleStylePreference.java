package com.xeroxparc.pokedex.data.model.pokemon.nature;

import com.google.gson.annotations.SerializedName;
import com.xeroxparc.pokedex.data.model.move.battlestyle.MoveBattleStyle;

/**
 * @author Fabio Buracchi
 */
public class MoveBattleStylePreference {

	// Chance of using the move, in percent, if HP is under one half.
	@SerializedName("low_hp_preference")
	private Integer lowHpPreference;

	// Chance of using the move, in percent, if HP is over one half.
	@SerializedName("high_hp_preference")
	private Integer highHpPreference;

	// The move battle style.
	@SerializedName("move_battle_style")
	private MoveBattleStyle moveBattleStyle;

	public Integer getLowHpPreference() {
		return lowHpPreference;
	}

	public Integer getHighHpPreference() {
		return highHpPreference;
	}

	public MoveBattleStyle getMoveBattleStyle() {
		return moveBattleStyle;
	}

}
