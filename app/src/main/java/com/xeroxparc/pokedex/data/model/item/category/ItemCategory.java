package com.xeroxparc.pokedex.data.model.item.category;

import androidx.room.Entity;

import com.google.gson.annotations.SerializedName;
import com.xeroxparc.pokedex.data.model.item.Item;
import com.xeroxparc.pokedex.data.model.item.pocket.ItemPocket;
import com.xeroxparc.pokedex.data.model.utility.common.Name;
import com.xeroxparc.pokedex.data.model.utility.common.NamedApiResource;

import java.util.List;

/**
 * Item categories determine where items will be placed in the players bag.
 *
 * @author Fabio Buracchi
 */
@Entity(tableName = "item_category")
public class ItemCategory extends NamedApiResource {

	// A list of items that are a part of this category
	@SerializedName("items")
	private List<Item> itemList;

	// The name of this item category listed in different languages.
	@SerializedName("names")
	private List<Name> nameList;

	// The pocket items in this category would be put in.
	@SerializedName("pocket")
	private ItemPocket pocket;

	public List<Item> getItemList() {
		return itemList;
	}

	public void setItemList(List<Item> itemList) {
		this.itemList = itemList;
	}

	public List<Name> getNameList() {
		return nameList;
	}

	public void setNameList(List<Name> nameList) {
		this.nameList = nameList;
	}

	public ItemPocket getPocket() {
		return pocket;
	}

	public void setPocket(ItemPocket pocket) {
		this.pocket = pocket;
	}

}
