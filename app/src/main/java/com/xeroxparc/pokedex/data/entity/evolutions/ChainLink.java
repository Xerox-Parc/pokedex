package com.xeroxparc.pokedex.data.entity.evolutions;

import com.xeroxparc.pokedex.data.entity.utility.NamedAPIResource;

import java.util.List;

public class ChainLink {

	private Boolean is_baby;                            //Whether or not this link is for a baby Pokémon. This would only ever be true on the base link.
	private NamedAPIResource species;                   //The Pokémon species at this point in the evolution chain. (PokemonSpecies)
	private List<EvolutionDetail> evolution_details;    //All details regarding the specific details of the referenced Pokémon species evolution.
	private List<ChainLink> evolves_to;                 //A List of chain objects.

}
