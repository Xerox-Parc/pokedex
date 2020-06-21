package com.xeroxparc.pokedex.data.entity.utility;

import java.util.List;

public class Language {

	//Languages for translations of API resource information.

	private Integer id;	 //The identifier for this resource.
	private String name;	//The name for this resource.
	private Boolean official;   //Whether or not the games are published in this language.
	private String iso639;	  //The two-letter code of the country where this language is spoken. Note that it is not unique.
	private String iso3166;	 //The two-letter code of the language. Note that it is not unique.
	private List<Name> names; //The name of this resource listed in different languages.

}
