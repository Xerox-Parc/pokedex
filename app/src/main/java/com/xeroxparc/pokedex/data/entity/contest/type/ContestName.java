package com.xeroxparc.pokedex.data.entity.contest.type;

import com.google.gson.annotations.SerializedName;
import com.xeroxparc.pokedex.data.entity.utility.common.NamedAPIResource;

public class ContestName {

	@SerializedName("name")
	private String name;                        // The name for this contest.

	@SerializedName("color")
	private String color;                       // The color associated with this contest's name.

	@SerializedName("language")
	private NamedAPIResource languageResource;  // The language that this name is in.
												// (Language)

}
