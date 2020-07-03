package com.xeroxparc.pokedex.data.model.contest.supereffect;

import androidx.room.ColumnInfo;
import androidx.room.Entity;

import com.google.gson.annotations.SerializedName;
import com.xeroxparc.pokedex.data.model.move.Move;
import com.xeroxparc.pokedex.data.model.utility.common.ApiResource;
import com.xeroxparc.pokedex.data.model.utility.common.FlavorText;

import java.util.List;

/**
 * Super contest effects refer to the effects of moves when used in super contests.
 * 
 * @author Fabio Buracchi
 */
@Entity(tableName = "super_contest_effect")
public class SuperContestEffect extends ApiResource {

	// The level of appeal this super contest effect has.
	@ColumnInfo(name = "appeal")
	@SerializedName("appeal")
	private Integer appeal;

	// The flavor text of this super contest effect listed in different languages.
	@ColumnInfo(name = "flavor_text_entries_data")
	@SerializedName("flavor_text_entries")
	private List<FlavorText> flavorTextList;

	// A list of moves that have the effect when used in super contests.
	@ColumnInfo(name = "moves_data")
	@SerializedName("moves")
	private List<Move> moveList;

	public Integer getAppeal() {
		return appeal;
	}

	public void setAppeal(Integer appeal) {
		this.appeal = appeal;
	}

	public List<FlavorText> getFlavorTextList() {
		return flavorTextList;
	}

	public void setFlavorTextList(List<FlavorText> flavorTextList) {
		this.flavorTextList = flavorTextList;
	}

	public List<Move> getMoveList() {
		return moveList;
	}

	public void setMoveList(List<Move> moveList) {
		this.moveList = moveList;
	}

}
