package com.xeroxparc.pokedex.data.model.item;

import androidx.room.Entity;

import com.google.gson.annotations.SerializedName;
import com.xeroxparc.pokedex.data.model.evolution.chain.EvolutionChain;
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
@Entity(tableName = "item")
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

	public Integer getCost() {
		return cost;
	}

	public void setCost(Integer cost) {
		this.cost = cost;
	}

	public Integer getFlingPower() {
		return flingPower;
	}

	public void setFlingPower(Integer flingPower) {
		this.flingPower = flingPower;
	}

	public ItemFlingEffect getFlingEffect() {
		return flingEffect;
	}

	public void setFlingEffect(ItemFlingEffect flingEffect) {
		this.flingEffect = flingEffect;
	}

	public List<ItemAttribute> getAttributeList() {
		return attributeList;
	}

	public void setAttributeList(List<ItemAttribute> attributeList) {
		this.attributeList = attributeList;
	}

	public ItemCategory getCategory() {
		return category;
	}

	public void setCategory(ItemCategory category) {
		this.category = category;
	}

	public List<VerboseEffect> getEffectEntryList() {
		return effectEntryList;
	}

	public void setEffectEntryList(List<VerboseEffect> effectEntryList) {
		this.effectEntryList = effectEntryList;
	}

	public List<VersionGroupFlavorText> getFlavorTextEntryList() {
		return flavorTextEntryList;
	}

	public void setFlavorTextEntryList(List<VersionGroupFlavorText> flavorTextEntryList) {
		this.flavorTextEntryList = flavorTextEntryList;
	}

	public List<GenerationGameIndex> getGameIndexList() {
		return gameIndexList;
	}

	public void setGameIndexList(List<GenerationGameIndex> gameIndexList) {
		this.gameIndexList = gameIndexList;
	}

	public List<Name> getNameList() {
		return nameList;
	}

	public void setNameList(List<Name> nameList) {
		this.nameList = nameList;
	}

	public ItemSprites getSprites() {
		return sprites;
	}

	public void setSprites(ItemSprites sprites) {
		this.sprites = sprites;
	}

	public List<ItemHolderPokemon> getHeldByPokemonList() {
		return heldByPokemonList;
	}

	public void setHeldByPokemonList(List<ItemHolderPokemon> heldByPokemonList) {
		this.heldByPokemonList = heldByPokemonList;
	}

	public EvolutionChain getBabyTriggerFor() {
		return babyTriggerFor;
	}

	public void setBabyTriggerFor(EvolutionChain babyTriggerFor) {
		this.babyTriggerFor = babyTriggerFor;
	}

	public List<MachineVersionDetail> getMachineList() {
		return machineList;
	}

	public void setMachineList(List<MachineVersionDetail> machineList) {
		this.machineList = machineList;
	}

}
