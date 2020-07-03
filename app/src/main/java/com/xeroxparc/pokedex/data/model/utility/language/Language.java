package com.xeroxparc.pokedex.data.model.utility.language;

import androidx.room.ColumnInfo;
import androidx.room.Entity;

import com.google.gson.annotations.SerializedName;
import com.xeroxparc.pokedex.data.model.utility.common.Name;
import com.xeroxparc.pokedex.data.model.utility.common.NamedApiResource;

import java.util.List;

/**
 * Languages for translations of API resource information.
 *
 * @author Fabio Buracchi
 */
@Entity(tableName = "language")
public class Language extends NamedApiResource {

	// Whether or not the games are published in this language.
	@ColumnInfo(name = "official")
	@SerializedName("official")
	private Boolean official;

	// The two-letter code of the country where this language is spoken. Note that it is not unique.
	@ColumnInfo(name = "iso639")
	@SerializedName("iso639")
	private String iso639;

	// The two-letter code of the language. Note that it is not unique.
	@ColumnInfo(name = "iso3166")
	@SerializedName("iso3166")
	private String iso3166;

	// The name of this resource listed in different languages.
	@ColumnInfo(name = "names_data")
	@SerializedName("names")
	private List<Name> nameList;

	public Boolean getOfficial() {
		return official;
	}

	public void setOfficial(Boolean official) {
		this.official = official;
	}

	public String getIso639() {
		return iso639;
	}

	public void setIso639(String iso639) {
		this.iso639 = iso639;
	}

	public String getIso3166() {
		return iso3166;
	}

	public void setIso3166(String iso3166) {
		this.iso3166 = iso3166;
	}

	public List<Name> getNameList() {
		return nameList;
	}

	public void setNameList(List<Name> nameList) {
		this.nameList = nameList;
	}

}
