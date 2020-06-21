package com.xeroxparc.pokedex.data.entity.move;

import com.xeroxparc.pokedex.data.entity.utility.Description;
import com.xeroxparc.pokedex.data.entity.utility.Name;
import com.xeroxparc.pokedex.data.entity.utility.NamedAPIResource;

import java.util.List;

public class MoveDamageClass {

	//Damage classes moves can have, e.g. physical, special, or non-damaging.

	private Integer id;                         //The identifier for this resource.
	private String name;                        //The name for this resource.
	private List<Description> descriptions;     //The description of this resource listed in different languages.
	private List<NamedAPIResource> moves;       //A list of moves that fall into this damage class. (Move)
	private List<Name> names;                   //The name of this resource listed in different languages.

}
