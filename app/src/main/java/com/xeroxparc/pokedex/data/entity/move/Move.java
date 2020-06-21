package com.xeroxparc.pokedex.data.entity.move;

import com.xeroxparc.pokedex.data.entity.item.ItemHolderPokemon;
import com.xeroxparc.pokedex.data.entity.item.ItemSprites;
import com.xeroxparc.pokedex.data.entity.pokemon.AbilityEffectChange;
import com.xeroxparc.pokedex.data.entity.utility.APIResource;
import com.xeroxparc.pokedex.data.entity.utility.MachineVersionDetail;
import com.xeroxparc.pokedex.data.entity.utility.Name;
import com.xeroxparc.pokedex.data.entity.utility.NamedAPIResource;
import com.xeroxparc.pokedex.data.entity.utility.VerboseEffect;

import java.util.List;

public class Move {

	//Moves are the skills of Pokémon in battle. In battle, a Pokémon uses one move each turn. Some moves (including those learned by Hidden Machine) can be used outside of battle as well, usually for the purpose of removing obstacles or exploring new areas.

	private Integer id;                                         //The identifier for this resource.
	private String name;                                        //The name for this resource.
	private Integer accuracy;                                   //The percent value of how likely this move is to be successful.
	private Integer effect_chance;                              //The percent value of how likely it is this moves effect will happen.
	private Integer pp;                                         //Power points. The number of times this move can be used.
	private Integer priority;                                   //A value between -8 and 8. Sets the order in which moves are executed during battle. See Bulbapedia for greater detail.
	private Integer power;                                      //The base power of this move with a value of 0 if it does not have a base power.
	private ContestComboSets contest_combos;                    //A detail of normal and super contest combos that require this move.
	private NamedAPIResource contest_type;                      //The type of appeal this move gives a Pokémon when used in a contest.  (ContestType)
	private APIResource contest_effect;                         //The effect the move has when used in a contest. (ContestEffect)
	private NamedAPIResource damage_class;                      //The type of damage the move inflicts on the target, e.g. physical. (MoveDamageClass)
	private List<VerboseEffect> effect_entries;                 //The effect of this move listed in different languages.
	private List<AbilityEffectChange> effect_changes;           //The list of previous effects this move has had across version groups of the games.
	private List<MoveFlavorText> flavor_text_entries;           //The flavor text of this move listed in different languages.
	private NamedAPIResource generation;                        //The generation in which this move was introduced.
	private List<MachineVersionDetail> machines;                //A list of the machines that teach this move.
	private MoveMetaData meta;                                  //Metadata about this move
	private List<Name> names;                                   //The name of this resource listed in different languages.
	private List<PastMoveStatValues> past_values;               //A list of move resource value changes across version groups of the game.
	private List<MoveStatChange> stat_changes;                  //A list of stats this moves effects and how much it effects them.
	private APIResource super_contest_effect;                   //The effect the move has when used in a super contest. (SuperContestEffect)
	private NamedAPIResource target;                            //The type of target that will receive the effects of the attack. (MoveTarget)
	private NamedAPIResource type;                              //The elemental type of this move. (Type)

}
