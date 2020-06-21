package com.xeroxparc.pokedex.data.entity.encounter.method;

import com.xeroxparc.pokedex.data.entity.utility.common.Name;

import java.util.List;

public class EncounterMethod {

	//Methods by which the player might can encounter Pokémon in the wild, e.g., walking in tall grass. Check out Bulbapedia for greater detail.

	private Integer id;         //The identifier for this resource.
	private String name;        //The name for this resource.
	private Integer order;      //A good value for sorting.
	private List<Name> names;   //The name of this resource listed in different languages.

}