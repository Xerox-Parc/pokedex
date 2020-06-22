package com.xeroxparc.pokedex.data.entity.pokemon.shape;

import com.google.gson.annotations.SerializedName;
import com.xeroxparc.pokedex.data.entity.utility.common.NamedAPIResource;

public class AwesomeName {

	@SerializedName("awesome_name")
	private String awesomeName;                     //The localized "scientific" name for an API
													// resource in a specific language.

	@SerializedName("language")
	private NamedAPIResource languageResource;      //The language this "scientific" name is in.
													// (Language)

}
