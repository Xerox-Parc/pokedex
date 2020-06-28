package com.xeroxparc.pokedex.data.model.move.target;

import com.google.gson.annotations.SerializedName;
import com.xeroxparc.pokedex.data.model.move.Move;
import com.xeroxparc.pokedex.data.model.utility.common.Description;
import com.xeroxparc.pokedex.data.model.utility.common.Name;
import com.xeroxparc.pokedex.data.model.utility.common.NamedAPIResource;

import java.util.List;

/**
 * Targets moves can be directed at during battle. Targets can be Pokémon, environments
 * or even other moves.
 *
 * @author Fabio Buracchi
 */
public class MoveTarget extends NamedAPIResource {

	// The description of this resource listed in different languages.
	@SerializedName("descriptions")
	private List<Description> descriptionList;

	// A list of moves that that are directed at this target.
	@SerializedName("moves")
	private List<Move> moveList;

	// The name of this resource listed in different languages.
	@SerializedName("names")
	private List<Name> nameList;

}
