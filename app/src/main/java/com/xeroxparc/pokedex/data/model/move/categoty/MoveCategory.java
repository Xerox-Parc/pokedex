package com.xeroxparc.pokedex.data.model.move.categoty;

import com.google.gson.annotations.SerializedName;
import com.xeroxparc.pokedex.data.model.move.Move;
import com.xeroxparc.pokedex.data.model.utility.common.Description;
import com.xeroxparc.pokedex.data.model.utility.common.NamedAPIResource;

import java.util.List;

/**
 * Very general categories that loosely group move effects.
 *
 * @author Fabio Buracchi
 */
public class MoveCategory extends NamedAPIResource {

	// A list of moves that fall into this category.
	@SerializedName("moves")
	private List<Move> moveList;

	// The description of this resource listed in different languages.
	@SerializedName("descriptions")
	private List<Description> descriptionList;

}
