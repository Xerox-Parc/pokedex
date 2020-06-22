package com.xeroxparc.pokedex.data.entity.utility.language;

import com.google.gson.annotations.SerializedName;
import com.xeroxparc.pokedex.data.entity.utility.common.Name;

import java.util.List;

public class Language {

	/*
		Languages for translations of API resource information.
	 */

	@SerializedName("id")
	private Integer id;                 // The identifier for this resource.

	@SerializedName("name")
	private String name;                // The name for this resource.

	@SerializedName("official")
	private Boolean official;           // Whether or not the games are published in this language.

	@SerializedName("iso639")
	private String iso639;  	        // The two-letter code of the country where this language
										// is spoken. Note that it is not unique.

	@SerializedName("iso3166")
	private String iso3166;	            // The two-letter code of the language. Note that it is
										// not unique.

	@SerializedName("names")
	private List<Name> nameList;        // The name of this resource listed in different languages.

}
