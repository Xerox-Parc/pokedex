package com.xeroxparc.pokedex.data.entity.evolutions.trigger;

import com.xeroxparc.pokedex.data.entity.utility.common.Name;
import com.xeroxparc.pokedex.data.entity.utility.common.NamedAPIResource;

import java.util.List;

public class EvolutionTrigger {

	//Evolution triggers are the events and conditions that cause a Pokémon to evolve. Check out Bulbapedia for greater detail.

	private Integer id;                             //The identifier for this resource.
	private String name;                            //The name for this resource.
	private List<Name> names;                       //The name of this resource listed in different languages.
	private List<NamedAPIResource> evolves_to;      //A list of pokemon species that result from this evolution trigger. (PokemonSpecies)

}
