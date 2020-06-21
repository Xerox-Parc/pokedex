package com.xeroxparc.pokedex.data.entity.berry.firmness;

import com.xeroxparc.pokedex.data.entity.utility.common.Name;
import com.xeroxparc.pokedex.data.entity.utility.common.NamedAPIResource;

import java.util.List;

public class BerryFirmness {

	//Berries can be soft or hard. Check out Bulbapedia for greater detail.

	private Integer id;                         //The identifier for this resource.
	private String name;                        //The name for this resource.
	private List<NamedAPIResource> berries;     //A list of the berries with this firmness. (List<Berry>)
	private List<Name> names;                   //The name of this resource listed in different languages.

}
