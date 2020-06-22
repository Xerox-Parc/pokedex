package com.xeroxparc.pokedex.data.entity.pokemon.nature;

import com.google.gson.annotations.SerializedName;
import com.xeroxparc.pokedex.data.entity.utility.common.Name;
import com.xeroxparc.pokedex.data.entity.utility.common.NamedAPIResource;

import java.util.List;

public class Nature {

	/*
		Natures influence how a Pokémon's stats grow. See Bulbapedia for greater detail.
	 */
	
	@SerializedName("id")
	private Integer id;                                                     // The identifier for 
																			// this resource.

	@SerializedName("name")
	private String name;                                                    // The name for this
																			// resource.

	@SerializedName("decreased_stat")
	private NamedAPIResource decreasedStatResource;                         // The stat decreased
																			// by 10% in Pokémon
																			// with this nature.
																			// (Stat)

	@SerializedName("increased_stat")
	private NamedAPIResource increasedStatResource;                         // The stat increased
																			// by 10% in Pokémon
																			// with this nature.
																			// (Stat)

	@SerializedName("hates_flavor")
	private NamedAPIResource hatesFlavorResource;                           // The flavor hated by
																			// Pokémon with this
																			// nature.
																			// (BerryFlavor)

	@SerializedName("likes_flavor")
	private NamedAPIResource likesFlavorResource;                           // The flavor liked by
																			// Pokémon with this
																			// nature.
																			// (BerryFlavor)

	@SerializedName("pokeathlon_stat_changes")
	private List<NatureStatChange> pokeathlonStatChangeList;                // A list of Pokéathlon
																			// stats this nature
																			// effects and how much
																			// it effects them.

	@SerializedName("move_battle_style_preferences")
	private List<MoveBattleStylePreference> moveBattleStylePreferenceList;  // A list of battle
																			// styles and how likely
																			// a Pokémon with this
																			// nature is to use them
																			// in the Battle Palace
																			// or Battle Tent.

	@SerializedName("names")
	private List<Name> nameList;                                            // The name of this
																			// resource listed in
																			// different languages.

}
