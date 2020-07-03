package com.xeroxparc.pokedex.data.model.move;

import com.google.gson.annotations.SerializedName;
import com.xeroxparc.pokedex.data.model.game.versiongroup.VersionGroup;
import com.xeroxparc.pokedex.data.model.pokemon.type.Type;
import com.xeroxparc.pokedex.data.model.utility.common.VerboseEffect;

import java.util.List;

/**
 * @author Fabio Buracchi
 */
public class PastMoveStatValues {

	// The percent value of how likely this move is to be successful.
	@SerializedName("accuracy")
	private Integer accuracy;

	// The percent value of how likely it is this moves effect will take effect.
	@SerializedName("effect_chance")
	private Integer effectChance;

	// The base power of this move with a value of 0 if it does not have a base power.
	@SerializedName("power")
	private Integer power;

	// Power points. The number of times this move can be used.
	@SerializedName("pp")
	private Integer pp;

	// The effect of this move listed in different languages.
	@SerializedName("effect_entries")
	private List<VerboseEffect> effectEntryList;

	// The elemental type of this move.
	@SerializedName("type")
	private Type type;

	// The version group in which these move stat values were in effect.
	@SerializedName("version_group")
	private VersionGroup versionGroup;

	public Integer getAccuracy() {
		return accuracy;
	}

	public Integer getEffectChance() {
		return effectChance;
	}

	public Integer getPower() {
		return power;
	}

	public Integer getPp() {
		return pp;
	}

	public List<VerboseEffect> getEffectEntryList() {
		return effectEntryList;
	}

	public Type getType() {
		return type;
	}

	public VersionGroup getVersionGroup() {
		return versionGroup;
	}

}
