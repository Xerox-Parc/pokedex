package com.xeroxparc.pokedex.data.entity.contest.type;

import com.google.gson.annotations.SerializedName;
import com.xeroxparc.pokedex.data.entity.utility.common.NamedAPIResource;

import java.util.List;

public class ContestType {

	/*
		Contest types are categories judges used to weigh a Pokémon's condition in Pokémon contests.
		Check out Bulbapedia for greater detail.
	 */

	@SerializedName("id")
	private Integer id;                             // The identifier for this resource.

	@SerializedName("name")
	private String name;                            // The name for this resource.

	@SerializedName("berry_flavor")
	private NamedAPIResource berryFlavorResource;   // The berry flavor that correlates with this
													// contest type.
													// (BerryFlavor)

	@SerializedName("names")
	private List<ContestName> contestNameList;      // The name of this contest type listed in
													// different languages.

}
