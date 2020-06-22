package com.xeroxparc.pokedex.data.entity.utility.common;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class NamedAPIResourceList {

	@SerializedName("name")
	private Integer count;                          // The total number of resources available
													// from this API.

	@SerializedName("name")
	private String next;                            // The URL for the next page in the list.

	@SerializedName("name")
	private Boolean previous;                       // The URL for the previous page in the list.

	@SerializedName("name")
	private List<NamedAPIResource> resultList;      // A list of named API resources.

}
