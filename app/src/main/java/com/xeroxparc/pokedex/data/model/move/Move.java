package com.xeroxparc.pokedex.data.model.move;

import androidx.room.ColumnInfo;
import androidx.room.Entity;

import com.google.gson.annotations.SerializedName;
import com.xeroxparc.pokedex.data.model.contest.effect.ContestEffect;
import com.xeroxparc.pokedex.data.model.contest.supereffect.SuperContestEffect;
import com.xeroxparc.pokedex.data.model.contest.type.ContestType;
import com.xeroxparc.pokedex.data.model.game.generation.Generation;
import com.xeroxparc.pokedex.data.model.move.damageclass.MoveDamageClass;
import com.xeroxparc.pokedex.data.model.move.target.MoveTarget;
import com.xeroxparc.pokedex.data.model.pokemon.ability.AbilityEffectChange;
import com.xeroxparc.pokedex.data.model.pokemon.type.Type;
import com.xeroxparc.pokedex.data.model.utility.common.MachineVersionDetail;
import com.xeroxparc.pokedex.data.model.utility.common.Name;
import com.xeroxparc.pokedex.data.model.utility.common.NamedApiResource;
import com.xeroxparc.pokedex.data.model.utility.common.VerboseEffect;

import java.util.List;

/**
 * Moves are the skills of Pokémon in battle. In battle, a Pokémon uses one move each turn.
 * Some moves (including those learned by Hidden Machine) can be used outside of battle as
 * well, usually for the purpose of removing obstacles or exploring new areas.
 *
 * @author Fabio Buracchi
 */
@Entity(tableName = "move")
public class Move extends NamedApiResource {

	// The percent value of how likely this move is to be successful.
	@ColumnInfo(name = "accuracy")
	@SerializedName("accuracy")
	private Integer accuracy;

	// The percent value of how likely it is this moves effect will happen.
	@ColumnInfo(name = "effect_chance")
	@SerializedName("effect_chance")
	private Integer effectChance;

	// Power points. The number of times this move can be used.
	@ColumnInfo(name = "pp")
	@SerializedName("pp")
	private Integer pp;

	// A value between -8 and 8. Sets the order in which moves are executed during battle.
	// See Bulbapedia for greater detail
	@ColumnInfo(name = "priority")
	@SerializedName("priority")
	private Integer priority;

	// The base power of this move with a value of 0 if it does not have a base power.
	@ColumnInfo(name = "power")
	@SerializedName("power")
	private Integer power;

	// A detail of normal and super contest combos that require this move.
	@ColumnInfo(name = "contest_combos_data")
	@SerializedName("contest_combos")
	private ContestComboSet contestComboSet;

	// The type of appeal this move gives a Pokémon when used in a contest.
	@ColumnInfo(name = "contest_type_data")
	@SerializedName("contest_type")
	private ContestType contestType;

	// The effect the move has when used in a contest.
	@ColumnInfo(name = "contest_effect_data")
	@SerializedName("contest_effect")
	private ContestEffect contestEffect;

	// The type of damage the move inflicts on the target, e.g. physical.
	@ColumnInfo(name = "damage_class_data")
	@SerializedName("damage_class")
	private MoveDamageClass damageClass;

	// The effect of this move listed in different languages.
	@ColumnInfo(name = "effect_entries_data")
	@SerializedName("effect_entries")
	private List<VerboseEffect> effectEntryList;

	// The list of previous effects this move has had across version groups of the games.
	@ColumnInfo(name = "effect_changes_data")
	@SerializedName("effect_changes")
	private List<AbilityEffectChange> effectChangeList;

	// The flavor text of this move listed in different languages.
	@ColumnInfo(name = "flavor_text_entries_data")
	@SerializedName("flavor_text_entries")
	private List<MoveFlavorText> flavorTextEntryList;

	// The generation in which this move was introduced.
	@ColumnInfo(name = "generation_data")
	@SerializedName("generation")
	private Generation generation;

	// A list of the machines that teach this move.
	@ColumnInfo(name = "machines_data")
	@SerializedName("machines")
	private List<MachineVersionDetail> machineList;

	// Metadata about this move
	@ColumnInfo(name = "meta_data")
	@SerializedName("meta")
	private MoveMetaData meta;

	// The name of this resource listed in different languages.
	@ColumnInfo(name = "names_data")
	@SerializedName("names")
	private List<Name> nameList;

