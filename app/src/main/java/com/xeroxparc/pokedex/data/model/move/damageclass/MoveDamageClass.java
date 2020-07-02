package com.xeroxparc.pokedex.data.model.move.damageclass;

import androidx.room.Entity;

import com.google.gson.annotations.SerializedName;
import com.xeroxparc.pokedex.data.model.move.Move;
import com.xeroxparc.pokedex.data.model.utility.common.Description;
import com.xeroxparc.pokedex.data.model.utility.common.Name;
import com.xeroxparc.pokedex.data.model.utility.common.NamedApiResource;

import java.util.List;

/**
 * Damage classes moves can have, e.g. physical, special, or non-damaging.
 *
 * @author Fabio Buracchi
 */
@Entity(tableName = "move_damage_class")
public class MoveDamageClass extends NamedApiResource {

	// The description of this resource listed in different languages.
	@SerializedName("descriptions")
	private List<Description> descriptionList;

	// A list of moves that fall into this damage class.
	@SerializedName("moves")
	private List<Move> moveList;

	// The name of this resource listed in different languages.
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
