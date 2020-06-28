package com.xeroxparc.pokedex.data.model.move.learnmethod;

import com.google.gson.annotations.SerializedName;
import com.xeroxparc.pokedex.data.model.game.versiongroup.VersionGroup;
import com.xeroxparc.pokedex.data.model.utility.common.Description;
import com.xeroxparc.pokedex.data.model.utility.common.Name;
import com.xeroxparc.pokedex.data.model.utility.common.NamedAPIResource;

import java.util.List;

/**
 * Methods by which Pokémon can learn moves.
 *
 * @author Fabio Buracchi
 */
public class MoveLearnMethod extends NamedAPIResource {

	// The description of this resource listed in different languages.
	@SerializedName("descriptions")
	private List<Description> descriptionList;

	// The name of this resource listed in different languages.
	@SerializedName("names")
	private List<Name> nameList;

	// A list of moves that fall into this damage class.
	@SerializedName("version_groups")
	private List<VersionGroup> versionGroupList;

}
