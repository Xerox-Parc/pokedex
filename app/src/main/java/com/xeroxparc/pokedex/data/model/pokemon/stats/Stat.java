package com.xeroxparc.pokedex.data.model.pokemon.stats;

import androidx.room.ColumnInfo;
import androidx.room.Entity;

import com.google.gson.annotations.SerializedName;
import com.xeroxparc.pokedex.data.model.move.damageclass.MoveDamageClass;
import com.xeroxparc.pokedex.data.model.pokemon.characteristic.Characteristic;
import com.xeroxparc.pokedex.data.model.utility.common.Name;
import com.xeroxparc.pokedex.data.model.utility.common.NamedApiResource;

import java.util.List;

/**
 * Stats determine certain aspects of battles. Each Pokémon has a value for each stat which
 * grows as they gain levels and can be altered momentarily by effects in battles.
 *
 * @author Fabio Buracchi
 */
@Entity(tableName = "stat")
public class Stat extends NamedApiResource {

	// ID the games use for this stat.
	@ColumnInfo(name = "game_index")
	@SerializedName("game_index")
	private Integer gameIndex;

	// Whether this stat only exists within a battle.
	@ColumnInfo(name = "is_battle_only")
	@SerializedName("is_battle_only")
	private Boolean isBattleOnly;

	// A detail of moves which affect this stat positively or negatively.
	@ColumnInfo(name = "affecting_moves_data")
	@SerializedName("affecting_moves")
	private MoveStatAffectSets affectingMoves;

	// A detail of natures which affect this stat positively or negatively.
	@ColumnInfo(name = "affecting_natures_data")
	@SerializedName("affecting_natures")
	private NatureStatAffectSets affectingNatures;

	// A list of characteristics that are set on a Pokémon when its highest base stat is this stat.
	@ColumnInfo(name = "characteristics_data")
	@SerializedName("characteristics")
	private List<Characteristic> characteristicList;

	// The class of damage this stat is directly related to.
	@ColumnInfo(name = "move_damage_class_data")
	@SerializedName("move_damage_class")
	private MoveDamageClass moveDamageClass;

	// The name of this resource listed in different languages.
	@ColumnInfo(name = "names_data")
	@SerializedName("names")
	private List<Name> nameList;

	public Integer getGameIndex() {
		return gameIndex;
	}

	public void setGameIndex(Integer gameIndex) {
		this.gameIndex = gameIndex;
	}

	public Boolean getBattleOnly() {
		return isBattleOnly;
	}

	public void setBattleOnly(Boolean battleOnly) {
		isBattleOnly = battleOnly;
	}

	public MoveStatAffectSets getAffectingMoves() {
		return affectingMoves;
	}

	public void setAffectingMoves(MoveStatAffectSets affectingMoves) {
		this.affectingMoves = affectingMoves;
	}

	public NatureStatAffectSets getAffectingNatures() {
		return affectingNatures;
	}

	public void setAffectingNatures(NatureStatAffectSets affectingNatures) {
		this.affectingNatures = affectingNatures;
	}

	public List<Characteristic> getCharacteristicList() {
		return characteristicList;
	}

	public void setCharacteristicList(List<Characteristic> characteristicList) {
		this.characteristicList = characteristicList;
	}

	public MoveDamageClass getMoveDamageClass() {
		return moveDamageClass;
	}

	public void setMoveDamageClass(MoveDamageClass moveDamageClass) {
		this.moveDamageClass = moveDamageClass;
	}

	public List<Name> getNameList() {
		return nameList;
	}

	public void setNameList(List<Name> nameList) {
		this.nameList = nameList;
	}

}
