package com.xeroxparc.pokedex.data.entity.move.ailment;

import com.google.gson.annotations.SerializedName;
import com.xeroxparc.pokedex.data.entity.utility.common.Name;
import com.xeroxparc.pokedex.data.entity.utility.common.NamedAPIResource;

import java.util.List;

public class MoveAilment {

	/*
		Move Ailments are status conditions caused by moves used during battle.
		See Bulbapedia for greater detail.
	 */

	@SerializedName("id")
	private Integer id;                                 // The identifier for this resource.

	@SerializedName("name")
	private String name;                                // The name for this resource.

	@SerializedName("moves")
	private List<NamedAPIResource> moveListResource;    // A list of moves that cause this ailment.
														// (Move)

	@SerializedName("names")
	private List<Name> nameList;                        // The name of this resource listed in
														// different languages.

}
