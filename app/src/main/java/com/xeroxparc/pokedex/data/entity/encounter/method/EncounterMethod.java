package com.xeroxparc.pokedex.data.entity.encounter.method;

import com.google.gson.annotations.SerializedName;
import com.xeroxparc.pokedex.data.entity.utility.common.Name;

import java.util.List;

public class EncounterMethod {

	/*
		Methods by which the player might can encounter Pokémon in the wild, e.g., walking in tall
		grass. Check out Bulbapedia for greater detail.
	 */

	@SerializedName("id")
	private Integer id;                 // The identifier for this resource.

	@SerializedName("name")
	private String name;                // The name for this resource.

	@SerializedName("order")
	private Integer order;              // A good value for sorting.

	@SerializedName("names")
	private List<Name> nameList;        // The name of this resource listed in different languages.

}