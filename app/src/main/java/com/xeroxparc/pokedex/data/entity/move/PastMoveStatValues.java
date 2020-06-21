package com.xeroxparc.pokedex.data.entity.move;

import com.xeroxparc.pokedex.data.entity.utility.common.NamedAPIResource;
import com.xeroxparc.pokedex.data.entity.utility.common.VerboseEffect;

import java.util.List;

public class PastMoveStatValues {

	private Integer accuracy;                       //The percent value of how likely this move is to be successful.
	private Integer effect_chance;                  //The percent value of how likely it is this moves effect will take effect.
	private Integer power;                          //The base power of this move with a value of 0 if it does not have a base power.
	private Integer pp;                             //Power points. The number of times this move can be used.
	private List<VerboseEffect> effect_entries;     //The effect of this move listed in different languages.
	private NamedAPIResource type;                  //The elemental type of this move. (Type)
	private NamedAPIResource version_group;         //The version group in which these move stat values were in effect. (VersionGroup)

}
