package com.xeroxparc.pokedex.data.model.pokemon.nature;

import com.google.gson.annotations.SerializedName;
import com.xeroxparc.pokedex.data.model.berry.flavor.BerryFlavor;
import com.xeroxparc.pokedex.data.model.pokemon.stats.Stat;
import com.xeroxparc.pokedex.data.model.utility.common.Name;
import com.xeroxparc.pokedex.data.model.utility.common.NamedApiResource;

import java.util.List;

/**
 * Natures influence how a Pokémon's stats grow. See Bulbapedia for greater detail.
 * 
 * @author Fabio Buracchi
 */
public class Nature extends NamedApiResource {

	// The stat decreased by 10% in Pokémon with this nature.
	@SerializedName("decreased_stat")
	private Stat decreasedStat;

	// The stat increased by 10% in Pokémon with this nature.
	@SerializedName("increased_stat")
	private Stat increasedStat;

	// The flavor hated by Pokémon with this nature.
	@SerializedName("hates_flavor")
	private BerryFlavor hatesFlavor;

	// The flavor liked by Pokémon with this nature.
	@SerializedName("likes_flavor")
	private BerryFlavor likesFlavor;

	// A list of Pokéathlon stats this nature effects and how much it effects them.
	@SerializedName("pokeathlon_stat_changes")
	private List<NatureStatChange> pokeathlonStatChangeList;

	// A list of battle styles and how likely a Pokémon with this nature is to use them in the Battle Palace or Battle Tent.
	@SerializedName("move_battle_style_preferences")
	private List<MoveBattleStylePreference> moveBattleStylePreferenceList;

	// The name of this resource listed in different languages.
	@SerializedName("names")
	private List<Name> nameList;

}
