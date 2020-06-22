package com.xeroxparc.pokedex.data.entity.location.region;

import com.google.gson.annotations.SerializedName;
import com.xeroxparc.pokedex.data.entity.utility.common.Name;
import com.xeroxparc.pokedex.data.entity.utility.common.NamedAPIResource;

import java.util.List;

public class Region {

	/*
		A region is an organized area of the Pokémon world. Most often, the main difference between
		regions is the species of Pokémon that can be encountered within them.
	 */

	@SerializedName("id")
	private Integer id;                                         // The identifier for this resource.

	@SerializedName("locations")
	private List<NamedAPIResource> locationListResource;        // A list of locations that can be
																// found in this region.
																// (Location)

	@SerializedName("name")
	private String name;                                        // The name for this resource.

	@SerializedName("names")
	private List<Name> nameList;                                // The name of this resource listed
																// in different languages.

	@SerializedName("main_generation")
	private NamedAPIResource mainGenerationResource;            // The generation this region was
																// introduced in.
																// (Generation)

	@SerializedName("pokedexes")
	private List<NamedAPIResource> pokedexListResource;         // A list of pokédexes that
																// catalogue Pokémon in this region.
																// (Pokedex)

	@SerializedName("version_groups")
	private List<NamedAPIResource> versionGroupListResource;    // A list of version groups where
																// this region can be visited.
																// (VersionGroup)

}
