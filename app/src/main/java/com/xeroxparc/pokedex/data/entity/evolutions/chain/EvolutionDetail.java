package com.xeroxparc.pokedex.data.entity.evolutions.chain;

import com.google.gson.annotations.SerializedName;
import com.xeroxparc.pokedex.data.entity.utility.common.NamedAPIResource;

public class EvolutionDetail {

	@SerializedName("item")
	private NamedAPIResource itemResource;              // The item required to cause evolution this
														// into Pokémon species.
														// (Item)

	@SerializedName("trigger")
	private NamedAPIResource triggerResource;           // The type of event that triggers evolution
														// into this Pokémon species.
														// (EvolutionTrigger)

	@SerializedName("gender")
	private Integer gender;                             // The id of the gender of the evolving
														// Pokémon species must be in order to
														// evolve into this Pokémon species.

	@SerializedName("held_item")
	private NamedAPIResource heldItemResource;          // The item the evolving Pokémon species
														// must be holding during the evolution
														// trigger event to evolve into this Pokémon
														// species.
														// (Item)

	@SerializedName("known_move")
	private NamedAPIResource knownMoveResource;         // The move that must be known by the
														// evolving Pokémon species during the
														// evolution trigger event in order to
														// evolve into this Pokémon species
														// (Move)

	@SerializedName("known_move_type")
	private NamedAPIResource knownMoveTypeResource;     // The evolving Pokémon species must know a
														// move with this type during the evolution
														// trigger event in order to evolve into
														// this Pokémon species.
														// (Type)

	@SerializedName("location")
	private NamedAPIResource locationResource;          // The location the evolution must be
														// triggered at.
														// (Location)

	@SerializedName("min_level")
	private Integer minLevel;                           // The minimum required level of the
														// evolving Pokémon species to evolve into
														// this Pokémon species.

	@SerializedName("min_happiness")
	private Integer minHappiness;                       // The minimum required level of happiness
														// the evolving Pokémon species to evolve
														// into this Pokémon species.

	@SerializedName("min_beauty")
	private Integer minBeauty;                          // The minimum required level of beauty the
														// evolving Pokémon species to evolve into
														// this Pokémon species.

	@SerializedName("min_affection")
	private Integer minAffection;                       // The minimum required level of affection
														// the evolving Pokémon species to evolve
														// into this Pokémon species.

	@SerializedName("needs_overworld_rain")
	private Boolean needsOverworldRain;                 // Whether or not it must be raining in the
														// overworld to cause evolution this Pokémon
														// species.

	@SerializedName("party_species")
	private NamedAPIResource partySpeciesResource;      // The Pokémon species that must be in the
														// players party in order for the evolving
														// Pokémon species to evolve into this
														// Pokémon species.
														// (PokemonSpecies)

	@SerializedName("party_type")
	private NamedAPIResource partTypeResource;          // The player must have a Pokémon of this
														// type in their party during the evolution
														// trigger event in order for the evolving
														// Pokémon species to evolve into this
														// Pokémon species.
														// (Type)

	@SerializedName("relative_physical_stats")
	private Integer relativePhysicalStats;              // The required relation between the
														// Pokémon's Attack and Defense stats.
														//  1 means Attack > Defense.
														//  0 means Attack = Defense.
														// -1 means Attack < Defense.

	@SerializedName("time_of_day")
	private String timeOfDay;                           // The required time of day. Day or night.

	@SerializedName("trade_species")
	private NamedAPIResource tradeSpeciesResource;      // Pokémon species for which this one must
														// be traded.
														// (PokemonSpecies)

	@SerializedName("turn_upside_down")
	private Boolean turnUpsideDown;                     // Whether or not the 3DS needs to be turned
														// upside-down as this Pokémon levels up.

}
