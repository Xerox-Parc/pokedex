package com.xeroxparc.pokedex.data.entity.berry;

import com.xeroxparc.pokedex.data.entity.utility.NamedAPIResource;

import java.util.List;

public class Berry {

	//Berries are small fruits that can provide HP and status condition restoration, stat enhancement, and even damage negation when eaten by Pokémon. Check out Bulbapedia for greater detail.

	private Integer id;                             //The identifier for this resource.
	private String name;                            //The name for this resource.
	private Integer growth_time;	                //Time it takes the tree to grow one stage, in hours. Berry trees go through four of these growth stages before they can be picked.
	private Integer max_harvest;	                //The maximum number of these berries that can grow on one tree in Generation IV.
	private Integer natural_gift_power;             //The power of the move "Natural Gift" when used with this Berry.
	private Integer size;                           //The size of this Berry, in millimeters.
	private Integer smoothness;	                    //The smoothness of this Berry, used in making Pokéblocks or Poffins.
	private Integer soil_dryness;                   //The speed at which this Berry dries out the soil as it grows. A higher rate means the soil dries more quickly.
	private NamedAPIResource firmness;              //The firmness of this berry, used in making Pokéblocks or Poffins. (BerryFirmness)
	private List<BerryFlavorMap> flavors;           //A list of references to each flavor a berry can have and the potency of each of those flavors in regard to this berry.
	private NamedAPIResource item;                  //Berries are actually items. This is a reference to the item specific data for this berry. (Item)
	private NamedAPIResource natural_gift_type;     //The type inherited by "Natural Gift" when used with this Berry. (Type)

}
