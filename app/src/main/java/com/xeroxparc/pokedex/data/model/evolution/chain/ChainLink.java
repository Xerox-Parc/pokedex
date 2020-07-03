package com.xeroxparc.pokedex.data.model.evolution.chain;

import com.google.gson.annotations.SerializedName;
import com.xeroxparc.pokedex.data.model.pokemon.species.PokemonSpecies;

import java.util.List;

/**
 * @author Fabio Buracchi
 */
public class ChainLink {

	// Whether or not this link is for a baby Pokémon. This would only ever be true on the base link.
	@SerializedName("is_baby")
	private Boolean isBaby;

	// The Pokémon species at this point in the evolution chain.
	@SerializedName("species")
	private PokemonSpecies species;

	// All details regarding the specific details of the referenced Pokémon species evolution.
	@SerializedName("evolution_details")
	private List<EvolutionDetail> evolutionDetailList;

	// A List of chain objects.
	@SerializedName("evolves_to")
	private List<ChainLink> evolutionList;

	public Boolean getBaby() {
		return isBaby;
	}

	public PokemonSpecies getSpecies() {
		return species;
	}

	public List<EvolutionDetail> getEvolutionDetailList() {
		return evolutionDetailList;
	}

	public List<ChainLink> getEvolutionList() {
		return evolutionList;
	}

}