	// A list of move resource value changes across version groups of the game.
	@ColumnInfo(name = "past_values_data")
	@SerializedName("past_values")
	private List<PastMoveStatValues> pastValueList;

	// A list of stats this moves effects and how much it effects them.
	@ColumnInfo(name = "stat_changes_data")
	@SerializedName("stat_changes")
	private List<MoveStatChange> statChangeList;

	// The effect the move has when used in a super contest.
	@ColumnInfo(name = "super_contest_effect_data")
	@SerializedName("super_contest_effect")
	private SuperContestEffect superContestEffect;

	// The type of target that will receive the effects of the attack.
	@ColumnInfo(name = "target_data")
	@SerializedName("target")
	private MoveTarget target;

	// The elemental type of this move.
	@ColumnInfo(name = "type_data")
	@SerializedName("type")
	private Type type;

	public Integer getAccuracy() {
		return accuracy;
	}

	public void setAccuracy(Integer accuracy) {
		this.accuracy = accuracy;
	}

	public Integer getEffectChance() {
		return effectChance;
	}

	public void setEffectChance(Integer effectChance) {
		this.effectChance = effectChance;
	}

	public Integer getPp() {
		return pp;
	}

	public void setPp(Integer pp) {
		this.pp = pp;
	}

	public Integer getPriority() {
		return priority;
	}

	public void setPriority(Integer priority) {
		this.priority = priority;
	}

	public Integer getPower() {
		return power;
	}

	public void setPower(Integer power) {
		this.power = power;
	}

	public ContestComboSet getContestComboSet() {
		return contestComboSet;
	}

	public void setContestComboSet(ContestComboSet contestComboSet) {
		this.contestComboSet = contestComboSet;
	}

	public ContestType getContestType() {
		return contestType;
	}

	public void setContestType(ContestType contestType) {
		this.contestType = contestType;
	}

	public ContestEffect getContestEffect() {
		return contestEffect;
	}

	public void setContestEffect(ContestEffect contestEffect) {
		this.contestEffect = contestEffect;
	}

	public MoveDamageClass getDamageClass() {
		return damageClass;
	}

	public void setDamageClass(MoveDamageClass damageClass) {
		this.damageClass = damageClass;
	}

	public List<VerboseEffect> getEffectEntryList() {
		return effectEntryList;
	}

	public void setEffectEntryList(List<VerboseEffect> effectEntryList) {
		this.effectEntryList = effectEntryList;
	}

	public List<AbilityEffectChange> getEffectChangeList() {
		return effectChangeList;
	}

	public void setEffectChangeList(List<AbilityEffectChange> effectChangeList) {
		this.effectChangeList = effectChangeList;
	}

	public List<MoveFlavorText> getFlavorTextEntryList() {
		return flavorTextEntryList;
	}

	public void setFlavorTextEntryList(List<MoveFlavorText> flavorTextEntryList) {
		this.flavorTextEntryList = flavorTextEntryList;
	}

	public Generation getGeneration() {
		return generation;
	}

	public void setGeneration(Generation generation) {
		this.generation = generation;
	}

	public List<MachineVersionDetail> getMachineList() {
		return machineList;
	}

	public void setMachineList(List<MachineVersionDetail> machineList) {
		this.machineList = machineList;
	}

	public MoveMetaData getMeta() {
		return meta;
	}

	public void setMeta(MoveMetaData meta) {
		this.meta = meta;
	}

	public List<Name> getNameList() {
		return nameList;
	}

	public void setNameList(List<Name> nameList) {
		this.nameList = nameList;
	}

	public List<PastMoveStatValues> getPastValueList() {
		return pastValueList;
	}

	public void setPastValueList(List<PastMoveStatValues> pastValueList) {
		this.pastValueList = pastValueList;
	}

	public List<MoveStatChange> getStatChangeList() {
		return statChangeList;
	}

	public void setStatChangeList(List<MoveStatChange> statChangeList) {
		this.statChangeList = statChangeList;
	}

	public SuperContestEffect getSuperContestEffect() {
		return superContestEffect;
	}

	public void setSuperContestEffect(SuperContestEffect superContestEffect) {
		this.superContestEffect = superContestEffect;
	}

	public MoveTarget getTarget() {
		return target;
	}

	public void setTarget(MoveTarget target) {
		this.target = target;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

}
