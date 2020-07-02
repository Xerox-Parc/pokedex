package com.xeroxparc.pokedex.data.model.pokemon;

import androidx.room.Entity;

import com.google.gson.annotations.SerializedName;
import com.xeroxparc.pokedex.data.model.pokemon.form.PokemonForm;
import com.xeroxparc.pokedex.data.model.pokemon.species.PokemonSpecies;
import com.xeroxparc.pokedex.data.model.utility.common.NamedApiResource;
import com.xeroxparc.pokedex.data.model.utility.common.VersionGameIndex;

import java.util.List;

/**
 * Pokémon are the creatures that inhabit the world of the Pokémon games. They can be caught
 * using Pokéballs and trained by battling with other Pokémon. Each Pokémon belongs to a
 * specific species but may take on a variant which makes it differ from other Pokémon of the
 * same species, such as base stats, available abilities and typings.
 * See Bulbapedia for greater detail.
 * 
 * @author Fabio Buracchi
 */
@Entity(tableName = "pokemon")
public class Pokemon extends NamedApiResource {

	// The base experience gained for defeating this Pokémon.
	@SerializedName("base_experience")
	private Integer baseExperience;

	// The height of this Pokémon in decimetres.
	@SerializedName("height")
	private Integer height;

	// Set for exactly one Pokémon used as the default for each species.
	@SerializedName("is_default")
	private Boolean isDefault;

	// Order for sorting. Almost national order, except families are grouped together.
	@SerializedName("order")
	private Integer order;

	// The weight of this Pokémon in hectograms.
	@SerializedName("weight")
	private Integer weight;

	// A list of abilities this Pokémon could potentially have.
	@SerializedName("abilities")
	private List<PokemonAbility> abilityList;

	// A list of forms this Pokémon can take on.
	@SerializedName("forms")
	private List<PokemonForm> formList;

	// A list of game indices relevent to Pokémon item by generation.
	@SerializedName("game_indices")
	private List<VersionGameIndex> gameIndexList;

	// A list of items this Pokémon may be holding when encountered.
	@SerializedName("held_items")
	private List<PokemonHeldItem> heldItemList;

	// A link to a list of location areas, as well as encounter details pertaining to specific versions.
	@SerializedName("location_area_encounters")
	private String locationAreaEncounters;

	// A list of moves along with learn methods and level details pertaining to specific version groups.
	@SerializedName("moves")
	private List<PokemonMove> moveList;

	// A set of sprites used to depict this Pokémon in the game.
	@SerializedName("sprites")
	private PokemonSprites sprite;

	// The species this Pokémon belongs to.
	@SerializedName("species")
	private PokemonSpecies species;

	// A list of base stat values for this Pokémon.
	@SerializedName("stats")
	private List<PokemonStat> statList;

	// A list of details showing types this Pokémon has.
	@SerializedName("types")
	private List<PokemonType> typeList;

	public Integer getBaseExperience() {
		return baseExperience;
	}

	public void setBaseExperience(Integer baseExperience) {
		this.baseExperience = baseExperience;
	}

	public Integer getHeight() {
		return height;
	}

	public void setHeight(Integer height) {
		this.height = height;
	}

	public Boolean getDefault() {
		return isDefault;
	}

	public void setDefault(Boolean aDefault) {
		isDefault = aDefault;
	}

	public Integer getOrder() {
		return order;
	}

	public void setOrder(Integer order) {
		this.order = order;
	}

	public Integer getWeight() {
		return weight;
	}

	public void setWeight(Integer weight) {
		this.weight = weight;
	}

	public List<PokemonAbility> getAbilityList() {
		return abilityList;
	}

	public void setAbilityList(List<PokemonAbility> abilityList) {
		this.abilityList = abilityList;
	}

	public List<PokemonForm> getFormList() {
		return formList;
	}

	public void setFormList(List<PokemonForm> formList) {
		this.formList = formList;
	}

	public List<VersionGameIndex> getGameIndexList() {
		return gameIndexList;
	}

	public void setGameIndexList(List<VersionGameIndex> gameIndexList) {
		this.gameIndexList = gameIndexList;
	}

	public List<PokemonHeldItem> getHeldItemList() {
		return heldItemList;
	}

	public void setHeldItemList(List<PokemonHeldItem> heldItemList) {
		this.heldItemList = heldItemList;
	}

	public String getLocationAreaEncounters() {
		return locationAreaEncounters;
	}

	public void setLocationAreaEncounters(String locationAreaEncounters) {
		this.locationAreaEncounters = locationAreaEncounters;
	}

	public List<PokemonMove> getMoveList() {
		return moveList;
	}

	public void setMoveList(List<PokemonMove> moveList) {
		this.moveList = moveList;
	}

	public PokemonSprites getSprite() {
		return sprite;
	}

	public void setSprite(PokemonSprites sprite) {
		this.sprite = sprite;
	}

	public PokemonSpecies getSpecies() {
		return species;
	}

	public void setSpecies(PokemonSpecies species) {
		this.species = species;
	}

	public List<PokemonStat> getStatList() {
		return statList;
	}

	public void setStatList(List<PokemonStat> statList) {
		this.statList = statList;
	}

	public List<PokemonType> getTypeList() {
		return typeList;
	}

	public void setTypeList(List<PokemonType> typeList) {
		this.typeList = typeList;
	}

}
