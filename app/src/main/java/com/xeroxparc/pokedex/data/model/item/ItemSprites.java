package com.xeroxparc.pokedex.data.model.item;

import com.google.gson.annotations.SerializedName;

/**
 * @author Fabio Buracchi
 */
public class ItemSprites {

	// The default depiction of this item.
	@SerializedName("default")
	private String url;

	public String getUrl() {
		return url;
	}

}
