package com.xeroxparc.pokedex.data.entity.pokemon.type;

import com.xeroxparc.pokedex.data.entity.utility.common.GenerationGameIndex;
import com.xeroxparc.pokedex.data.entity.utility.common.Name;
import com.xeroxparc.pokedex.data.entity.utility.common.NamedAPIResource;

import java.util.List;

public class Type {

	//Types are properties for Pokémon and their moves. Each type has three properties: which types of Pokémon it is super effective against, which types of Pokémon it is not very effective against, and which types of Pokémon it is completely ineffective against.

	private Integer id;                                 //The identifier for this resource.
	private String name;                                //The name for this resource.
	private TypeRelations damage_relations;             //A detail of how effective this type is toward others and vice versa.
	private List<GenerationGameIndex> game_indices;     //A list of game indices relevent to this item by generation.
	private NamedAPIResource generation;                //The generation this type was introduced in. (Generation)
	private NamedAPIResource move_damage_class;         //The class of damage inflicted by this type. (MoveDamageClass)
	private List<Name> names;                           //The name of this resource listed in different languages.
	private List<TypePokemon> pokemon;                  //A list of details of Pokémon that have this type.
	private List<NamedAPIResource> moves;               //A list of moves that have this type. (Move)
}
