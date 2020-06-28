package com.xeroxparc.pokedex.data.model.pokemon.gender;

import com.google.gson.annotations.SerializedName;
import com.xeroxparc.pokedex.data.model.pokemon.species.PokemonSpecies;
import com.xeroxparc.pokedex.data.model.utility.common.NamedApiResource;

import java.util.List;

/**
 * Genders were introduced in Generation II for the purposes of breeding Pokémon but can also
 * result in visual differences or even different evolutionary lines.
 * Check out Bulbapedia for greater detail.
 *
 * @author Fabio Buracchi
 */
public class Gender extends NamedApiResource {

	// A list of Pokémon species that can be this gender and how likely it is that they will be.
	@SerializedName("pokemon_species_details")
	private List<PokemonSpeciesGender> pokemonSpeciesDetailList;

	// A list of Pokémon species that required this gender in order for a Pokémon to evolve into them.
	@SerializedName("required_for_evolution")
	private List<PokemonSpecies> requiredForEvolutionList;

}
