package com.xeroxparc.pokedex.data.entity.location;

import com.xeroxparc.pokedex.data.entity.utility.GenerationGameIndex;
import com.xeroxparc.pokedex.data.entity.utility.Name;
import com.xeroxparc.pokedex.data.entity.utility.NamedAPIResource;

import java.util.List;

public class Location {

	//Locations that can be visited within the games. Locations make up sizable portions of regions, like cities or routes.

	private Integer id;                                 //The identifier for this resource.
	private String name;                                //The name for this resource.
	private NamedAPIResource region;                    //The region this location can be found in. (Region)
	private List<Name> names;                           //The name of this resource listed in different languages.
	private List<GenerationGameIndex> game_indices;     //A list of game indices relevent to this location by generation.
	private List<NamedAPIResource> areas;               //Areas that can be found within this location. (LocationArea)

}
