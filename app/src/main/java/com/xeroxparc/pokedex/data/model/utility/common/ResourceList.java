package com.xeroxparc.pokedex.data.model.utility.common;

import androidx.annotation.Nullable;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * @author Fabio Buracchi
 */
public class ResourceList<T> {

	// The total number of resources available from this API.
	@SerializedName("count")
	private Integer count;

	// The next page number in the list.
	@Nullable
	@SerializedName("next")
	private Integer nextPageNumber;

	// The previous page number in the list
	@Nullable
	@SerializedName("previous")
	private Integer previousPageNumber;

	// A list of resources.
	@SerializedName("results")
	private List<T> results;

	public Integer getCount() {
		return count;
	}

	@Nullable
	public Integer getNextPageNumber() {
		return nextPageNumber;
	}

	@Nullable
	public Integer getPreviousPageNumber() {
		return previousPageNumber;
	}

	public List<T> getResults() {
		return results;
	}

}
