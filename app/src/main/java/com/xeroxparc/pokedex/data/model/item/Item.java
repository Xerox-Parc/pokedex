package com.xeroxparc.pokedex.data.model.item;

import com.google.gson.annotations.SerializedName;
import com.xeroxparc.pokedex.data.model.evolutions.chain.EvolutionChain;
import com.xeroxparc.pokedex.data.model.item.attribute.ItemAttribute;
import com.xeroxparc.pokedex.data.model.item.category.ItemCategory;
import com.xeroxparc.pokedex.data.model.item.effect.ItemFlingEffect;
import com.xeroxparc.pokedex.data.model.utility.common.GenerationGameIndex;
import com.xeroxparc.pokedex.data.model.utility.common.MachineVersionDetail;
import com.xeroxparc.pokedex.data.model.utility.common.Name;
import com.xeroxparc.pokedex.data.model.utility.common.NamedApiResource;
import com.xeroxparc.pokedex.data.model.utility.common.VerboseEffect;
import com.xeroxparc.pokedex.data.model.utility.common.VersionGroupFlavorText;

import java.util.List;

/**
 * An item is an object in the games which the player can pick up, keep in their bag, and use
 * in some manner. They have various uses, including healing, powering up, helping catch
 * Pokémon, or to access a new area.
 * 	
 * @author Fabio Buracchi
 */
public class Item extends NamedApiResource {

	// The price of this item in stores.
	@SerializedName("cost")
	private Integer cost;

	// The power of the move Fling when used with this item.
	@SerializedName("fling_power")
	private Integer flingPower;

	// The effect of the move Fling when used with this item.
	@SerializedName("fling_effect")
	private ItemFlingEffect flingEffect;

	//A list of attributes this item has.
	@SerializedName("attributes")
	private List<ItemAttribute> attributeList;

	// The category of items this item falls into.
	@SerializedName("category")
	private ItemCategory category;

	// The effect of this ability listed in different languages.
	@SerializedName("effect_entries")
	private List<VerboseEffect> effectEntryList;

	// The flavor text of this ability listed in different languages.
	@SerializedName("flavor_text_entries")
	private List<VersionGroupFlavorText> flavorTextEntryList;

	// A list of game indices relevent to this item by generation.
	@SerializedName("game_indices")
	private List<GenerationGameIndex> gameIndexList;

	// The name of this item listed in different languages.
	@SerializedName("names")
	private List<Name> nameList;

	// A set of sprites used to depict this item in the game.
	@SerializedName("sprites")
	private ItemSprites sprites;

	// A list of Pokémon that might be found in the wild holding this  item.
	@SerializedName("held_by_pokemon")
	private List<ItemHolderPokemon> heldByPokemonList;

	// An evolution chain this item  requires to produce a baby during  mating.
	@SerializedName("baby_trigger_for")
	private EvolutionChain babyTriggerFor;

	// A list of the machines related to  this item.
	@SerializedName("machines")
	private List<MachineVersionDetail> machineList;

}
