package com.xeroxparc.pokedex.data.entity.evolutions.chain;

import com.xeroxparc.pokedex.data.entity.utility.common.NamedAPIResource;

public class EvolutionDetail {

	private NamedAPIResource item;              //The item required to cause evolution this into Pokémon species. (Item)
	private NamedAPIResource trigger;           //The type of event that triggers evolution into this Pokémon species. (EvolutionTrigger)
	private Integer gender;                     //All details regarding the specific details of the referenced Pokémon species evolution.
	private NamedAPIResource held_item;         //The item the evolving Pokémon species must be holding during the evolution trigger event to evolve into this Pokémon species. (Item)
	private NamedAPIResource known_move;        //The move that must be known by the evolving Pokémon species during the evolution trigger event in order to evolve into this Pokémon species (Move)
	private NamedAPIResource known_move_type;   //The evolving Pokémon species must know a move with this type during the evolution trigger event in order to evolve into this Pokémon species. (Type)
	private NamedAPIResource location;          //The location the evolution must be triggered at. (Location)
	private Integer min_level;                  //The minimum required level of the evolving Pokémon species to evolve into this Pokémon species.
	private Integer min_happiness;              //The minimum required level of happiness the evolving Pokémon species to evolve into this Pokémon species.
	private Integer min_beauty;                 //The minimum required level of beauty the evolving Pokémon species to evolve into this Pokémon species.
	private Integer min_affection;              //The minimum required level of affection the evolving Pokémon species to evolve into this Pokémon species.
	private Boolean needs_overworld_rain;       //Whether or not it must be raining in the overworld to cause evolution this Pokémon species.
	private NamedAPIResource party_species;     //The Pokémon species that must be in the players party in order for the evolving Pokémon species to evolve into this Pokémon species. (PokemonSpecies)
	private NamedAPIResource party_type;        //The player must have a Pokémon of this type in their party during the evolution trigger event in order for the evolving Pokémon species to evolve into this Pokémon species. (Type)
	private Integer relative_physical_stats;    //The required relation between the Pokémon's Attack and Defense stats. 1 means Attack > Defense. 0 means Attack = Defense. -1 means Attack < Defense.
	private String time_of_day;                 //The required time of day. Day or night.
	private NamedAPIResource trade_species;     //Pokémon species for which this one must be traded. (PokemonSpecies)
	private Boolean turn_upside_down;           //Whether or not the 3DS needs to be turned upside-down as this Pokémon levels up.

}
