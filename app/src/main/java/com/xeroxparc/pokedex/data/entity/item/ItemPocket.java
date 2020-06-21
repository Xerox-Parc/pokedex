package com.xeroxparc.pokedex.data.entity.item;

import com.xeroxparc.pokedex.data.entity.utility.Name;
import com.xeroxparc.pokedex.data.entity.utility.NamedAPIResource;

import java.util.List;

public class ItemPocket {

	//Pockets within the players bag used for storing items by category.

	private Integer id;                             //The identifier for this resource.
	private String name;                            //The name for this resource.
	private List<NamedAPIResource> effect_entries;  //A list of item categories that are relevant to this item pocket. (ItemCategory)
	private List<Name> items;                       //The name of this resource listed in different languages.

}
