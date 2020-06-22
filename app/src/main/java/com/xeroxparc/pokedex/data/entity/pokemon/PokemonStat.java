package com.xeroxparc.pokedex.data.entity.pokemon;

import com.google.gson.annotations.SerializedName;
import com.xeroxparc.pokedex.data.entity.utility.common.NamedAPIResource;

public class PokemonStat {

	@SerializedName("stat")
	private NamedAPIResource statResource;          // The stat the Pokémon has.
													// (Stat)

	@SerializedName("effort")
	private Integer effort;                         // The effort points (EV) the Pokémon has in
													// the stat.

	@SerializedName("base_stat")
	private Integer baseStat;                       // The base value of the stat.

}
