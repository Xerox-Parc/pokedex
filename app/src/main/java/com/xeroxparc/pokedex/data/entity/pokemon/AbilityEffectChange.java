package com.xeroxparc.pokedex.data.entity.pokemon;

import com.xeroxparc.pokedex.data.entity.utility.Effect;
import com.xeroxparc.pokedex.data.entity.utility.NamedAPIResource;

import java.util.List;

public class AbilityEffectChange {
	private List<Effect> effect_entries;        //The previous effect of this ability listed in different languages.
	private NamedAPIResource version_group;     //The version group in which the previous effect of this ability originated. (VersionGroup)
}
