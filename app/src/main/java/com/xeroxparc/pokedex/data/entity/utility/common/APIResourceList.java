package com.xeroxparc.pokedex.data.entity.utility.common;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class APIResourceList {

	@SerializedName("count")
	private Integer count;                      // The total number of resources available from
												// this API.

	@SerializedName("next")
	private String next;                        // The URL for the next page in the list.

	@SerializedName("previous")
	private Boolean previous;                   // The URL for the previous page in the list.

	@SerializedName("results")
	private List<APIResource> resultList;       // A list of un-named API resources.

}
