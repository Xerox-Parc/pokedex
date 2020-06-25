package com.xeroxparc.pokedex.data.entity.encounter.condition;

import com.google.gson.annotations.SerializedName;
import com.xeroxparc.pokedex.data.entity.utility.common.Name;
import com.xeroxparc.pokedex.data.entity.utility.common.NamedAPIResource;

import java.util.List;

public class EncounterCondition {

	/*
		Conditions which affect what pokemon might appear in the wild, e.g., day or night.
	 */

	@SerializedName("id")
	private Integer id;                                 // The identifier for this resource.

	@SerializedName("name")
	private String name;                                // The name for this resource.

	@SerializedName("names")
	private List<Name> nameList;                        // The name of this resource listed in
														// different languages.

	@SerializedName("values")
	private List<NamedAPIResource> valueListResource;   // A list of possible values for this
														// encounter condition.
														// (EncounterConditionValue)

}
