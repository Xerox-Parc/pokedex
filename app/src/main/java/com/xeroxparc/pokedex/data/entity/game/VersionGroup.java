package com.xeroxparc.pokedex.data.entity.game;

import com.xeroxparc.pokedex.data.entity.utility.NamedAPIResource;

import java.util.List;

public class VersionGroup {

	//Version groups categorize highly similar versions of the games.

	private Integer id;                                 //The identifier for this resource.
	private String name;                                //The name for this resource.
	private Integer order;                              //Order for sorting. Almost by date of release, except similar versions are grouped together.
	private NamedAPIResource generation;                //The generation this version was introduced in. (Generation)
	private List<NamedAPIResource> move_learn_methods;  //A list of methods in which Pokémon can learn moves in this version group. (MoveLearnMethod)
	private List<NamedAPIResource> pokedexes;           //A list of Pokédexes introduces in this version group. (Pokedex)
	private List<NamedAPIResource> regions;             //A list of regions that can be visited in this version group. (Region)
	private List<NamedAPIResource> versions;            //The versions this version group owns. (Version)

}
