package com.xeroxparc.pokedex.data.model.move.target;

import androidx.room.ColumnInfo;
import androidx.room.Entity;

import com.google.gson.annotations.SerializedName;
import com.xeroxparc.pokedex.data.model.move.Move;
import com.xeroxparc.pokedex.data.model.utility.common.Description;
import com.xeroxparc.pokedex.data.model.utility.common.Name;
import com.xeroxparc.pokedex.data.model.utility.common.NamedApiResource;

import java.util.List;

/**
 * Targets moves can be directed at during battle. Targets can be Pokémon, environments
 * or even other moves.
 *
 * @author Fabio Buracchi
 */
@Entity(tableName = "move_target")
public class MoveTarget extends NamedApiResource {

	// The description of this resource listed in different languages.
	@ColumnInfo(name = "descriptions_data")
	@SerializedName("descriptions")
	private List<Description> descriptionList;

	// A list of moves that that are directed at this target.
	@ColumnInfo(name = "moves_data")
	@SerializedName("moves")
	private List<Move> moveList;

	// The name of this resource listed in different languages.
	@ColumnInfo(name = "names_data")
	@SerializedName("names")
	private List<Name> nameList;

	public List<Description> getDescriptionList() {
		return descriptionList;
	}

	public void setDescriptionList(List<Description> descriptionList) {
		this.descriptionList = descriptionList;
	}

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
