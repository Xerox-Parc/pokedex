package com.xeroxparc.pokedex.data.model.move.ailment;

import androidx.room.Entity;

import com.google.gson.annotations.SerializedName;
import com.xeroxparc.pokedex.data.model.move.Move;
import com.xeroxparc.pokedex.data.model.utility.common.Name;
import com.xeroxparc.pokedex.data.model.utility.common.NamedApiResource;

import java.util.List;

/**
 * Move Ailments are status conditions caused by moves used during battle.
 * See Bulbapedia for greater detail.
 *
 * @author Fabio Buracchi
 */
@Entity(tableName = "move_ailment")
public class MoveAilment extends NamedApiResource {

	// A list of moves that cause this ailment.
	@SerializedName("moves")
	private List<Move> moveList;

	// The name of this resource listed in different languages.
	@SerializedName("names")
	private List<Name> nameList;

	public List<Move> getMoveList() {
		return moveList;
	}

	public void setMoveList(List<Move> moveList) {
		this.moveList = moveList;
	}

	public List<Name> getNameList() {
		return nameList;
	}

	public void setNameList(List<Name> nameList) {
		this.nameList = nameList;
	}

}
