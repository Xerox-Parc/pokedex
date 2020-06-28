package com.xeroxparc.pokedex.data.model.utility.common;

import com.google.gson.annotations.SerializedName;

/**
 * @author Fabio Buracchi
 */
public class NamedAPIResource extends APIResource{

	// The name of the referenced resource.
	@SerializedName("name")
	private String name;

}
