package com.xeroxparc.pokedex.data.model.contest.type;

import com.google.gson.annotations.SerializedName;
import com.xeroxparc.pokedex.data.model.utility.language.Language;

/**
 * @author Fabio Buracchi
 */
public class ContestName {

	// The name for this contest.
	@SerializedName("name")
	private String name;

	// The color associated with this contest's name.
	@SerializedName("color")
	private String color;

	// The language that this name is in.
	@SerializedName("language")
	private Language language;

}
