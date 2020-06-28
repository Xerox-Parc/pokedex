package com.xeroxparc.pokedex.data.model.utility.common.list;

import com.google.gson.annotations.SerializedName;
import com.xeroxparc.pokedex.data.model.utility.common.APIResource;

import java.util.List;

/**
 * @author Fabio Buracchi
 */
public class APIResourceList {

	// The total number of resources available from this API.
	@SerializedName("count")
	private Integer count;

	// The URL for the next page in the list.
	@SerializedName("next")
	private String next;

	// The URL for the previous page in the list.
	@SerializedName("previous")
	private Boolean previous;

	// A list of un-named API resources.
	@SerializedName("results")
	private List<APIResource> resultList;

}
