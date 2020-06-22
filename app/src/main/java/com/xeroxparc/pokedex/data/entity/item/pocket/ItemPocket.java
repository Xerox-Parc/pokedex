package com.xeroxparc.pokedex.data.entity.item.pocket;

import com.google.gson.annotations.SerializedName;
import com.xeroxparc.pokedex.data.entity.utility.common.Name;
import com.xeroxparc.pokedex.data.entity.utility.common.NamedAPIResource;

import java.util.List;

public class ItemPocket {

	/*
		Pockets within the players bag used for storing items by category.
	 */

	@SerializedName("id")
	private Integer id;                                     // The identifier for this resource.

	@SerializedName("name")
	private String name;                                    // The name for this resource.

	@SerializedName("categories")
	private List<NamedAPIResource> categoryListResource;    // A list of item categories that are
															// relevant to this item pocket.
															// (ItemCategory)

	@SerializedName("names")
	private List<Name> names;                               // The name of this resource listed in
															// different languages.

}
