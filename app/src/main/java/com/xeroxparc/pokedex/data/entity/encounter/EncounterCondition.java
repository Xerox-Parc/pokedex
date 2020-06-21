package com.xeroxparc.pokedex.data.entity.encounter;

import com.xeroxparc.pokedex.data.entity.utility.Name;
import com.xeroxparc.pokedex.data.entity.utility.NamedAPIResource;

import java.util.List;

public class EncounterCondition {

	//Conditions which affect what pokemon might appear in the wild, e.g., day or night.

	private Integer id;                     //The identifier for this resource.
	private String name;                    //The name for this resource.
	private List<Name> names;               //The name of this resource listed in different languages.
	private List<NamedAPIResource> values;  //A list of possible values for this encounter condition. (EncounterConditionValue)

}
