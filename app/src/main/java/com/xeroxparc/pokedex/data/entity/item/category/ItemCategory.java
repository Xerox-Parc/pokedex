package com.xeroxparc.pokedex.data.entity.item.category;

import com.xeroxparc.pokedex.data.entity.utility.common.Name;
import com.xeroxparc.pokedex.data.entity.utility.common.NamedAPIResource;

import java.util.List;

public class ItemCategory {

	//Item categories determine where items will be placed in the players bag.

	private Integer id;                         //The identifier for this resource.
	private String name;                        //The name for this resource.
	private List<NamedAPIResource> items;       //A list of items that are a part of this category (Item)
	private List<Name> names;                   //The name of this item category listed in different languages.
	private NamedAPIResource pocket;            //The pocket items in this category would be put in. (ItemPocket)

}
