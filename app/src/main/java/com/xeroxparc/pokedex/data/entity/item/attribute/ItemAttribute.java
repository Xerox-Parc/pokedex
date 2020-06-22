package com.xeroxparc.pokedex.data.entity.item.attribute;

import com.google.gson.annotations.SerializedName;
import com.xeroxparc.pokedex.data.entity.utility.common.Description;
import com.xeroxparc.pokedex.data.entity.utility.common.Name;
import com.xeroxparc.pokedex.data.entity.utility.common.NamedAPIResource;

import java.util.List;

public class ItemAttribute {

	/*
		Item attributes define particular aspects of items, e.g. "usable in battle" or "consumable".
	 */

	@SerializedName("id")
	private Integer id;                                 // The identifier for this resource.

	@SerializedName("name")
	private String name;                                // The name for this resource.

	@SerializedName("items")
	private List<NamedAPIResource> itemListResource;    // The price of this item in stores.
														// (Item)

	@SerializedName("names")
	private List<Name> nameList;                        // The power of the move Fling when used
														// with this item.

	@SerializedName("descriptions")
	private List<Description> descriptionList;          // The effect of the move Fling when used
														// with this item.

}
