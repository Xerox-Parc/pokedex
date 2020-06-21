package com.xeroxparc.pokedex.data.entity.utility.common;

import java.util.List;

public class NamedAPIResourceList {

	private Integer count;                  //The total number of resources available from this API.
	private String next;                    //The URL for the next page in the list.
	private Boolean previous;               //The URL for the previous page in the list.
	private List<NamedAPIResource> results; //A list of named API resources.

}
