package com.xeroxparc.pokedex.data.model.encounter.conditionvalue;

import com.google.gson.annotations.SerializedName;
import com.xeroxparc.pokedex.data.model.encounter.condition.EncounterCondition;
import com.xeroxparc.pokedex.data.model.utility.common.Name;
import com.xeroxparc.pokedex.data.model.utility.common.NamedApiResource;

import java.util.List;

/**
 * Encounter condition values are the various states that an encounter condition can have,
 * i.e., time of day can be either day or night.
 *
 * @author Fabio Buracchi
 */
public class EncounterConditionValue extends NamedApiResource {

	// The condition this encounter condition value pertains to.
	@SerializedName("condition")
	private EncounterCondition condition;

	// The name of this resource listed in different languages.
	@SerializedName("names")
	private List<Name> nameList;

}
