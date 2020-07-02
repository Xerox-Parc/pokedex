package com.xeroxparc.pokedex.data.model.move.categoty;

import androidx.room.Entity;

import com.google.gson.annotations.SerializedName;
import com.xeroxparc.pokedex.data.model.move.Move;
import com.xeroxparc.pokedex.data.model.utility.common.Description;
import com.xeroxparc.pokedex.data.model.utility.common.NamedApiResource;

import java.util.List;

/**
 * Very general categories that loosely group move effects.
 *
 * @author Fabio Buracchi
 */
@Entity(tableName = "move_category")
public class MoveCategory extends NamedApiResource {

	// A list of moves that fall into this category.
	@SerializedName("moves")
	private List<Move> moveList;

	// The description of this resource listed in different languages.
	@SerializedName("descriptions")
	private List<Description> descriptionList;

	public List<Move> getMoveList() {
		return moveList;
	}

	public void setMoveList(List<Move> moveList) {
		this.moveList = moveList;
	}

	public List<Description> getDescriptionList() {
		return descriptionList;
	}

	public void setDescriptionList(List<Description> descriptionList) {
		this.descriptionList = descriptionList;
	}

}
