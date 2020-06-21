package com.xeroxparc.pokedex.data.entity.pokemon;

import java.util.List;

public class Characteristic {

	//Characteristics indicate which stat contains a Pokémon's highest IV. A Pokémon's Characteristic is determined by the remainder of its highest IV divided by 5 (gene_modulo). Check out Bulbapedia for greater detail.

	private Integer id;                     //The identifier for this resource.
	private Integer gene_modulo;            //The remainder of the highest stat/IV divided by 5.
	private List<Integer> possible_values;  //The possible values of the highest stat that would result in a Pokémon recieving this characteristic when divided by 5.

}
