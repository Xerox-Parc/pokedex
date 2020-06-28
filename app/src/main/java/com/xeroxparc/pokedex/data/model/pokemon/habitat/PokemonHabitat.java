package com.xeroxparc.pokedex.data.model.pokemon.habitat;

import com.google.gson.annotations.SerializedName;
import com.xeroxparc.pokedex.data.model.pokemon.species.PokemonSpecies;
import com.xeroxparc.pokedex.data.model.utility.common.Name;
import com.xeroxparc.pokedex.data.model.utility.common.NamedAPIResource;

import java.util.List;

/**
 * Habitats are generally different terrain Pokémon can be found in but can also be areas
 * designated for rare or legendary Pokémon.
 *
 * @author Fabio Buracchi
 */
public class PokemonHabitat extends NamedAPIResource {

	// The name of this resource listed in different languages.
	@SerializedName("names")
	private List<Name> nameList;

	// A list of the Pokémon species that can be found in this habitat
	@SerializedName("pokemon_species")
	private List<PokemonSpecies> pokemonSpeciesList;

}
