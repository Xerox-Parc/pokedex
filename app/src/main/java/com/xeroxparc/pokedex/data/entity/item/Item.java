package com.xeroxparc.pokedex.data.entity.item;

import com.xeroxparc.pokedex.data.entity.utility.APIResource;
import com.xeroxparc.pokedex.data.entity.utility.GenerationGameIndex;
import com.xeroxparc.pokedex.data.entity.utility.MachineVersionDetail;
import com.xeroxparc.pokedex.data.entity.utility.Name;
import com.xeroxparc.pokedex.data.entity.utility.NamedAPIResource;
import com.xeroxparc.pokedex.data.entity.utility.VerboseEffect;
import com.xeroxparc.pokedex.data.entity.utility.VersionGroupFlavorText;

import java.util.List;

public class Item {

	//An item is an object in the games which the player can pick up, keep in their bag, and use in some manner. They have various uses, including healing, powering up, helping catch Pokémon, or to access a new area.

	private Integer id;                                         //The identifier for this resource.
	private String name;                                        //The name for this resource.
	private Integer cost;                                       //The price of this item in stores.
	private Integer fling_power;                                //The power of the move Fling when used with this item.
	private NamedAPIResource fling_effect;                      //The effect of the move Fling when used with this item. (ItemFlingEffect)
	private List<NamedAPIResource> attributes;                  //A list of attributes this item has. (ItemAttribute)
	private NamedAPIResource category;                          //The category of items this item falls into. (ItemCategory)
	private List<VerboseEffect> effect_entries;                 //The effect of this ability listed in different languages.
	private List<VersionGroupFlavorText> flavor_text_entries;   //The flavor text of this ability listed in different languages.
	private List<GenerationGameIndex> game_indices;             //A list of game indices relevent to this item by generation.
	private List<Name> names;                                   //The name of this item listed in different languages.
	private ItemSprites sprites;                                //A set of sprites used to depict this item in the game.
	private List<ItemHolderPokemon> held_by_pokemon;            //A list of Pokémon that might be found in the wild holding this item.
	private APIResource baby_trigger_for;                       //An evolution chain this item requires to produce a bay during mating. (EvolutionChain)
	private List<MachineVersionDetail> machines;                //A list of the machines related to this item.

}
