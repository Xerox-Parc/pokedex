package com.xeroxparc.pokedex.data.entity.pokemon;

import com.xeroxparc.pokedex.data.entity.utility.NamedAPIResource;

import java.util.List;

public class MoveStatAffect {

	private Integer change;                 //The maximum amount of change to the referenced stat.
	private List<NamedAPIResource> move;    //The move causing the change.

}
