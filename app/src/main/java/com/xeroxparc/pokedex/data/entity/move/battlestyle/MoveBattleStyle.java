package com.xeroxparc.pokedex.data.entity.move.battlestyle;

import com.google.gson.annotations.SerializedName;
import com.xeroxparc.pokedex.data.entity.utility.common.Name;

import java.util.List;

public class MoveBattleStyle {

	/*
		Styles of moves when used in the Battle Palace. See Bulbapedia for greater detail.
	 */

	@SerializedName("id")
	private Integer id;                 // The identifier for this resource.

	@SerializedName("name")
	private String name;                // The name for this resource.

	@SerializedName("names")
	private List<Name> nameList;        // The name of this resource listed in different languages.

}
