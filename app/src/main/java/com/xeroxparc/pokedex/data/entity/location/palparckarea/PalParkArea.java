package com.xeroxparc.pokedex.data.entity.location.palparckarea;

import com.xeroxparc.pokedex.data.entity.utility.common.Name;

import java.util.List;

public class PalParkArea {

	//Areas used for grouping Pokémon encounters in Pal Park. They're like habitats that are specific to Pal Park.

	private Integer id;                                         //The identifier for this resource.
	private String name;                                        //The name for this resource.
	private List<Name> names;                                   //The name of this resource listed in different languages.
	private List<PalParkEncounterSpecies> pokemon_encounters;   //A list of Pokémon encountered in thi pal park area along with details.

}
