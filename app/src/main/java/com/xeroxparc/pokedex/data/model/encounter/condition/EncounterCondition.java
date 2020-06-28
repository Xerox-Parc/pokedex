package com.xeroxparc.pokedex.data.model.encounter.condition;

import com.google.gson.annotations.SerializedName;
import com.xeroxparc.pokedex.data.model.encounter.conditionvalue.EncounterConditionValue;
import com.xeroxparc.pokedex.data.model.utility.common.Name;
import com.xeroxparc.pokedex.data.model.utility.common.NamedApiResource;

import java.util.List;

/**
 * Conditions which affect what pokemon might appear in the wild, e.g., day or night.
 *
 * @author Fabio Buracchi
 */
public class EncounterCondition extends NamedApiResource {

	// The name of this resource listed in different languages.
	@SerializedName("names")
	private List<Name> nameList;

	// A list of possible values for this encounter condition.
	@SerializedName("values")
	private List<EncounterConditionValue> valueList;

}
