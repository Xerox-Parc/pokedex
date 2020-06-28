package com.xeroxparc.pokedex.data.model.move;

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
public class Move extends NamedApiResource {

	// The percent value of how likely this move is to be successful.
	@SerializedName("accuracy")
	private Integer accuracy;

	// The percent value of how likely it is this moves effect will happen.
	@SerializedName("effect_chance")
	private Integer effectChance;

	// Power points. The number of times this move can be used.
	@SerializedName("pp")
	private Integer pp;

	// A value between -8 and 8. Sets the order in which moves are executed during battle.
	// See Bulbapedia for greater detail
	@SerializedName("priority")
	private Integer priority;

	// The base power of this move with a value of 0 if it does not have a base power.
	@SerializedName("power")
	private Integer power;

	// A detail of normal and super contest combos that require this move.
	@SerializedName("contest_combos")
	private ContestComboSet contestComboSet;

	// The type of appeal this move gives a Pokémon when used in a contest.
	@SerializedName("contest_type")
	private ContestType contestType;

	// The effect the move has when used in a contest.
	@SerializedName("contest_effect")
	private ContestEffect contestEffect;

	// The type of damage the move inflicts on the target, e.g. physical.
	@SerializedName("damage_class")
	private MoveDamageClass damageClass;

	// The effect of this move listed in different languages.
	@SerializedName("effect_entries")
	private List<VerboseEffect> effectEntryList;

	// The list of previous effects this move has had across version groups of the games.
	@SerializedName("effect_changes")
	private List<AbilityEffectChange> effectChangeList;

	// The flavor text of this move listed in different languages.
	@SerializedName("flavor_text_entries")
	private List<MoveFlavorText> flavorTextEntryList;

	// The generation in which this move was introduced.
	@SerializedName("generation")
	private Generation generation;

	// A list of the machines that teach this move.
	@SerializedName("machines")
	private List<MachineVersionDetail> machineList;

	// Metadata about this move
	@SerializedName("meta")
	private MoveMetaData meta;

	// The name of this resource listed in different languages.
	@SerializedName("names")
	private List<Name> nameList;

	// A list of move resource value changes across version groups of the game.
	@SerializedName("past_values")
	private List<PastMoveStatValues> pastValueList;

	// A list of stats this moves effects and how much it effects them.
	@SerializedName("stat_changes")
	private List<MoveStatChange> statChangeList;

	// The effect the move has when used in a super contest.
	@SerializedName("super_contest_effect")
	private SuperContestEffect superContestEffect;

	// The type of target that will receive the effects of the attack.
	@SerializedName("target")
	private MoveTarget target;

	// The elemental type of this move.
	@SerializedName("type")
	private Type type;

}
