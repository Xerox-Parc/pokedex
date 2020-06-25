package com.xeroxparc.pokedex.data.entity.move.categoty;

import com.google.gson.annotations.SerializedName;
import com.xeroxparc.pokedex.data.entity.utility.common.Description;
import com.xeroxparc.pokedex.data.entity.utility.common.NamedAPIResource;

import java.util.List;

public class ModelName {

	/*
		Very general categories that loosely group move effects.
	 */

	@SerializedName("id")
	private Integer id;                                 // The identifier for this resource.

	@SerializedName("name")
	private String name;                                // The name for this resource.

	@SerializedName("moves")
	private List<NamedAPIResource> moveListResource;    // A list of moves that fall into this
														// category.
														// (Move)

	@SerializedName("descriptions")
	private List<Description> descriptionList;          // The description of this resource listed
														// in different languages.

}
