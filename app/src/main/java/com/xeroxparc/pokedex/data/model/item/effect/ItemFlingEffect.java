package com.xeroxparc.pokedex.data.model.item.effect;

import androidx.room.ColumnInfo;
import androidx.room.Entity;

import com.google.gson.annotations.SerializedName;
import com.xeroxparc.pokedex.data.model.item.Item;
import com.xeroxparc.pokedex.data.model.utility.common.Effect;
import com.xeroxparc.pokedex.data.model.utility.common.NamedApiResource;

import java.util.List;

/**
 * The various effects of the move "Fling" when used with different items.
 *
 * @author Fabio Buracchi
 */
@Entity(tableName = "item_fling_effect")
public class ItemFlingEffect extends NamedApiResource {

	// The result of this fling effect listed in different languages.
	@ColumnInfo(name = "effect_entries_data")
	@SerializedName("effect_entries")
	private List<Effect> effectEntryList;

	// A list of items that have this fling effect.
	@ColumnInfo(name = "items_data")
	@SerializedName("items")
	private List<Item> itemList;

	public List<Effect> getEffectEntryList() {
		return effectEntryList;
	}

	public void setEffectEntryList(List<Effect> effectEntryList) {
		this.effectEntryList = effectEntryList;
	}

	public List<Item> getItemList() {
		return itemList;
	}

	public void setItemList(List<Item> itemList) {
		this.itemList = itemList;
	}

}
