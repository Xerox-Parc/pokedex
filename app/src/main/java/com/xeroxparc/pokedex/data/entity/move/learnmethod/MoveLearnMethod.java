package com.xeroxparc.pokedex.data.entity.move.learnmethod;

import com.google.gson.annotations.SerializedName;
import com.xeroxparc.pokedex.data.entity.utility.common.Description;
import com.xeroxparc.pokedex.data.entity.utility.common.Name;
import com.xeroxparc.pokedex.data.entity.utility.common.NamedAPIResource;

import java.util.List;

public class MoveLearnMethod {

	/*
		Methods by which Pokémon can learn moves.
	 */

	@SerializedName("id")
	private Integer id;                                         // The identifier for this resource.

	@SerializedName("name")
	private String name;                                        // The name for this resource.

	@SerializedName("descriptions")
	private List<Description> descriptionList;                  // The description of this resource
																// listed in different languages.

	@SerializedName("names")
	private List<Name> nameList;                                // The name of this resource listed
																// in different languages.

	@SerializedName("version_groups")
	private List<NamedAPIResource> versionGroupListResource;    // A list of moves that fall into
																// this damage class.
																// (VersionGroup)

}
