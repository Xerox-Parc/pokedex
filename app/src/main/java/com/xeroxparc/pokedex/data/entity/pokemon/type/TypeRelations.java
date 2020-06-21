package com.xeroxparc.pokedex.data.entity.pokemon.type;

import com.xeroxparc.pokedex.data.entity.utility.common.NamedAPIResource;

import java.util.List;

public class TypeRelations {

	private List<NamedAPIResource> no_damage_to;        //A list of types this type has no effect on. (Type)
	private List<NamedAPIResource> half_damage_to;      //A list of types this type is not very effect against. (Type)
	private List<NamedAPIResource> double_damage_to;    //A list of types this type is very effect against. (Type)
	private List<NamedAPIResource> no_damage_from;      //A list of types that have no effect on this type. (Type)
	private List<NamedAPIResource> half_damage_from;    //A list of types that are not very effective against this type. (Type)
	private List<NamedAPIResource> double_damage_from;  //A list of types that are very effective against this type. (Type)

}
