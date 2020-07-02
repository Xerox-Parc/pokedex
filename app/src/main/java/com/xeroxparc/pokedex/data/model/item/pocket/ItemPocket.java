package com.xeroxparc.pokedex.data.model.item.pocket;

import androidx.room.Entity;

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
@Entity(tableName = "item_pocket")
public class ItemPocket extends NamedApiResource {

	// A list of item categories that are relevant to this item pocket.
	@SerializedName("categories")
	private List<ItemCategory> categoryList;

	// The name of this resource listed in different languages.
	@SerializedName("names")
	private List<Name> nameList;

	public List<ItemCategory> getCategoryList() {
		return categoryList;
	}

	public void setCategoryList(List<ItemCategory> categoryList) {
		this.categoryList = categoryList;
	}

	public List<Name> getNameList() {
		return nameList;
	}

	public void setNameList(List<Name> nameList) {
		this.nameList = nameList;
	}

}
