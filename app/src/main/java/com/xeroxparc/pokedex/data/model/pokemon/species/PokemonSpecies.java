package com.xeroxparc.pokedex.data.model.pokemon.species;

import com.google.gson.annotations.SerializedName;
import com.xeroxparc.pokedex.data.model.evolutions.chain.EvolutionChain;
import com.xeroxparc.pokedex.data.model.game.generation.Generation;
import com.xeroxparc.pokedex.data.model.pokemon.color.PokemonColor;
import com.xeroxparc.pokedex.data.model.pokemon.egggroup.EggGroup;
import com.xeroxparc.pokedex.data.model.pokemon.growthrate.GrowthRate;
import com.xeroxparc.pokedex.data.model.pokemon.habitat.PokemonHabitat;
import com.xeroxparc.pokedex.data.model.pokemon.shape.PokemonShape;
import com.xeroxparc.pokedex.data.model.utility.common.Description;
import com.xeroxparc.pokedex.data.model.utility.common.FlavorText;
import com.xeroxparc.pokedex.data.model.utility.common.Name;
import com.xeroxparc.pokedex.data.model.utility.common.NamedApiResource;

import java.util.List;

/**
 * A Pokémon Species forms the basis for at least one Pokémon. Attributes of a Pokémon species
 * are shared across all varieties of Pokémon within the species.
 * A good example is Wormadam; Wormadam is the species which can be found in three different
 * varieties, Wormadam-Trash, Wormadam-Sandy and Wormadam-Plant.
 * 	
 * @author Fabio Buracchi
 */
public class PokemonSpecies extends NamedApiResource {
	
	// The order in which species should be sorted. Based on National Dex order, except families are grouped together and sorted by stage.
	@SerializedName("order")
	private Integer order;
	
	// The chance of this Pokémon being female, in eighths, or -1 for genderless.
	@SerializedName("gender_rate")
	private Integer genderRate;
	
	// The base capture rate, up to 255. The higher the number, the easier the catch.
	@SerializedName("capture_rate")
	private Integer captureRate;
	
	// The happiness when caught by a normal Pokéball; up to 255. The higher the number, the happier the Pokémon.
	@SerializedName("base_happiness")
	private Integer baseHappiness;
	
	// Whether or not this is a baby Pokémon.
	@SerializedName("is_baby")
	private Boolean isBaby;
	
	// Initial hatch counter: one must walk 255 × (hatch_counter + 1) steps before this Pokémon's egg hatches, unless utilizing bonuses like Flame Body's.
	@SerializedName("hatch_counter")
	private Integer hatchCounter;
	
	// Whether or not this Pokémon has visual gender differences
	@SerializedName("has_gender_differences")
	private Boolean hasGenderDifferences;
	
	// Whether or not this Pokémon has multiple forms and can switch between them.
	@SerializedName("forms_switchable")
	private Boolean formsSwitchable;
	
	// The rate at which this Pokémon species gains levels.
	@SerializedName("growth_rate")
	private GrowthRate growthRate;
	
	// A list of Pokedexes and the indexes reserved within them for this Pokémon species.
	@SerializedName("pokedex_numbers")
	private List<PokemonSpeciesDexEntry> pokedexNumberList;
	
	// A list of egg groups this Pokémon species is member of.
	@SerializedName("egg_groups")
	private List<EggGroup> eggGroupsList;
	
	// The color of this Pokémon for Pokédex search.
	@SerializedName("color")
	private PokemonColor color;
	
	// The shape of this Pokémon for Pokédex search.
	@SerializedName("shape")
	private PokemonShape shape;
	
	// The Pokémon species that evolves into this Pokemons species.
	@SerializedName("evolves_from_species")
	private PokemonSpecies evolvesFromSpecies;
	
	// The evolution chain this Pokémon species is member of.
	@SerializedName("evolution_chain")
	private EvolutionChain evolutionChain;
	
	// The habitat this Pokémon species can be encountered in.
	@SerializedName("habitat")
	private PokemonHabitat habitat;
	
	// The generation this Pokémon species was introduced in.
	@SerializedName("generation")
	private Generation generation;
	
	// The name of this resource listed in different languages.
	@SerializedName("names")
	private List<Name> nameList;
	
	// A list of encounters that can be had with this Pokémon species in pal park.
	@SerializedName("pal_park_encounters")
	private List<PalParkEncounterArea> palParkEncounterAreaList;
	
	// A list of flavor text entries for this Pokémon species.
	@SerializedName("flavor_text_entries")
	private List<FlavorText> flavorTextEntryList;
	
	// Descriptions of different forms Pokémon take on within the Pokémon species.
	@SerializedName("form_descriptions")
	private List<Description> formDescriptionList;
	
	// The genus of this Pokémon species listed in multiple languages.
	@SerializedName("genera")
	private List<Genus> genusList;
	
	// A list of the Pokémon that exist within this Pokémon species.
	@SerializedName("varieties")
	private List<PokemonSpeciesVariety> varietyList;
	
}
