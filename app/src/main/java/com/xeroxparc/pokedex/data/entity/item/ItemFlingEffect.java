package com.xeroxparc.pokedex.data.entity.item;

import com.xeroxparc.pokedex.data.entity.utility.Effect;
import com.xeroxparc.pokedex.data.entity.utility.NamedAPIResource;

import java.util.List;

public class ItemFlingEffect {

	//The various effects of the move "Fling" when used with different items.

	private Integer id;                         //The identifier for this resource.
	private String name;                        //The name for this resource.
	private List<Effect> effect_entries;        //The result of this fling effect listed in different languages.
	private List<NamedAPIResource> items;       //A list of items that have this fling effect. (Item)

}
