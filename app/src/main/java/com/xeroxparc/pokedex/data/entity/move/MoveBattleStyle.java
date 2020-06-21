package com.xeroxparc.pokedex.data.entity.move;

import com.xeroxparc.pokedex.data.entity.utility.Name;

import java.util.List;

import javax.xml.namespace.NamespaceContext;

public class MoveBattleStyle {

	//Styles of moves when used in the Battle Palace. See Bulbapedia for greater detail.

	private Integer id;                     //The identifier for this resource.
	private String name;                    //The name for this resource.
	private List<Name> names;               //The name of this resource listed in different languages.

}
