package com.xeroxparc.pokedex.data.entity.utility.common;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Encounter {

	@SerializedName("min_level")
	private Integer minLevel;                                       // The lowest level the Pokémon
																	// could be encountered at.

	@SerializedName("max_level")
	private Integer maxLevel;                                       // The highest level the Pokémon
																	// could be encountered at.

	@SerializedName("condition_values")
	private List<NamedAPIResource> conditionValueListResource;      // A list of condition values
																	// that must be in effect for
																	// this encounter to occur.
																	// (EncounterConditionValue)

	@SerializedName("chance")
	private Integer chance;                                         // Percent chance that this
																	// encounter will occur.

	@SerializedName("method")
	private NamedAPIResource method;                                // The method by which this
																	// encounter happens.
																	// (EncounterMethod)

}
