package com.xeroxparc.pokedex.data.entity.encounter.conditionvalue;

import com.google.gson.annotations.SerializedName;
import com.xeroxparc.pokedex.data.entity.utility.common.Name;
import com.xeroxparc.pokedex.data.entity.utility.common.NamedAPIResource;

import java.util.List;

public class EncounterConditionValue {

	/*
		Encounter condition values are the various states that an encounter condition can have,
		i.e., time of day can be either day or night.
	 */

	@SerializedName("id")
	private Integer id;                             // The identifier for this resource.

	@SerializedName("name")
	private String name;                            // The name for this resource.

	@SerializedName("condition")
	private NamedAPIResource conditionResource;     // The condition this encounter condition value
													// pertains to.
													// (EncounterCondition)

	@SerializedName("names")
	private List<Name> nameList;                    // The name of this resource listed in different
													// languages.

}
