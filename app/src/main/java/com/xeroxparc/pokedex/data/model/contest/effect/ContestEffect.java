package com.xeroxparc.pokedex.data.model.contest.effect;

import androidx.room.ColumnInfo;
import androidx.room.Entity;

import com.google.gson.annotations.SerializedName;
import com.xeroxparc.pokedex.data.model.utility.common.ApiResource;
import com.xeroxparc.pokedex.data.model.utility.common.Effect;
import com.xeroxparc.pokedex.data.model.utility.common.FlavorText;

import java.util.List;

/**
 * Contest effects refer to the effects of moves when used in contests.
 *
 * @author Fabio Buracchi
 */
@Entity(tableName = "contest_effect")
public class ContestEffect extends ApiResource {

	// The base number of hearts the user of this move gets.
	@ColumnInfo(name = "appeal")
	@SerializedName("appeal")
	private Integer appeal;

	// The base number of hearts the user's opponent loses.
	@ColumnInfo(name = "jam")
	@SerializedName("jam")
	private Integer jam;

	// The result of this contest effect listed in different languages.
	@ColumnInfo(name = "effect_entries_data")
	@SerializedName("effect_entries")
	private List<Effect> effectList;

	// The flavor text of this contest effect listed in different languages.
	@ColumnInfo(name = "flavor_text_entries_data")
	@SerializedName("flavor_text_entries")
	private List<FlavorText> flavorTextList;

	public Integer getAppeal() {
		return appeal;
	}

	public void setAppeal(Integer appeal) {
		this.appeal = appeal;
	}

	public Integer getJam() {
		return jam;
	}

	public void setJam(Integer jam) {
		this.jam = jam;
	}

	public List<Effect> getEffectList() {
		return effectList;
	}

	public void setEffectList(List<Effect> effectList) {
		this.effectList = effectList;
	}

	public List<FlavorText> getFlavorTextList() {
		return flavorTextList;
	}

	public void setFlavorTextList(List<FlavorText> flavorTextList) {
		this.flavorTextList = flavorTextList;
	}

}
