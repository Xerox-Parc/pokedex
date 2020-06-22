package com.xeroxparc.pokedex.data.entity.location;

import com.google.gson.annotations.SerializedName;
import com.xeroxparc.pokedex.data.entity.utility.common.GenerationGameIndex;
import com.xeroxparc.pokedex.data.entity.utility.common.Name;
import com.xeroxparc.pokedex.data.entity.utility.common.NamedAPIResource;

import java.util.List;

public class Location {

	/*
		Locations that can be visited within the games. Locations make up sizable portions of
		regions, like cities or routes.
	 */

	@SerializedName("id")
	private Integer id;                                 // The identifier for this resource.

	@SerializedName("name")
	private String name;                                // The name for this resource.

	@SerializedName("region")
	private NamedAPIResource regionResource;            // The region this location can be found in.
														// (Region)

	@SerializedName("names")
	private List<Name> nameList;                        // The name of this resource listed in
														// different languages.

	@SerializedName("game_indices")
	private List<GenerationGameIndex> gameIndexList;    // A list of game indices relevent to this
														// location by generation.

	@SerializedName("areas")
	private List<NamedAPIResource> areaListResource;    // Areas that can be found within this
														// location.
														// (LocationArea)

}
