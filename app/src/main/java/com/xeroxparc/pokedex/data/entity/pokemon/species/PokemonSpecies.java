package com.xeroxparc.pokedex.data.entity.pokemon.species;

import com.google.gson.annotations.SerializedName;
import com.xeroxparc.pokedex.data.entity.utility.common.APIResource;
import com.xeroxparc.pokedex.data.entity.utility.common.Description;
import com.xeroxparc.pokedex.data.entity.utility.common.FlavorText;
import com.xeroxparc.pokedex.data.entity.utility.common.Name;
import com.xeroxparc.pokedex.data.entity.utility.common.NamedAPIResource;

import java.util.List;

public class PokemonSpecies {

	/*
		A Pokémon Species forms the basis for at least one Pokémon. Attributes of a Pokémon species
		are shared across all varieties of Pokémon within the species.
		A good example is Wormadam; Wormadam is the species which can be found in three different
		varieties, Wormadam-Trash, Wormadam-Sandy and Wormadam-Plant.
	 */

	
	@SerializedName("id")
	private Integer id;                                             // The identifier for this
																	// resource.
	
	@SerializedName("name")
	private String name;                                            // The name for this resource.
	
	@SerializedName("order")
	private Integer order;                                          // The order in which species
																	// should be sorted. Based on
																	// National Dex order, except
																	// families are grouped together
																	// and sorted by stage.
	
	@SerializedName("gender_rate")
	private Integer genderRate;                                     // The chance of this Pokémon
																	// being female, in eighths,
																	// or -1 for genderless.
	
	@SerializedName("capture_rate")
	private Integer captureRate;                                    // The base capture rate,
																	// up to 255. The higher the
																	// number, the easier the catch.
	
	@SerializedName("base_happiness")
	private Integer baseHappiness;                                  // The happiness when caught by
																	// a normal Pokéball; up to 255.
																	// The higher the number, the
																	// happier the Pokémon.

	@SerializedName("is_baby")
	private Boolean isBaby;                                         // Whether or not this is a baby
																	// Pokémon.
	
	@SerializedName("hatch_counter")
	private Integer hatchCounter;                                   // Initial hatch counter:
																	// one must walk
																	// 255 × (hatch_counter + 1)
																	// steps before this Pokémon's
																	// egg hatches, unless utilizing
																	// bonuses like Flame Body's.
	
	@SerializedName("has_gender_differences")
	private Boolean hasGenderDifferences;                           // Whether or not this Pokémon
																	// has visual gender differences
	
	@SerializedName("forms_switchable")
	private Boolean formsSwitchable;                                // Whether or not this Pokémon
																	// has multiple forms and can
																	// switch between them.
	
	@SerializedName("growth_rate")
	private NamedAPIResource growthRateResource;                    // The rate at which this
																	// Pokémon species gains levels.
																	// (GrowthRate)
	
	@SerializedName("pokedex_numbers")
	private List<PokemonSpeciesDexEntry> pokedexNumberList;         // A list of Pokedexes and the
																	// indexes reserved within them
																	// for this Pokémon species.
	
	@SerializedName("egg_groups")
	private List<NamedAPIResource> eggGroupsListResource;           // A list of egg groups this
																	// Pokémon species is member of.
																	// (EggGroup)
	
	@SerializedName("color")
	private NamedAPIResource colorResource;                         // The color of this Pokémon
																	// for Pokédex search.
																	// (PokemonColor)
	
	@SerializedName("shape")
	private NamedAPIResource shapeResource;                         // The shape of this Pokémon for
																	// Pokédex search.
																	// (PokemonShape)
	
	@SerializedName("evolves_from_species")
	private NamedAPIResource evolvesFromSpeciesResource;            // The Pokémon species that
																	// evolves into this Pokemons
																	// species.
																	// (PokemonSpecies)
	
	@SerializedName("evolution_chain")
	private APIResource evolutionChainResource;                     // The evolution chain this
																	// Pokémon species is member of.
																	// (EvolutionChain)
	
	@SerializedName("habitat")
	private NamedAPIResource habitatResource;                       // The habitat this Pokémon
																	// species can be encountered in
																	// (PokemonHabitat)
	
	@SerializedName("generation")
	private NamedAPIResource generationResource;                    // The generation this Pokémon
																	// species was introduced in.
																	// (Generation)
	
	@SerializedName("names")
	private List<Name> nameList;                                    // The name of this resource
																	// listed in different languages
	
	@SerializedName("pal_park_encounters")
	private List<PalParkEncounterArea> palParkEncounterAreaList;    // A list of encounters that can
																	// be had with this Pokémon
																	// species in pal park.
	
	@SerializedName("flavor_text_entries")
	private List<FlavorText> flavorTextEntryList;                   // A list of flavor text entries
																	// for this Pokémon species.
	
	@SerializedName("form_descriptions")
	private List<Description> formDescriptionList;                  // Descriptions of different
																	// forms Pokémon take on within
																	// the Pokémon species.
	
	@SerializedName("genera")
	private List<Genus> genusList;                                  // The genus of this Pokémon
																	// species listed in multiple
																	// languages.
	
	@SerializedName("varieties")
	private List<PokemonSpeciesVariety> varietyList;                // A list of the Pokémon that
																	// exist within this Pokémon
																	// species.

}
