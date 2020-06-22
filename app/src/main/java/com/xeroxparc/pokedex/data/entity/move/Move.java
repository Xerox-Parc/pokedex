package com.xeroxparc.pokedex.data.entity.move;

import com.google.gson.annotations.SerializedName;
import com.xeroxparc.pokedex.data.entity.pokemon.ability.AbilityEffectChange;
import com.xeroxparc.pokedex.data.entity.utility.common.APIResource;
import com.xeroxparc.pokedex.data.entity.utility.common.MachineVersionDetail;
import com.xeroxparc.pokedex.data.entity.utility.common.Name;
import com.xeroxparc.pokedex.data.entity.utility.common.NamedAPIResource;
import com.xeroxparc.pokedex.data.entity.utility.common.VerboseEffect;

import java.util.List;

public class Move {

	/*
		Moves are the skills of Pokémon in battle. In battle, a Pokémon uses one move each turn.
		Some moves (including those learned by Hidden Machine) can be used outside of battle as
		well, usually for the purpose of removing obstacles or exploring new areas.
	 */

	@SerializedName("id")
	private Integer id;                                         // The identifier for this resource.

	@SerializedName("name")
	private String name;                                        // The name for this resource.

	@SerializedName("accuracy")
	private Integer accuracy;                                   // The percent value of how likely
																// this move is to be successful.

	@SerializedName("effect_chance")
	private Integer effectChance;                               // The percent value of how likely
																// it is this moves effect will
																// happen.

	@SerializedName("pp")
	private Integer pp;                                         // Power points. The number of times
																// this move can be used.

	@SerializedName("priority")
	private Integer priority;                                   // A value between -8 and 8. Sets
																// the order in which moves are
																// executed during battle.
																// See Bulbapedia for greater detail

	@SerializedName("power")
	private Integer power;                                      // The base power of this move with
																// a value of 0 if it does not have
																// a base power.

	@SerializedName("contest_combos")
	private ContestComboSets contestComboSet;                   // A detail of normal and super
																// contest combos that require this
																// move.

	@SerializedName("contest_type")
	private NamedAPIResource contestTypeResource;               // The type of appeal this move
																// gives a Pokémon when used in a
																// contest.
																// (ContestType)

	@SerializedName("contest_effect")
	private APIResource contestEffectResource;                  // The effect the move has when used
																// in a contest.
																// (ContestEffect)

	@SerializedName("damage_class")
	private NamedAPIResource damageClassResource;               // The type of damage the move
																// inflicts on the target,
																// e.g. physical.
																// (MoveDamageClass)

	@SerializedName("effect_entries")
	private List<VerboseEffect> effectEntryList;                // The effect of this move listed in
																// different languages.

	@SerializedName("effect_changes")
	private List<AbilityEffectChange> effectChangesList;        // The list of previous effects this
																// move has had across version
																// groups of the games.

	@SerializedName("flavor_text_entries")
	private List<MoveFlavorText> flavorTextEntryList;           // The flavor text of this move
																// listed in different languages.

	@SerializedName("generation")
	private NamedAPIResource generationResource;                // The generation in which this move
																// was introduced.

	@SerializedName("machines")
	private List<MachineVersionDetail> machineList;             // A list of the machines that teach
																// this move.

	@SerializedName("meta")
	private MoveMetaData meta;                                  // Metadata about this move

	@SerializedName("names")
	private List<Name> nameList;                                // The name of this resource listed
																// in different languages.

	@SerializedName("past_values")
	private List<PastMoveStatValues> pastValueList;             // A list of move resource value
																// changes across version groups of
																// the game.

	@SerializedName("stat_changes")
	private List<MoveStatChange> statChangeList;                // A list of stats this moves
																// effects and how much it effects
																// them.

	@SerializedName("super_contest_effect")
	private APIResource superContestEffectResource;             // The effect the move has when used
																// in a super contest.
																// (SuperContestEffect)

	@SerializedName("target")
	private NamedAPIResource targetResource;                    // The type of target that will
																// receive the effects of the
																// attack.
																// (MoveTarget)

	@SerializedName("type")
	private NamedAPIResource typeResource;                      // The elemental type of this move.
																// (Type)

}
