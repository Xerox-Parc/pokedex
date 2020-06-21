package com.xeroxparc.pokedex.data.entity.pokemon;

import com.xeroxparc.pokedex.data.entity.utility.Name;
import com.xeroxparc.pokedex.data.entity.utility.NamedAPIResource;

import java.util.List;

public class Nature {

	//Natures influence how a Pokémon's stats grow. See Bulbapedia for greater detail.

	private Integer id;                                                         //The identifier for this resource.
	private String name;                                                        //The name for this resource.
	private NamedAPIResource decreased_stat;                                    //The stat decreased by 10% in Pokémon with this nature. (Stat)
	private NamedAPIResource increased_stat;                                    //The stat increased by 10% in Pokémon with this nature. (Stat)
	private NamedAPIResource hates_flavor;                                      //The flavor hated by Pokémon with this nature. (BerryFlavor)
	private NamedAPIResource likes_flavor;                                      //The flavor liked by Pokémon with this nature. (BerryFlavor)
	private List<NatureStatChange> pokeathlon_stat_changes;                     //A list of Pokéathlon stats this nature effects and how much it effects them.
	private List<MoveBattleStylePreference> move_battle_style_preferences;      //A list of battle styles and how likely a Pokémon with this nature is to use them in the Battle Palace or Battle Tent.
	private List<Name> names;                                                   //The name of this resource listed in different languages.

}
