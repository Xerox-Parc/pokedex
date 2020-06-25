package com.xeroxparc.pokedex.data.entity.berry;

import com.google.gson.annotations.SerializedName;
import com.xeroxparc.pokedex.data.entity.utility.common.NamedAPIResource;

import java.util.List;

public class Berry {

	/*
		Berries are small fruits that can provide HP and status condition restoration, stat
		enhancement, and even damage negation when eaten by Pokémon.
		Check out Bulbapedia for greater detail.
	*/

	@SerializedName("id")
	private Integer id;                                 // The identifier for this resource.
	
	@SerializedName("name")
	private String name;                                // The name for this resource.

	@SerializedName("growth_time")
	private Integer growthTime;	                        // Time it takes the tree to grow one stage,
														// in hours. Berry trees go through four of
														// these growth stages before they can be
														// picked.

	@SerializedName("max_harvest")
	private Integer maxHarvest;	                        // The maximum number of these berries that
														// can grow on one tree in Generation IV.

	@SerializedName("natural_gift_power")
	private Integer naturalGiftPower;                   // The power of the move "Natural Gift" when
														// used with this Berry.

	@SerializedName("size")
	private Integer size;                               // The size of this Berry, in millimeters.

	@SerializedName("smoothness")
	private Integer smoothness;	                        // The smoothness of this Berry, used in
														// making Pokéblocks or Poffins.

	@SerializedName("soil_dryness")
	private Integer soilDryness;                        // The speed at which this Berry dries out
														// the soil as it grows. A higher rate means
														// the soil dries more quickly.

	@SerializedName("firmness")
	private NamedAPIResource firmnessResource;          // The firmness of this berry, used in
														// making Pokéblocks or Poffins.
														// (BerryFirmness)

	@SerializedName("flavors")
	private List<BerryFlavorMap> flavorMapList;         // A list of references to each flavor a
														// berry can have and the potency of each of
														// those flavors in regard to this berry.

	@SerializedName("item")
	private NamedAPIResource itemResource;              // Berries are actually items. This is a
														// reference to the item specific data for
														// this berry.
														// (Item)

	@SerializedName("natural_gift_type")
	private NamedAPIResource naturalGiftTypeResource;   // The type inherited by "Natural Gift" when
														// used with this Berry.
														// (Type)

}
