package com.xeroxparc.pokedex.data.entity.evolutions.chain;

import com.xeroxparc.pokedex.data.entity.utility.common.NamedAPIResource;

public class EvolutionChain {

	//Evolution chains are essentially family trees. They start with the lowest stage within a family and detail evolution conditions for each as well as Pokémon they can evolve into up through the hierarchy.

	private Integer id;                         //The identifier for this resource.
	private NamedAPIResource baby_trigger_item; //The item that a Pokémon would be holding when mating that would trigger the egg hatching a baby Pokémon rather than a basic Pokémon. (Item)
	private ChainLink chain;                    //The base chain link object. Each link contains evolution details for a Pokémon in the chain. Each link references the next Pokémon in the natural evolution order.

}
