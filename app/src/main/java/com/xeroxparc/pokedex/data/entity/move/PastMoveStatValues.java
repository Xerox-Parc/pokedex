package com.xeroxparc.pokedex.data.entity.move;

import com.google.gson.annotations.SerializedName;
import com.xeroxparc.pokedex.data.entity.utility.common.NamedAPIResource;
import com.xeroxparc.pokedex.data.entity.utility.common.VerboseEffect;

import java.util.List;

public class PastMoveStatValues {

	@SerializedName("accuracy")
	private Integer accuracy;                           // The percent value of how likely this move
														// is to be successful.

	@SerializedName("effect_chance")
	private Integer effectChance;                       // The percent value of how likely it is this
														// moves effect will take effect.

	@SerializedName("power")
	private Integer power;                              // The base power of this move with a value
														// of 0 if it does not have a base power.

	@SerializedName("pp")
	private Integer pp;                                 // Power points. The number of times this
														// move can be used.

	@SerializedName("effect_entries")
	private List<VerboseEffect> effectEntryList;        // The effect of this move listed in
														// different languages.

	@SerializedName("type")
	private NamedAPIResource typeResource;              // The elemental type of this move.
														// (Type)

	@SerializedName("version_group")
	private NamedAPIResource versionGroupResource;      // The version group in which these move
														// stat values were in effect.
														// (VersionGroup)

}
