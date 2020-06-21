package com.xeroxparc.pokedex.data.entity.move;

import com.xeroxparc.pokedex.data.entity.utility.Name;

import java.util.List;

import javax.xml.namespace.NamespaceContext;

public class MoveAilment {

	//Move Ailments are status conditions caused by moves used during battle. See Bulbapedia for greater detail.

	private Integer id;                     //The identifier for this resource.
	private String name;                    //The name for this resource.
	private List<NamespaceContext> moves;   //A list of moves that cause this ailment.
	private List<Name> names;               //The name of this resource listed in different languages.

}
