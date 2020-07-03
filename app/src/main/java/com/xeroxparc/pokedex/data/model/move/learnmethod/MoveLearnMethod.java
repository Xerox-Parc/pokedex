package com.xeroxparc.pokedex.data.model.move.learnmethod;

import androidx.room.ColumnInfo;
import androidx.room.Entity;

import com.google.gson.annotations.SerializedName;
import com.xeroxparc.pokedex.data.model.game.versiongroup.VersionGroup;
import com.xeroxparc.pokedex.data.model.utility.common.Description;
import com.xeroxparc.pokedex.data.model.utility.common.Name;
import com.xeroxparc.pokedex.data.model.utility.common.NamedApiResource;

import java.util.List;

/**
 * Methods by which Pokémon can learn moves.
 *
 * @author Fabio Buracchi
 */
@Entity(tableName = "move_learn_method")
public class MoveLearnMethod extends NamedApiResource {

	// The description of this resource listed in different languages.
	@ColumnInfo(name = "descriptions_data")
	@SerializedName("descriptions")
	private List<Description> descriptionList;

	// The name of this resource listed in different languages.
	@ColumnInfo(name = "names_data")
	@SerializedName("names")
	private List<Name> nameList;

	// A list of moves that fall into this damage class.
	@ColumnInfo(name = "version_groups_data")
	@SerializedName("version_groups")
	private List<VersionGroup> versionGroupList;

	public List<Description> getDescriptionList() {
		return descriptionList;
	}

	public void setDescriptionList(List<Description> descriptionList) {
		this.descriptionList = descriptionList;
	}

	public List<Name> getNameList() {
		return nameList;
	}

	public void setNameList(List<Name> nameList) {
		this.nameList = nameList;
	}

	public List<VersionGroup> getVersionGroupList() {
		return versionGroupList;
	}

	public void setVersionGroupList(List<VersionGroup> versionGroupList) {
		this.versionGroupList = versionGroupList;
	}

}
