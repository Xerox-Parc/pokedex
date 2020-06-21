package com.xeroxparc.pokedex.data.entity.move;

import com.xeroxparc.pokedex.data.entity.utility.common.NamedAPIResource;

public class MoveFlavorText {

	private String flavor_text;                 //The localized flavor text for an api resource in a specific language.
	private NamedAPIResource language;          //The language this name is in. (Language)
	private NamedAPIResource version_group;     //The version group that uses this flavor text. (VersionGroup)

}
