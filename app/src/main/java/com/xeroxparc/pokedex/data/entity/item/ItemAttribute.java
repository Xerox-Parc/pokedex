package com.xeroxparc.pokedex.data.entity.item;

import com.xeroxparc.pokedex.data.entity.utility.Description;
import com.xeroxparc.pokedex.data.entity.utility.Name;
import com.xeroxparc.pokedex.data.entity.utility.NamedAPIResource;

import java.util.List;

public class ItemAttribute {

	//Item attributes define particular aspects of items, e.g. "usable in battle" or "consumable".

	private Integer id;                         //The identifier for this resource.
	private String name;                        //The name for this resource.
	private List<NamedAPIResource> items;       //The price of this item in stores. (Item)
	private List<Name> names;                   //The power of the move Fling when used with this item.
	private List<Description> descriptions;     //The effect of the move Fling when used with this item.

}
