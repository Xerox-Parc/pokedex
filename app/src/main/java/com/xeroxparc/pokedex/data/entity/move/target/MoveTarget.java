package com.xeroxparc.pokedex.data.entity.move.target;

import com.google.gson.annotations.SerializedName;
import com.xeroxparc.pokedex.data.entity.utility.common.Description;
import com.xeroxparc.pokedex.data.entity.utility.common.Name;
import com.xeroxparc.pokedex.data.entity.utility.common.NamedAPIResource;

import java.util.List;

public class MoveTarget {

	/*
		Targets moves can be directed at during battle. Targets can be Pokémon, environments
		or even other moves.
	 */

	@SerializedName("id")
	private Integer id;                                     // The identifier for this resource.

	@SerializedName("name")
	private String name;                                    // The name for this resource.

	@SerializedName("descriptions")
	private List<Description> descriptionList;              // The description of this resource
															// listed in different languages.

	@SerializedName("moves")
	private List<NamedAPIResource> moveListResource;        // A list of moves that that are
															// directed at this target.
															// (Move)

	@SerializedName("names")
	private List<Name> nameList;                            // The name of this resource listed in
															// different languages.

}
