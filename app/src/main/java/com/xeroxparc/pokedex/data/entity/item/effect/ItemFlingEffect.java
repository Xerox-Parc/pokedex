package com.xeroxparc.pokedex.data.entity.item.effect;

import com.google.gson.annotations.SerializedName;
import com.xeroxparc.pokedex.data.entity.utility.common.Effect;
import com.xeroxparc.pokedex.data.entity.utility.common.NamedAPIResource;

import java.util.List;

public class ItemFlingEffect {

	/*
		The various effects of the move "Fling" when used with different items.
	 */

	@SerializedName("id")
	private Integer id;                                 // The identifier for this resource.

	@SerializedName("name")
	private String name;                                // The name for this resource.

	@SerializedName("effect_entries")
	private List<Effect> effectEntryList;               // The result of this fling effect listed in
														// different languages.

	@SerializedName("items")
	private List<NamedAPIResource> itemListResource;    // A list of items that have this fling
														// effect. (Item)

}
