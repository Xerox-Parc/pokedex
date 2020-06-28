package com.xeroxparc.pokedex.data.model.pokemon.egggroup;

import com.google.gson.annotations.SerializedName;
import com.xeroxparc.pokedex.data.model.pokemon.species.PokemonSpecies;
import com.xeroxparc.pokedex.data.model.utility.common.Name;
import com.xeroxparc.pokedex.data.model.utility.common.NamedApiResource;

import java.util.List;

/**
 * Egg Groups are categories which determine which Pokémon are able to interbreed.
 * Pokémon may belong to either one or two Egg Groups.
 * Check out Bulbapedia for greater detail.
 *
 * @author Fabio Buracchi
 */
public class EggGroup extends NamedApiResource {

	// The name of this resource listed in different languages.
	@SerializedName("names")
	private List<Name> nameList;

	// A list of all Pokémon species that are members of this egg group.
	@SerializedName("pokemon_species")
	private List<PokemonSpecies> pokemonSpeciesList;

}
