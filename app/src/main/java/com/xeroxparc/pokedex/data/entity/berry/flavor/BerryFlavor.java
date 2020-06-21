package com.xeroxparc.pokedex.data.entity.berry.flavor;

import com.xeroxparc.pokedex.data.entity.utility.common.Name;
import com.xeroxparc.pokedex.data.entity.utility.common.NamedAPIResource;

import java.util.List;

public class BerryFlavor {

	//Flavors determine whether a Pokémon will benefit or suffer from eating a berry based on their nature. Check out Bulbapedia for greater detail.

	private Integer id;                             //The identifier for this resource.
	private String name;                            //The name for this resource.
	private List<FlavorBerryMap> berries;	        //A list of the berries with this flavor.
	private NamedAPIResource contest_type;	        //The contest type that correlates with this berry flavor. (ContestType)
	private List<Name> names;                       //The name of this resource listed in different languages.

}
