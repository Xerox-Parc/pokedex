package com.xeroxparc.pokedex.data.model.evolutions.chain;

import com.google.gson.annotations.SerializedName;
import com.xeroxparc.pokedex.data.model.item.Item;
import com.xeroxparc.pokedex.data.model.utility.common.APIResource;

/**
 * Evolution chains are essentially family trees. They start with the lowest stage within a
 * family and detail evolution conditions for each as well as Pokémon they can evolve into up
 * through the hierarchy.
 * 	
 * @author Fabio Buracchi
 */
public class EvolutionChain extends APIResource {

	// The item that a Pokémon would be holding when mating that would trigger the egg hatching a baby Pokémon rather than a basic Pokémon.
	@SerializedName("baby_trigger_item")
	private Item babyTriggerItem;

	// The base chain link object. Each link contains evolution details for a Pokémon in the chain. Each link references the next Pokémon in the natural evolution order.
	@SerializedName("chain")
	private ChainLink chainLink;

}
