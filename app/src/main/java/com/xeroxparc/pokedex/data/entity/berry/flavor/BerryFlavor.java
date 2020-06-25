package com.xeroxparc.pokedex.data.entity.berry.flavor;

import com.google.gson.annotations.SerializedName;
import com.xeroxparc.pokedex.data.entity.utility.common.Name;
import com.xeroxparc.pokedex.data.entity.utility.common.NamedAPIResource;

import java.util.List;

public class BerryFlavor {

	/*
		Flavors determine whether a Pokémon will benefit or suffer from eating a berry based on
		their nature. Check out Bulbapedia for greater detail.
	 */

	@SerializedName("id")
	private Integer id;                                 // The identifier for this resource.

	@SerializedName("name")
	private String name;                                // The name for this resource.

	@SerializedName("berries")
	private List<FlavorBerryMap> flavorBerryMapList;    // A list of the berries with this flavor.

	@SerializedName("contest_type")
	private NamedAPIResource contestTypeResource;       // The contest type that correlates with this
														// berry flavor.
														// (ContestType)

	@SerializedName("names")
	private List<Name> nameList;                        // The name of this resource listed in
														// different languages.

}
