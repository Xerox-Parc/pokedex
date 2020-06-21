package com.xeroxparc.pokedex.data.entity.location;

import com.xeroxparc.pokedex.data.entity.utility.Name;
import com.xeroxparc.pokedex.data.entity.utility.NamedAPIResource;

import java.util.List;

public class Region {

	//A region is an organized area of the Pokémon world. Most often, the main difference between regions is the species of Pokémon that can be encountered within them.

	private Integer id;                                         //The identifier for this resource.
	private String name;                                        //The name for this resource.
	private List<NamedAPIResource> locations;                   //A list of locations that can be found in this region. (Location)
	private List<Name> names;                                   //The name of this resource listed in different languages.
	private NamedAPIResource main_generation;                   //The generation this region was introduced in. (Generation)
	private List<NamedAPIResource> pokedexes;                   //A list of pokédexes that catalogue Pokémon in this region. (Pokedex)
	private List<NamedAPIResource> version_groups;              //A list of version groups where this region can be visited. (VersionGroup)

}
