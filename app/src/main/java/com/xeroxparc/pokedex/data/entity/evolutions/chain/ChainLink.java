package com.xeroxparc.pokedex.data.entity.evolutions.chain;

import com.google.gson.annotations.SerializedName;
import com.xeroxparc.pokedex.data.entity.utility.common.NamedAPIResource;

import java.util.List;

public class ChainLink {

	@SerializedName("is_baby")
	private Boolean isBaby;                             // Whether or not this link is for a baby
														// Pokémon. This would only ever be true on
														// the base link.

	@SerializedName("species")
	private NamedAPIResource speciesResource;           // The Pokémon species at this point in the
														// evolution chain.
														// (PokemonSpecies)

	@SerializedName("evolution_details")
	private List<EvolutionDetail> evolutionDetailList;  // All details regarding the specific
														// details of the referenced Pokémon species
														// evolution.

	@SerializedName("evolves_to")
	private List<ChainLink> evolutionList;              // A List of chain objects.

}
