package com.xeroxparc.pokedex.data.model.berry;

import androidx.room.Entity;

import com.google.gson.annotations.SerializedName;
import com.xeroxparc.pokedex.data.model.berry.firmness.BerryFirmness;
import com.xeroxparc.pokedex.data.model.item.Item;
import com.xeroxparc.pokedex.data.model.pokemon.type.Type;
import com.xeroxparc.pokedex.data.model.utility.common.NamedApiResource;

import java.util.List;

/**
 * Berries are small fruits that can provide HP and status condition restoration, stat
 * enhancement, and even damage negation when eaten by Pokémon.
 * Check out Bulbapedia for greater detail.
 *
 * @author Fabio Buracchi
 */
@Entity(tableName = "berry")
public class Berry extends NamedApiResource {

	// Time it takes the tree to grow one stage, in hours. Berry trees go through four of these growth stages before they can be picked.
	@SerializedName("growth_time")
	private Integer growthTime;

	// The maximum number of these berries that can grow on one tree in Generation IV.
	@SerializedName("max_harvest")
	private Integer maxHarvest;

	// The power of the move "Natural Gift" when used with this Berry.
	@SerializedName("natural_gift_power")
	private Integer naturalGiftPower;

	// The size of this Berry, in millimeters.
	@SerializedName("size")
	private Integer size;

	// The smoothness of this Berry, used in making Pokéblocks or Poffins.
	@SerializedName("smoothness")
	private Integer smoothness;

	// The speed at which this Berry dries out the soil as it grows. A higher rate means the soil dries more quickly.
	@SerializedName("soil_dryness")
	private Integer soilDryness;

	// The firmness of this berry, used in making Pokéblocks or Poffins.
	@SerializedName("firmness")
	private BerryFirmness firmness;

	// A list of references to each flavor a berry can have and the potency of each of those flavors in regard to this berry.
	@SerializedName("flavors")
	private List<BerryFlavorMap> flavorMapList;

	// Berries are actually items. This is a reference to the item specific data for this berry.
	@SerializedName("item")
	private Item item;

	// The type inherited by "Natural Gift" when used with this Berry.
	@SerializedName("natural_gift_type")
	private Type naturalGiftType;

	public Integer getGrowthTime() {
		return growthTime;
	}

	public void setGrowthTime(Integer growthTime) {
		this.growthTime = growthTime;
	}

	public Integer getMaxHarvest() {
		return maxHarvest;
	}

	public void setMaxHarvest(Integer maxHarvest) {
		this.maxHarvest = maxHarvest;
	}

	public Integer getNaturalGiftPower() {
		return naturalGiftPower;
	}

	public void setNaturalGiftPower(Integer naturalGiftPower) {
		this.naturalGiftPower = naturalGiftPower;
	}

	public Integer getSize() {
		return size;
	}

	public void setSize(Integer size) {
		this.size = size;
	}

	public Integer getSmoothness() {
		return smoothness;
	}

	public void setSmoothness(Integer smoothness) {
		this.smoothness = smoothness;
	}

	public Integer getSoilDryness() {
		return soilDryness;
	}

	public void setSoilDryness(Integer soilDryness) {
		this.soilDryness = soilDryness;
	}

	public BerryFirmness getFirmness() {
		return firmness;
	}

	public void setFirmness(BerryFirmness firmness) {
		this.firmness = firmness;
	}

	public List<BerryFlavorMap> getFlavorMapList() {
		return flavorMapList;
	}

	public void setFlavorMapList(List<BerryFlavorMap> flavorMapList) {
		this.flavorMapList = flavorMapList;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public Type getNaturalGiftType() {
		return naturalGiftType;
	}

	public void setNaturalGiftType(Type naturalGiftType) {
		this.naturalGiftType = naturalGiftType;
	}

}
