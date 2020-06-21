package com.xeroxparc.pokedex.data.entity.pokemon.species;

import com.xeroxparc.pokedex.data.entity.utility.common.APIResource;
import com.xeroxparc.pokedex.data.entity.utility.common.Description;
import com.xeroxparc.pokedex.data.entity.utility.common.FlavorText;
import com.xeroxparc.pokedex.data.entity.utility.common.Name;
import com.xeroxparc.pokedex.data.entity.utility.common.NamedAPIResource;

import java.util.List;

public class PokemonSpecies {

	//A Pokémon Species forms the basis for at least one Pokémon. Attributes of a Pokémon species are shared across all varieties of Pokémon within the species. A good example is Wormadam; Wormadam is the species which can be found in three different varieties, Wormadam-Trash, Wormadam-Sandy and Wormadam-Plant.

	private Integer id;                                     //The identifier for this resource.
	private String name;                                    //The name for this resource.
	private Integer order;                                  //The order in which species should be sorted. Based on National Dex order, except families are grouped together and sorted by stage.
	private Integer gender_rate;                            //The chance of this Pokémon being female, in eighths; or -1 for genderless.
	private Integer capture_rate;                           //The base capture rate; up to 255. The higher the number, the easier the catch.
	private Integer base_happiness;                         //The happiness when caught by a normal Pokéball; up to 255. The higher the number, the happier the Pokémon.
	private Integer weight;                                 //The weight of this Pokémon in hectograms.
	private Boolean is_baby;                                //Whether or not this is a baby Pokémon.
	private Integer hatch_counter;                          //Initial hatch counter: one must walk 255 × (hatch_counter + 1) steps before this Pokémon's egg hatches, unless utilizing bonuses like Flame Body's.
	private Boolean has_gender_differences;                 //Whether or not this Pokémon has visual gender differences.
	private Boolean forms_switchable;                       //Whether or not this Pokémon has multiple forms and can switch between them.
	private NamedAPIResource growth_rate;                   //The rate at which this Pokémon species gains levels. (GrowthRate)
	private List<PokemonSpeciesDexEntry> pokedex_numbers;   //A list of Pokedexes and the indexes reserved within them for this Pokémon species.
	private List<NamedAPIResource> egg_groups;              //A list of egg groups this Pokémon species is a member of. (EggGroup)
	private NamedAPIResource color;                         //The color of this Pokémon for Pokédex search. (PokemonColor)
	private NamedAPIResource shape;                         //The shape of this Pokémon for Pokédex search. (PokemonShape)
	private NamedAPIResource evolves_from_species;          //The Pokémon species that evolves into this Pokemon_species. (PokemonSpecies)
	private APIResource evolution_chain;                    //The evolution chain this Pokémon species is a member of. (EvolutionChain)
	private NamedAPIResource habitat;                       //The habitat this Pokémon species can be encountered in. (PokemonHabitat)
	private NamedAPIResource generation;                    //The generation this Pokémon species was introduced in. (Generation)
	private List<Name> names;                               //The name of this resource listed in different languages.
	private List<PalParkEncounterArea> pal_park_encounters; //A list of encounters that can be had with this Pokémon species in pal park.
	private List<FlavorText> flavor_text_entries;           //A list of flavor text entries for this Pokémon species.
	private List<Description> form_descriptions;            //Descriptions of different forms Pokémon take on within the Pokémon species.
	private List<Genus> genera;                             //The genus of this Pokémon species listed in multiple languages.
	private List<PokemonSpeciesVariety> varieties;          //A list of the Pokémon that exist within this Pokémon species.

}
