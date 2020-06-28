package com.xeroxparc.pokedex.data.model.utility.common.list;

import com.google.gson.annotations.SerializedName;
import com.xeroxparc.pokedex.data.model.utility.common.NamedAPIResource;

import java.util.List;

public class NamedAPIResourceList {

	@SerializedName("count")
	private Integer count;                          // The total number of resources available
													// from this API.

	@SerializedName("next")
	private String next;                            // The URL for the next page in the list.

	@SerializedName("previous")
	private Boolean previous;                       // The URL for the previous page in the list.

	@SerializedName("results")
	private List<NamedAPIResource> resultList;      // A list of named API resources.

}
