package com.xeroxparc.pokedex.data.entity.contest;

import com.xeroxparc.pokedex.data.entity.utility.NamedAPIResource;

import java.util.List;

public class ContestType {

	//Contest types are categories judges used to weigh a Pokémon's condition in Pokémon contests. Check out Bulbapedia for greater detail.

	private Integer id;                     //The identifier for this resource.
	private String name;                    //The name for this resource.
	private NamedAPIResource berry_flavor;  //The berry flavor that correlates with this contest type. (BerryFlavor)
	private List<ContestName> names;        //The name of this contest type listed in different languages.

}
