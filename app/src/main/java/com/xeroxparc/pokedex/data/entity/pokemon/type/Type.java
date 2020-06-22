package com.xeroxparc.pokedex.data.entity.pokemon.type;

import com.google.gson.annotations.SerializedName;
import com.xeroxparc.pokedex.data.entity.utility.common.GenerationGameIndex;
import com.xeroxparc.pokedex.data.entity.utility.common.Name;
import com.xeroxparc.pokedex.data.entity.utility.common.NamedAPIResource;

import java.util.List;

public class Type {

	/*
		Types are properties for Pokémon and their moves. Each type has three properties:
			which types of Pokémon it is super effective against,
			which types of Pokémon it is not very effective against,
			which types of Pokémon it is completely ineffective against.
	 */
	
	@SerializedName("id")
	private Integer id;                                     // The identifier for this resource.

	@SerializedName("name")
	private String name;                                    // The name for this resource.

	@SerializedName("damage_relations")
	private TypeRelations damageRelations;                  // A detail of how effective this type
															// is toward others and vice versa.

	@SerializedName("game_indices")
	private List<GenerationGameIndex> gameIndexList;        // A list of game indices relevent to
															// this item by generation.

	@SerializedName("generation")
	private NamedAPIResource generationResource;            // The generation this type was
															// introduced in.
															// (Generation)

	@SerializedName("move_damage_class")
	private NamedAPIResource moveDamageClassResource;       // The class of damage inflicted by
															// this type.
															// (MoveDamageClass)

	@SerializedName("names")
	private List<Name> nameList;                            // The name of this resource listed
															// in different languages.

	@SerializedName("pokemon")
	private List<TypePokemon> pokemonList;                  // A list of details of Pokémon that
															// have this type.

	@SerializedName("moves")
	private List<NamedAPIResource> moveListResource;        // A list of moves that have this type.
															// (Move)
	
}
