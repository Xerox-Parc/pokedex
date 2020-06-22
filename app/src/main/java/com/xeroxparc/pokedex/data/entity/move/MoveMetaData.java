package com.xeroxparc.pokedex.data.entity.move;

import com.google.gson.annotations.SerializedName;
import com.xeroxparc.pokedex.data.entity.utility.common.NamedAPIResource;

public class MoveMetaData {

	@SerializedName("ailment")
	private NamedAPIResource ailmentResource;       // The status ailment this move inflicts on its
													// target.
													// (MoveAilment)

	@SerializedName("category")
	private NamedAPIResource categoryResource;      // The category of move this move falls under,
													// e.g. damage or ailment.
													// (MoveCategory)

	@SerializedName("min_hits")
	private Integer minHits;                        // The minimum number of times this move hits.
													// Null if it always only hits once.

	@SerializedName("max_hits")
	private Integer maxHits;                        // The maximum number of times this move hits.
													// Null if it always only hits once.

	@SerializedName("min_turns")
	private Integer minTurns;                       // The minimum number of turns this move
													// continues to take effect.
													// Null if it always only lasts one turn.

	@SerializedName("max_turns")
	private Integer maxTurns;                       // The maximum number of turns this move
													// continues to take effect.
													// Null if it always only lasts one turn.

	@SerializedName("drain")
	private Integer drain;                          // HP drain (if positive) or Recoil damage
													// (if negative), in percent of damage done.

	@SerializedName("healing")
	private Integer healing;                        // The amount of hp gained by the attacking
													// Pokemon, in percent of it's maximum HP.

	@SerializedName("crit_rate")
	private Integer critRate;                       // Critical hit rate bonus.

	@SerializedName("ailment_chance")
	private Integer ailmentChance;                  // The likelihood this attack will cause an
													// ailment.

	@SerializedName("flinch_chance")
	private Integer flinchChance;                   // The likelihood this attack will cause the
													// target Pokémon to flinch.

	@SerializedName("stat_chance")
	private Integer statChance;                     // The likelihood this attack will cause a stat
													// change in the target Pokémon.

}
