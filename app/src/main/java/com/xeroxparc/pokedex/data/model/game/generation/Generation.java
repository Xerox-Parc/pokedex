package com.xeroxparc.pokedex.data.model.game.generation;

import com.google.gson.annotations.SerializedName;
import com.xeroxparc.pokedex.data.model.game.versiongroup.VersionGroup;
import com.xeroxparc.pokedex.data.model.location.region.Region;
import com.xeroxparc.pokedex.data.model.move.Move;
import com.xeroxparc.pokedex.data.model.pokemon.ability.Ability;
import com.xeroxparc.pokedex.data.model.pokemon.species.PokemonSpecies;
import com.xeroxparc.pokedex.data.model.pokemon.type.Type;
import com.xeroxparc.pokedex.data.model.utility.common.Name;
import com.xeroxparc.pokedex.data.model.utility.common.NamedApiResource;

import java.util.List;

/**
 * A generation is a grouping of the Pokémon games that separates them based on the Pokémon
 * they include. In each generation, a new set of Pokémon, Moves, Abilities and Types that did
 * not exist in the previous generation are released.
 *
 * @author Fabio Buracchi
 */
public class Generation extends NamedApiResource {

	// A list of abilities that were introduced in this generation.
	@SerializedName("abilities")
	private List<Ability> abilityList;

	// The name of this resource listed in different languages.
	@SerializedName("names")
	private List<Name> nameList;

	// The main region travelled in this generation.
	@SerializedName("main_region")
	private Region mainRegion;

	// A list of moves that were introduced in this generation.
	@SerializedName("moves")
	private List<Move> moveList;

	// A list of Pokémon species that were introduced in this generation.
	@SerializedName("pokemon_species")
	private List<PokemonSpecies> pokemonSpeciesList;

	// A list of types that were introduced in this generation.
	@SerializedName("types")
	private List<Type> typeList;

	// A list of version groups that were introduced in this generation.
	@SerializedName("version_groups")
	private List<VersionGroup> versionGroupList;

}
