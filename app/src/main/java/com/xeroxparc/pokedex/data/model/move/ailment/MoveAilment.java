package com.xeroxparc.pokedex.data.model.move.ailment;

import com.google.gson.annotations.SerializedName;
import com.xeroxparc.pokedex.data.model.move.Move;
import com.xeroxparc.pokedex.data.model.utility.common.Name;
import com.xeroxparc.pokedex.data.model.utility.common.NamedAPIResource;

import java.util.List;

/**
 * Move Ailments are status conditions caused by moves used during battle.
 * See Bulbapedia for greater detail.
 *
 * @author Fabio Buracchi
 */
public class MoveAilment extends NamedAPIResource {

	// A list of moves that cause this ailment.
	@SerializedName("moves")
	private List<Move> moveList;

	// The name of this resource listed in different languages.
	@SerializedName("names")
	private List<Name> nameList;

}
