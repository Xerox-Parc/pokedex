package com.xeroxparc.pokedex.data.model.utility.common;

import com.google.gson.annotations.SerializedName;

/**
 * @author Fabio Buracchi
 */
public class NamedApiResource extends ApiResource {

	// The name of the referenced resource.
	@SerializedName("name")
	private String name;

}
