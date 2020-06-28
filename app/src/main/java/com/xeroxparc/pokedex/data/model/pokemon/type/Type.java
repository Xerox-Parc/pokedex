package com.xeroxparc.pokedex.data.model.pokemon.type;

import com.google.gson.annotations.SerializedName;
import com.xeroxparc.pokedex.data.model.game.generation.Generation;
import com.xeroxparc.pokedex.data.model.move.Move;
import com.xeroxparc.pokedex.data.model.move.damageclass.MoveDamageClass;
import com.xeroxparc.pokedex.data.model.utility.common.GenerationGameIndex;
import com.xeroxparc.pokedex.data.model.utility.common.Name;
import com.xeroxparc.pokedex.data.model.utility.common.NamedApiResource;

import java.util.List;

/**
 * Types are properties for Pokémon and their moves. Each type has three properties:
 * which types of Pokémon it is super effective against,
 * which types of Pokémon it is not very effective against,
 * which types of Pokémon it is completely ineffective against.
 *
 * @author Fabio Buracchi
 */
public class Type extends NamedApiResource {

	// A detail of how effective this type is toward others and vice versa.
	@SerializedName("damage_relations")
	private TypeRelations damageRelations;

	// A list of game indices relevant to this item by generation.
	@SerializedName("game_indices")
	private List<GenerationGameIndex> gameIndexList;

	// The generation this type was introduced in.
	@SerializedName("generation")
	private Generation generation;

	// The class of damage inflicted by this type.
	@SerializedName("move_damage_class")
	private MoveDamageClass moveDamageClass;

	// The name of this resource listed in different languages.
	@SerializedName("names")
	private List<Name> nameList;

	// A list of details of Pokémon that have this type.
	@SerializedName("pokemon")
	private List<TypePokemon> pokemonList;

	// A list of moves that have this type.
	@SerializedName("moves")
	private List<Move> moveList;
	
}
