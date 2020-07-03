package com.xeroxparc.pokedex.data.model.evolution.chain;

import androidx.room.ColumnInfo;
import androidx.room.Entity;

import com.google.gson.annotations.SerializedName;
import com.xeroxparc.pokedex.data.model.item.Item;
import com.xeroxparc.pokedex.data.model.utility.common.ApiResource;

/**
 * Evolution chains are essentially family trees. They start with the lowest stage within a
 * family and detail evolution conditions for each as well as Pokémon they can evolve into up
 * through the hierarchy.
 * 	
 * @author Fabio Buracchi
 */
@Entity(tableName = "evolution_chain")
public class EvolutionChain extends ApiResource {

	// The item that a Pokémon would be holding when mating that would trigger the egg hatching a baby Pokémon rather than a basic Pokémon.
	@ColumnInfo(name = "baby_trigger_item_data")
	@SerializedName("baby_trigger_item")
	private Item babyTriggerItem;

	// The base chain link object. Each link contains evolution details for a Pokémon in the chain. Each link references the next Pokémon in the natural evolution order.
	@ColumnInfo(name = "chain_data")
	@SerializedName("chain")
	private ChainLink chainLink;

	public Item getBabyTriggerItem() {
		return babyTriggerItem;
	}

	public void setBabyTriggerItem(Item babyTriggerItem) {
		this.babyTriggerItem = babyTriggerItem;
	}

	public ChainLink getChainLink() {
		return chainLink;
	}

	public void setChainLink(ChainLink chainLink) {
		this.chainLink = chainLink;
	}

}
