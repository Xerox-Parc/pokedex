package com.xeroxparc.pokedex.data.model.pokemon;

import com.google.gson.annotations.SerializedName;
import com.xeroxparc.pokedex.data.model.pokemon.stats.Stat;

/**
 * @author Fabio Buracchi
 */
public class PokemonStat {

	// The stat the Pokémon has.
	@SerializedName("stat")
	private Stat stat;

	// The effort points (EV) the Pokémon has in the stat.
	@SerializedName("effort")
	private Integer effort;

	// The base value of the stat.
	@SerializedName("base_stat")
	private Integer baseStat;

}
