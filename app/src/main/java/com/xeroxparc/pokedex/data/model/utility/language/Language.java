package com.xeroxparc.pokedex.data.model.utility.language;

import com.google.gson.annotations.SerializedName;
import com.xeroxparc.pokedex.data.model.utility.common.Name;
import com.xeroxparc.pokedex.data.model.utility.common.NamedAPIResource;

import java.util.List;

/**
 * Languages for translations of API resource information.
 *
 * @author Fabio Buracchi
 */
public class Language extends NamedAPIResource {

	// Whether or not the games are published in this language.
	@SerializedName("official")
	private Boolean official;

	// The two-letter code of the country where this language is spoken. Note that it is not unique.
	@SerializedName("iso639")
	private String iso639;

	// The two-letter code of the language. Note that it is not unique.
	@SerializedName("iso3166")
	private String iso3166;

	// The name of this resource listed in different languages.
	@SerializedName("names")
	private List<Name> nameList;

}
