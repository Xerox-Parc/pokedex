package com.xeroxparc.pokedex.data.entity.move;

import com.xeroxparc.pokedex.data.entity.utility.Description;
import com.xeroxparc.pokedex.data.entity.utility.Name;
import com.xeroxparc.pokedex.data.entity.utility.NamedAPIResource;

import java.util.List;

public class MoveTarget {

	//Targets moves can be directed at during battle. Targets can be Pokémon, environments or even other moves.

	private Integer id;                         //The identifier for this resource.
	private String name;                        //The name for this resource.
	private List<Description> descriptions;     //The description of this resource listed in different languages.
	private List<NamedAPIResource> moves;       //A list of moves that that are directed at this target. (Move)
	private List<Name> names;                   //The name of this resource listed in different languages.

}
