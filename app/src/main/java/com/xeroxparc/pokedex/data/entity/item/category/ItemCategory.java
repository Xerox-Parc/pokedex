package com.xeroxparc.pokedex.data.entity.item.category;

import com.google.gson.annotations.SerializedName;
import com.xeroxparc.pokedex.data.entity.utility.common.Name;
import com.xeroxparc.pokedex.data.entity.utility.common.NamedAPIResource;

import java.util.List;

public class ItemCategory {

	/*
		Item categories determine where items will be placed in the players bag.
	 */

	@SerializedName("id")
	private Integer id;                                 // The identifier for this resource.

	@SerializedName("name")
	private String name;                                // The name for this resource.

	@SerializedName("items")
	private List<NamedAPIResource> itemListResource;    // A list of items that are a part of this
														// category
														// (Item)

	@SerializedName("names")
	private List<Name> nameList;                        // The name of this item category listed in
														// different languages.

	@SerializedName("pocket")
	private NamedAPIResource pocketResource;            // The pocket items in this category would be
														// put in.
														// (ItemPocket)

}
