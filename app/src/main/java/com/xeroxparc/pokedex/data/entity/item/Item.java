package com.xeroxparc.pokedex.data.entity.item;

import com.google.gson.annotations.SerializedName;
import com.xeroxparc.pokedex.data.entity.utility.common.APIResource;
import com.xeroxparc.pokedex.data.entity.utility.common.GenerationGameIndex;
import com.xeroxparc.pokedex.data.entity.utility.common.MachineVersionDetail;
import com.xeroxparc.pokedex.data.entity.utility.common.Name;
import com.xeroxparc.pokedex.data.entity.utility.common.NamedAPIResource;
import com.xeroxparc.pokedex.data.entity.utility.common.VerboseEffect;
import com.xeroxparc.pokedex.data.entity.utility.common.VersionGroupFlavorText;

import java.util.List;

public class Item {

	/*
		An item is an object in the games which the player can pick up, keep in their bag, and use
		in some manner. They have various uses, including healing, powering up, helping catch
		Pokémon, or to access a new area.
	 */

	@SerializedName("id")
	private Integer id;                                         // The identifier for this resource.

	@SerializedName("name")
	private String name;                                        // The name for this resource.

	@SerializedName("cost")
	private Integer cost;                                       // The price of this item in stores.

	@SerializedName("fling_power")
	private Integer flingPower;                                 // The power of the move Fling when
																// used with this item.

	@SerializedName("fling_effect")
	private NamedAPIResource flingEffectResource;               // The effect of the move Fling when
																// used with this item.
																// (ItemFlingEffect)

	@SerializedName("attributes")
	private List<NamedAPIResource> attributeListResource;       // A list of attributes this item
																// has.
																// (ItemAttribute)

	@SerializedName("category")
	private NamedAPIResource categoryResource;                  // The category of items this item
																// falls into.
																// (ItemCategory)

	@SerializedName("effect_entries")
	private List<VerboseEffect> effectEntryList;                // The effect of this ability listed
																// in different languages.

	@SerializedName("flavor_text_entries")
	private List<VersionGroupFlavorText> flavorTextEntryList;   // The flavor text of this ability
																// listed in different languages.

	@SerializedName("game_indices")
	private List<GenerationGameIndex> gameIndexList;            // A list of game indices relevent
																// to this item by generation.

	@SerializedName("names")
	private List<Name> nameList;                                // The name of this item listed in
																// different languages.

	@SerializedName("sprites")
	private ItemSprites sprites;                                // A set of sprites used to depict
																// this item in the game.

	@SerializedName("held_by_pokemon")
	private List<ItemHolderPokemon> heldByPokemonList;          // A list of Pokémon that might be
																// found in the wild holding this
																// item.

	@SerializedName("baby_trigger_for")
	private APIResource babyTriggerForResource;                 // An evolution chain this item
																// requires to produce a baby during
																// mating.
																// (EvolutionChain)

	@SerializedName("machines")
	private List<MachineVersionDetail> machineList;             // A list of the machines related to
																// this item.

}
