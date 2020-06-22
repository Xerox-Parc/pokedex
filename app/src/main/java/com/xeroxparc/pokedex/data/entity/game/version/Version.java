package com.xeroxparc.pokedex.data.entity.game.version;

import com.google.gson.annotations.SerializedName;
import com.xeroxparc.pokedex.data.entity.utility.common.Name;
import com.xeroxparc.pokedex.data.entity.utility.common.NamedAPIResource;

import java.util.List;

public class Version {

	/*
		Versions of the games, e.g., Red, Blue or Yellow.
	 */

	@SerializedName("id")
	private Integer id;                                 // The identifier for this resource.

	@SerializedName("name")
	private String name;                                // The name for this resource.

	@SerializedName("names")
	private List<Name> nameList;                        // The name of this resource listed in
														// different languages.

	@SerializedName("version_group")
	private NamedAPIResource versionGroupResource;      // The version group this version belongs to.
														// (VersionGroup)

}
