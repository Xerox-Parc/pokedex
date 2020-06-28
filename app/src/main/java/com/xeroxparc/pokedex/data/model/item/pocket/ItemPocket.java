package com.xeroxparc.pokedex.data.model.item.pocket;

import com.google.gson.annotations.SerializedName;
import com.xeroxparc.pokedex.data.model.item.category.ItemCategory;
import com.xeroxparc.pokedex.data.model.utility.common.Name;
import com.xeroxparc.pokedex.data.model.utility.common.NamedApiResource;

import java.util.List;

/**
 * Pockets within the players bag used for storing items by category.
 *
 * @author Fabio Buracchi
 */
public class ItemPocket extends NamedApiResource {

	// A list of item categories that are relevant to this item pocket.
	@SerializedName("categories")
	private List<ItemCategory> categoryList;

	// The name of this resource listed in different languages.
	@SerializedName("names")
	private List<Name> nameList;

}
