package com.xeroxparc.pokedex.data.model.pokemon.type;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * @author Fabio Buracchi
 */
public class TypeRelations {

	// A list of types this type has no effect on.
	@SerializedName("no_damage_to")
	private List<Type> noDamageToList;

	// A list of types this type is not very effect against.
	@SerializedName("half_damage_to")
	private List<Type> halfDamageToList;

	// A list of types this type is very effect against.
	@SerializedName("double_damage_to")
	private List<Type> doubleDamageToList;

	// A list of types that have no effect on this type.
	@SerializedName("no_damage_from")
	private List<Type> noDamageFromList;

	// A list of types that are not very effective against this type.
	@SerializedName("half_damage_from")
	private List<Type> halfDamageFromList;

	// A list of types that are very effective against this type.
	@SerializedName("double_damage_from")
	private List<Type> doubleDamageFromList;

}
