package com.xeroxparc.pokedex.data.model.game.version;

import com.google.gson.annotations.SerializedName;
import com.xeroxparc.pokedex.data.model.game.versiongroup.VersionGroup;
import com.xeroxparc.pokedex.data.model.utility.common.Name;
import com.xeroxparc.pokedex.data.model.utility.common.NamedAPIResource;

import java.util.List;

/**
 * Versions of the games, e.g., Red, Blue or Yellow.
 *
 * @author Fabio Buracchi
 */
public class Version extends NamedAPIResource {

	// The name of this resource listed in different languages.
	@SerializedName("names")
	private List<Name> nameList;

	// The version group this version belongs to.
	@SerializedName("version_group")
	private VersionGroup versionGroup;

}
