package com.xeroxparc.pokedex.data.entity.move;

import com.xeroxparc.pokedex.data.entity.utility.Description;
import com.xeroxparc.pokedex.data.entity.utility.NamedAPIResource;

import java.util.List;

public class ModelName {

	//Very general categories that loosely group move effects.

	private Integer id;                         //The identifier for this resource.
	private String name;                        //The name for this resource.
	private List<NamedAPIResource> moves;       //A list of moves that fall into this category.
	private List<Description> descriptions;     //The description of this resource listed in different languages.

}
