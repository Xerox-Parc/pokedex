package com.xeroxparc.pokedex.data.entity.move;

import com.xeroxparc.pokedex.data.entity.pokemon.AbilityEffectChange;
import com.xeroxparc.pokedex.data.entity.utility.APIResource;
import com.xeroxparc.pokedex.data.entity.utility.MachineVersionDetail;
import com.xeroxparc.pokedex.data.entity.utility.Name;
import com.xeroxparc.pokedex.data.entity.utility.NamedAPIResource;
import com.xeroxparc.pokedex.data.entity.utility.VerboseEffect;

import java.util.List;

public class MoveMetaData {

	private NamedAPIResource ailment;   //The status ailment this move inflicts on its target. (MoveAilment)
	private NamedAPIResource category;  //The category of move this move falls under, e.g. damage or ailment. (MoveCategory)
	private Integer min_hits;           //The minimum number of times this move hits. Null if it always only hits once.
	private Integer max_hits;           //The maximum number of times this move hits. Null if it always only hits once.
	private Integer min_turns;          //The minimum number of turns this move continues to take effect. Null if it always only lasts one turn.
	private Integer max_turns;          //The maximum number of turns this move continues to take effect. Null if it always only lasts one turn.
	private Integer drain;              //HP drain (if positive) or Recoil damage (if negative), in percent of damage done.
	private Integer healing;            //The amount of hp gained by the attacking Pokemon, in percent of it's maximum HP.
	private Integer crit_rate;          //Critical hit rate bonus.
	private Integer ailment_chance;     //The likelihood this attack will cause an ailment.
	private Integer flinch_chance;      //The likelihood this attack will cause the target Pokémon to flinch.
	private Integer stat_chance;        //The likelihood this attack will cause a stat change in the target Pokémon.

}
