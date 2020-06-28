package com.xeroxparc.pokedex.data.model.move.battlestyle;

import com.google.gson.annotations.SerializedName;
import com.xeroxparc.pokedex.data.model.utility.common.Name;
import com.xeroxparc.pokedex.data.model.utility.common.NamedApiResource;

import java.util.List;

/**
 * Styles of moves when used in the Battle Palace.
 * See Bulbapedia for greater detail.
 *
 * @author Fabio Buracchi
 */
public class MoveBattleStyle extends NamedApiResource {

	// The name of this resource listed in different languages.
	@SerializedName("names")
	private List<Name> nameList;

}
