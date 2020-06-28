package com.xeroxparc.pokedex.data.model.pokemon.characteristic;

import com.google.gson.annotations.SerializedName;
import com.xeroxparc.pokedex.data.model.utility.common.ApiResource;

import java.util.List;

/**
 * Characteristics indicate which stat contains a Pokémon's highest IV. A Pokémon's
 * Characteristic is determined by the remainder of its highest IV divided by 5 (gene_modulo).
 * Check out Bulbapedia for greater detail.
 *
 * @author Fabio Buracchi
 */
public class Characteristic extends ApiResource {

	// The remainder of the highest stat/IV divided by 5.
	@SerializedName("gene_modulo")
	private Integer geneModulo;

	// The possible values of the highest stat that would result in a Pokémon receiving this characteristic when divided by 5.
	@SerializedName("possible_values")
	private List<Integer> possibleValueList;

}
