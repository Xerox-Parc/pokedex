package com.xeroxparc.pokedex.data.entity.utility.common;

import com.google.gson.annotations.SerializedName;

public class NamedAPIResource {

	@SerializedName("name")
	private String name;        // The name of the referenced resource.

	@SerializedName("url")
	private String url;         // The URL of the referenced resource.

}
