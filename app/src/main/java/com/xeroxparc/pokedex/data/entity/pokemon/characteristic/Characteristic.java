package com.xeroxparc.pokedex.data.entity.pokemon.characteristic;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Characteristic {

	/*
		Characteristics indicate which stat contains a Pokémon's highest IV. A Pokémon's
		Characteristic is determined by the remainder of its highest IV divided by 5 (gene_modulo).
		Check out Bulbapedia for greater detail.
	 */

	@SerializedName("id")
	private Integer id;                         // The identifier for this resource.

	@SerializedName("gene_modulo")
	private Integer geneModulo;                 // The remainder of the highest stat/IV divided
												// by 5.

	@SerializedName("possible_values")
	private List<Integer> possibleValueList;    // The possible values of the highest stat that
												// would result in a Pokémon receiving this
												// characteristic when divided by 5.

}
