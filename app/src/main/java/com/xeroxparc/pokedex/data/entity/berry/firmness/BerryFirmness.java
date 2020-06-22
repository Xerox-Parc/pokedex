package com.xeroxparc.pokedex.data.entity.berry.firmness;

import com.google.gson.annotations.SerializedName;
import com.xeroxparc.pokedex.data.entity.utility.common.Name;
import com.xeroxparc.pokedex.data.entity.utility.common.NamedAPIResource;

import java.util.List;

public class BerryFirmness {

	/*
		Berries can be soft or hard. Check out Bulbapedia for greater detail.
	 */

	@SerializedName("id")
	private Integer id;                                 //The identifier for this resource.

	@SerializedName("name")
	private String name;                                //The name for this resource.

	@SerializedName("berries")
	private List<NamedAPIResource> berryListResource;   // A list of the berries with this firmness.
														// (Berry)

	@SerializedName("names")
	private List<Name> nameList;                        //The name of this resource listed in
														// different languages.

}
