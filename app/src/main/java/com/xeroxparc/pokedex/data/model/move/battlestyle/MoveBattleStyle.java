package com.xeroxparc.pokedex.data.model.move.battlestyle;

import androidx.room.Entity;

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
@Entity(tableName = "move_battle_style")
public class MoveBattleStyle extends NamedApiResource {

	// The name of this resource listed in different languages.
	@SerializedName("names")
	private List<Name> nameList;

	public List<Name> getNameList() {
		return nameList;
	}

	public void setNameList(List<Name> nameList) {
		this.nameList = nameList;
	}

}
