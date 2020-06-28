package com.xeroxparc.pokedex.data.model.evolutions.chain;

import com.google.gson.annotations.SerializedName;
import com.xeroxparc.pokedex.data.model.evolutions.trigger.EvolutionTrigger;
import com.xeroxparc.pokedex.data.model.item.Item;
import com.xeroxparc.pokedex.data.model.location.Location;
import com.xeroxparc.pokedex.data.model.move.Move;
import com.xeroxparc.pokedex.data.model.pokemon.species.PokemonSpecies;
import com.xeroxparc.pokedex.data.model.pokemon.type.Type;

/**
 * @author Fabio Buracchi
 */
public class EvolutionDetail {

	// The item required to cause evolution this  into Pokémon species.
	@SerializedName("item")
	private Item item;

	// The type of event that triggers evolution  into this Pokémon species.
	@SerializedName("trigger")
	private EvolutionTrigger trigger;

	// The id of the gender of the evolving  Pokémon species must be in order to  evolve into this Pokémon species.
	@SerializedName("gender")
	private Integer gender;

	// The item the evolving Pokémon species  must be holding during the evolution  trigger event to evolve into this Pokémon  species.
	@SerializedName("held_item")
	private Item heldItem;

	// The move that must be known by the  evolving Pokémon species during the  evolution trigger event in order to  evolve into this Pokémon species
	@SerializedName("known_move")
	private Move knownMove;

	// The evolving Pokémon species must know a  move with this type during the evolution  trigger event in order to evolve into  this Pokémon species.
	@SerializedName("known_move_type")
	private Type knownMoveType;

	// The location the evolution must be  triggered at.
	@SerializedName("location")
	private Location location;

	// The minimum required level of the  evolving Pokémon species to evolve into  this Pokémon species.
	@SerializedName("min_level")
	private Integer minLevel;

	// The minimum required level of happiness  the evolving Pokémon species to evolve  into this Pokémon species.
	@SerializedName("min_happiness")
	private Integer minHappiness;

	// The minimum required level of beauty the  evolving Pokémon species to evolve into  this Pokémon species.
	@SerializedName("min_beauty")
	private Integer minBeauty;

	// The minimum required level of affection  the evolving Pokémon species to evolve  into this Pokémon species.
	@SerializedName("min_affection")
	private Integer minAffection;

	// Whether or not it must be raining in the  overworld to cause evolution this Pokémon  species.
	@SerializedName("needs_overworld_rain")
	private Boolean needsOverworldRain;

	// The Pokémon species that must be in the  players party in order for the evolving  Pokémon species to evolve into this  Pokémon species.
	@SerializedName("party_species")
	private PokemonSpecies partySpecies;

	// The player must have a Pokémon of this  type in their party during the evolution  trigger event in order for the evolving  Pokémon species to evolve into this  Pokémon species.
	@SerializedName("party_type")
	private Type partType;

	// The required relation between the  Pokémon's Attack and Defense stats.
	//  1 means Attack > Defense.
	//  0 means Attack = Defense.
	// -1 means Attack < Defense.
	@SerializedName("relative_physical_stats")
	private Integer relativePhysicalStats;

	// The required time of day. Day or night.
	@SerializedName("time_of_day")
	private String timeOfDay;

	// Pokémon species for which this one must  be traded.
	@SerializedName("trade_species")
	private PokemonSpecies tradeSpecies;

	// Whether or not the 3DS needs to be turned  upside-down as this Pokémon levels up.
	@SerializedName("turn_upside_down")
	private Boolean turnUpsideDown;

}
