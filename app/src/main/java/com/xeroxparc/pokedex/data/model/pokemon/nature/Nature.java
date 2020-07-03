package com.xeroxparc.pokedex.data.model.pokemon.nature;

import androidx.room.ColumnInfo;
import androidx.room.Entity;

import com.google.gson.annotations.SerializedName;
import com.xeroxparc.pokedex.data.model.berry.flavor.BerryFlavor;
import com.xeroxparc.pokedex.data.model.pokemon.stats.Stat;
import com.xeroxparc.pokedex.data.model.utility.common.Name;
import com.xeroxparc.pokedex.data.model.utility.common.NamedApiResource;

import java.util.List;

/**
 * Natures influence how a Pokémon's stats grow. See Bulbapedia for greater detail.
 * 
 * @author Fabio Buracchi
 */
@Entity(tableName = "nature")
public class Nature extends NamedApiResource {

	// The stat decreased by 10% in Pokémon with this nature.
	@ColumnInfo(name = "decreased_stat_data")
	@SerializedName("decreased_stat")
	private Stat decreasedStat;

	// The stat increased by 10% in Pokémon with this nature.
	@ColumnInfo(name = "increased_stat_data")
	@SerializedName("increased_stat")
	private Stat increasedStat;

	// The flavor hated by Pokémon with this nature.
	@ColumnInfo(name = "hates_flavor_data")
	@SerializedName("hates_flavor")
	private BerryFlavor hatesFlavor;

	// The flavor liked by Pokémon with this nature.
	@ColumnInfo(name = "likes_flavor_data")
	@SerializedName("likes_flavor")
	private BerryFlavor likesFlavor;

	// A list of Pokéathlon stats this nature effects and how much it effects them.
	@ColumnInfo(name = "pokeathlon_stat_changes_data")
	@SerializedName("pokeathlon_stat_changes")
	private List<NatureStatChange> pokeathlonStatChangeList;

	// A list of battle styles and how likely a Pokémon with this nature is to use them in the Battle Palace or Battle Tent.
	@ColumnInfo(name = "move_battle_style_preferences_data")
	@SerializedName("move_battle_style_preferences")
	private List<MoveBattleStylePreference> moveBattleStylePreferenceList;

	// The name of this resource listed in different languages.
	@ColumnInfo(name = "names_data")
	@SerializedName("names")
	private List<Name> nameList;

	public Stat getDecreasedStat() {
		return decreasedStat;
	}

	public void setDecreasedStat(Stat decreasedStat) {
		this.decreasedStat = decreasedStat;
	}

	public Stat getIncreasedStat() {
		return increasedStat;
	}

	public void setIncreasedStat(Stat increasedStat) {
		this.increasedStat = increasedStat;
	}

	public BerryFlavor getHatesFlavor() {
		return hatesFlavor;
	}

	public void setHatesFlavor(BerryFlavor hatesFlavor) {
		this.hatesFlavor = hatesFlavor;
	}

	public BerryFlavor getLikesFlavor() {
		return likesFlavor;
	}

	public void setLikesFlavor(BerryFlavor likesFlavor) {
		this.likesFlavor = likesFlavor;
	}

	public List<NatureStatChange> getPokeathlonStatChangeList() {
		return pokeathlonStatChangeList;
	}

	public void setPokeathlonStatChangeList(List<NatureStatChange> pokeathlonStatChangeList) {
		this.pokeathlonStatChangeList = pokeathlonStatChangeList;
	}

	public List<MoveBattleStylePreference> getMoveBattleStylePreferenceList() {
		return moveBattleStylePreferenceList;
	}

	public void setMoveBattleStylePreferenceList(List<MoveBattleStylePreference> moveBattleStylePreferenceList) {
		this.moveBattleStylePreferenceList = moveBattleStylePreferenceList;
	}

	public List<Name> getNameList() {
		return nameList;
	}

	public void setNameList(List<Name> nameList) {
		this.nameList = nameList;
	}

}
