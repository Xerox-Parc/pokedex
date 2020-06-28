package com.xeroxparc.pokedex.data.model.item.attribute;

import com.google.gson.annotations.SerializedName;
import com.xeroxparc.pokedex.data.model.item.Item;
import com.xeroxparc.pokedex.data.model.utility.common.Description;
import com.xeroxparc.pokedex.data.model.utility.common.Name;
import com.xeroxparc.pokedex.data.model.utility.common.NamedAPIResource;

import java.util.List;

/**
 * Item attributes define particular aspects of items, e.g. "usable in battle" or "consumable".
 *
 * @author Fabio Buracchi
 */
public class ItemAttribute extends NamedAPIResource {

	// A list of items that have this attribute.
	@SerializedName("items")
	private List<Item> itemList;

	// The name of this item attribute listed in different languages.
	@SerializedName("names")
	private List<Name> nameList;

	// The description of this item attribute listed in different languages.
	@SerializedName("descriptions")
	private List<Description> descriptionList;

}
