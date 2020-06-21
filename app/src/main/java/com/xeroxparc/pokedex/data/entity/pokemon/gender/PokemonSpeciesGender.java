package com.xeroxparc.pokedex.data.entity.pokemon.gender;

import com.xeroxparc.pokedex.data.entity.utility.common.NamedAPIResource;

import java.util.List;

public class PokemonSpeciesGender {

	private Integer rate;                                       //The chance of this Pokémon being female, in eighths; or -1 for genderless.
	private List<NamedAPIResource> required_for_evolution;      //A Pokémon species that can be the referenced gender. (PokemonSpecies)

}
