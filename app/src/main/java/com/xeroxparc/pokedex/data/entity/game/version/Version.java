package com.xeroxparc.pokedex.data.entity.game.version;

import com.xeroxparc.pokedex.data.entity.utility.common.Name;
import com.xeroxparc.pokedex.data.entity.utility.common.NamedAPIResource;

import java.util.List;

public class Version {

	//Versions of the games, e.g., Red, Blue or Yellow.

	private Integer id;                         //The identifier for this resource.
	private String name;                        //The name for this resource.
	private List<Name> names;                   //The name of this resource listed in different languages.
	private NamedAPIResource version_group;     //The version group this version belongs to. (VersionGroup)

}
