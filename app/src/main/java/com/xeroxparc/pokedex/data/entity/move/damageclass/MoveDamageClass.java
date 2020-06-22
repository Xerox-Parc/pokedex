package com.xeroxparc.pokedex.data.entity.move.damageclass;

import com.google.gson.annotations.SerializedName;
import com.xeroxparc.pokedex.data.entity.utility.common.Description;
import com.xeroxparc.pokedex.data.entity.utility.common.Name;
import com.xeroxparc.pokedex.data.entity.utility.common.NamedAPIResource;

import java.util.List;

public class MoveDamageClass {

	/*
		Damage classes moves can have, e.g. physical, special, or non-damaging.
	 */

	@SerializedName("id")
	private Integer id;                                 // The identifier for this resource.

	@SerializedName("name")
	private String name;                                // The name for this resource.

	@SerializedName("descriptions")
	private List<Description> descriptionList;          // The description of this resource listed
														// in different languages.

	@SerializedName("moves")
	private List<NamedAPIResource> moveListResource;    // A list of moves that fall into this
														// damage class.
														// (Move)

	@SerializedName("names")
	private List<Name> nameList;                        // The name of this resource listed in
														// different languages.

}
