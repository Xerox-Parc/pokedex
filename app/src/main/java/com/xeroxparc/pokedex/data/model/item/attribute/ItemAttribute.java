package com.xeroxparc.pokedex.data.model.item.attribute;

import androidx.room.Entity;

import com.google.gson.annotations.SerializedName;
import com.xeroxparc.pokedex.data.model.item.Item;
import com.xeroxparc.pokedex.data.model.utility.common.Description;
import com.xeroxparc.pokedex.data.model.utility.common.Name;
import com.xeroxparc.pokedex.data.model.utility.common.NamedApiResource;

import java.util.List;

/**
 * Item attributes define particular aspects of items, e.g. "usable in battle" or "consumable".
 *
 * @author Fabio Buracchi
 */
@Entity(tableName = "item_attribute")
public class ItemAttribute extends NamedApiResource {

	// A list of items that have this attribute.
	@SerializedName("items")
	private List<Item> itemList;

	// The name of this item attribute listed in different languages.
	@SerializedName("names")
	private List<Name> nameList;

	// The description of this item attribute listed in different languages.
	@SerializedName("descriptions")
	private List<Description> descriptionList;

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

	public List<Description> getDescriptionList() {
		return descriptionList;
	}

	public void setDescriptionList(List<Description> descriptionList) {
		this.descriptionList = descriptionList;
	}

}
