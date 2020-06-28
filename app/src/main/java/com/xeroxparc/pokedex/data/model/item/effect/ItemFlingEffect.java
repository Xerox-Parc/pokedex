package com.xeroxparc.pokedex.data.model.item.effect;

import com.google.gson.annotations.SerializedName;
import com.xeroxparc.pokedex.data.model.item.Item;
import com.xeroxparc.pokedex.data.model.utility.common.Effect;
import com.xeroxparc.pokedex.data.model.utility.common.NamedAPIResource;

import java.util.List;

/**
 * The various effects of the move "Fling" when used with different items.
 *
 * @author Fabio Buracchi
 */
public class ItemFlingEffect extends NamedAPIResource {

	// The result of this fling effect listed in different languages.
	@SerializedName("effect_entries")
	private List<Effect> effectEntryList;

	// A list of items that have this fling effect.
	@SerializedName("items")
	private List<Item> itemList;

}
