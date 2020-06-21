package com.xeroxparc.pokedex.data.entity.move;

import com.xeroxparc.pokedex.data.entity.utility.common.NamedAPIResource;

import java.util.List;

public class ContestComboDetail {

	private List<NamedAPIResource> use_before;  //A list of moves to use before this move. (Move)
	private List<NamedAPIResource> use_after;   //A list of moves to use after this move. (Move)

}
