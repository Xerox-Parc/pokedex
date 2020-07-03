package com.xeroxparc.pokedex.data.model.game.version;

import androidx.room.ColumnInfo;
import androidx.room.Entity;

import com.google.gson.annotations.SerializedName;
import com.xeroxparc.pokedex.data.model.game.versiongroup.VersionGroup;
import com.xeroxparc.pokedex.data.model.utility.common.Name;
import com.xeroxparc.pokedex.data.model.utility.common.NamedApiResource;

import java.util.List;

/**
 * Versions of the games, e.g., Red, Blue or Yellow.
 *
 * @author Fabio Buracchi
 */
@Entity(tableName = "version")
public class Version extends NamedApiResource {

	// The name of this resource listed in different languages.
	@ColumnInfo(name = "names_data")
	@SerializedName("names")
	private List<Name> nameList;

	// The version group this version belongs to.
	@ColumnInfo(name = "version_group_data")
	@SerializedName("version_group")
	private VersionGroup versionGroup;

	public List<Name> getNameList() {
		return nameList;
	}

	public void setNameList(List<Name> nameList) {
		this.nameList = nameList;
	}

	public VersionGroup getVersionGroup() {
		return versionGroup;
	}

	public void setVersionGroup(VersionGroup versionGroup) {
		this.versionGroup = versionGroup;
	}

}
