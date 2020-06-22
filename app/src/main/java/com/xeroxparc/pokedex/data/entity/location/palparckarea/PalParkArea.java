package com.xeroxparc.pokedex.data.entity.location.palparckarea;

import com.google.gson.annotations.SerializedName;
import com.xeroxparc.pokedex.data.entity.utility.common.Name;

import java.util.List;

public class PalParkArea {

	/*
		Areas used for grouping Pokémon encounters in Pal Park. They're like habitats that are specific to Pal Park.
	 */

	@SerializedName("id")
	private Integer id;                                             // The identifier for this
																	// resource.

	@SerializedName("name")
	private String name;                                            // The name for this resource.

	@SerializedName("names")
	private List<Name> nameList;                                    // The name of this resource
																	// listed in different languages.

	@SerializedName("pokemon_encounters")
	private List<PalParkEncounterSpecies> pokemonEncounterList;     // A list of Pokémon encountered
																	// in the pal park area along
																	// with details.

}
