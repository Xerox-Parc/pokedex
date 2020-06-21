package com.xeroxparc.pokedex.data.entity.utility;

import java.util.List;

public class APIResourceList {

	private Integer count;              //The total number of resources available from this API.
	private String next;                //The URL for the next page in the list.
	private Boolean previous;           //The URL for the previous page in the list.
	private List<APIResource> results;  //A list of un-named API resources.

}
