package com.xeroxparc.pokedex.data.model.move;

import com.google.gson.annotations.SerializedName;
import com.xeroxparc.pokedex.data.model.move.ailment.MoveAilment;
import com.xeroxparc.pokedex.data.model.move.categoty.MoveCategory;

/**
 * @author Fabio Buracchi
 */
public class MoveMetaData {

	// The status ailment this move inflicts on its target.
	@SerializedName("ailment")
	private MoveAilment ailment;

	// The category of move this move falls under, e.g. damage or ailment.
	@SerializedName("category")
	private MoveCategory category;

	// The minimum number of times this move hits. Null if it always only hits once.
	@SerializedName("min_hits")
	private Integer minHits;

	// The maximum number of times this move hits. Null if it always only hits once.
	@SerializedName("max_hits")
	private Integer maxHits;

	// The minimum number of turns this move continues to take effect. Null if it always only lasts one turn.
	@SerializedName("min_turns")
	private Integer minTurns;

	// The maximum number of turns this move continues to take effect. Null if it always only lasts one turn.
	@SerializedName("max_turns")
	private Integer maxTurns;

	// HP drain (if positive) or Recoil damage (if negative), in percent of damage done.
	@SerializedName("drain")
	private Integer drain;

	// The amount of hp gained by the attacking Pokemon, in percent of it's maximum HP.
	@SerializedName("healing")
	private Integer healing;

	// Critical hit rate bonus.
	@SerializedName("crit_rate")
	private Integer critRate;

	// The likelihood this attack will cause an ailment.
	@SerializedName("ailment_chance")
	private Integer ailmentChance;

	// The likelihood this attack will cause the target Pokémon to flinch.
	@SerializedName("flinch_chance")
	private Integer flinchChance;

	// The likelihood this attack will cause a stat change in the target Pokémon.
	@SerializedName("stat_chance")
	private Integer statChance;

}
