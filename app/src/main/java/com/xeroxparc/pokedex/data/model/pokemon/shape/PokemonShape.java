package com.xeroxparc.pokedex.data.model.pokemon.shape;

import com.google.gson.annotations.SerializedName;
import com.xeroxparc.pokedex.data.model.pokemon.species.PokemonSpecies;
import com.xeroxparc.pokedex.data.model.utility.common.Name;
import com.xeroxparc.pokedex.data.model.utility.common.NamedApiResource;

import java.util.List;

/**
 * Shapes used for sorting Pokémon in a Pokédex.
 * 
 * @author Fabio Buracchi
 */
public class PokemonShape extends NamedApiResource {

	// The "scientific" name of this Pokémon shape listed in different languages.
	@SerializedName("awesome_names")
	private List<AwesomeName> awesomeNameList;

	// The name of this resource listed in different languages.
	@SerializedName("names")
	private List<Name> nameList;

	// A list of the Pokémon species that have this shape.
	@SerializedName("pokemon_species")
	private List<PokemonSpecies> pokemonSpeciesList;

}
