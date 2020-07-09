package com.xeroxparc.pokedex.data.model.utility.common;

import com.google.gson.annotations.SerializedName;
import com.xeroxparc.pokedex.data.model.encounter.conditionvalue.EncounterConditionValue;
import com.xeroxparc.pokedex.data.model.encounter.method.EncounterMethod;

import java.util.List;

/**
 * @author Fabio Buracchi
 */
public class Encounter {

	// The lowest level the Pokémon could be encountered at.
	@SerializedName("min_level")
	private Integer minLevel;

	// The highest level the Pokémon could be encountered at.
	@SerializedName("max_level")
	private Integer maxLevel;

	// A list of condition values that must be in effect for this encounter to occur.
	@SerializedName("condition_values")
	private List<EncounterConditionValue> encounterConditionValueList;

	// Percent chance that this encounter will occur.
	@SerializedName("chance")
	private Integer chance;

	// The method by which this encounter happens.
	@SerializedName("method")
	private EncounterMethod encounterMethod;

	public Integer getMinLevel() {
		return minLevel;
	}

	public Integer getMaxLevel() {
		return maxLevel;
	}

	public List<EncounterConditionValue> getEncounterConditionValueList() {
		return encounterConditionValueList;
	}

	public Integer getChance() {
		return chance;
	}

	public EncounterMethod getEncounterMethod() {
		return encounterMethod;
	}

}
