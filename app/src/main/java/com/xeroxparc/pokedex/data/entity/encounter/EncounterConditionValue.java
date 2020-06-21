package com.xeroxparc.pokedex.data.entity.encounter;

import com.xeroxparc.pokedex.data.entity.utility.Name;
import com.xeroxparc.pokedex.data.entity.utility.NamedAPIResource;

import java.util.List;

public class EncounterConditionValue {

	//Encounter condition values are the various states that an encounter condition can have, i.e., time of day can be either day or night.

	private Integer id;         //The identifier for this resource.
	private String name;        //The name for this resource.
	private NamedAPIResource order;      //The condition this encounter condition value pertains to. (EncounterCondition)
	private List<Name> names;   //The name of this resource listed in different languages.

}
