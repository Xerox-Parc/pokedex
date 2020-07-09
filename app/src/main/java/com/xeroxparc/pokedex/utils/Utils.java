package com.xeroxparc.pokedex.utils;

import android.content.Context;
import android.widget.Toast;

import com.xeroxparc.pokedex.R;
import com.xeroxparc.pokedex.data.model.pokemon.species.PokemonSpecies;
import com.xeroxparc.pokedex.data.model.pokemon.species.PokemonSpeciesVariety;
import com.xeroxparc.pokedex.ui.egggroups.constants.EggGroupType;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Utility class.
 * Provides a set of useful method to other classes.
 *
 * @author Fabio Buracchi
 */
public class Utils {
	private Utils() {}

	@Nullable
	public static Integer urlToId(@NonNull String url) {
		Matcher matcher = Pattern.compile("/-?[0-9]+/$").matcher(url);
		return matcher.find() ?
				Integer.valueOf(matcher.group().replace("/", "")) :
				null;
	}

	public static void noInternetConnectionWarning(Context context){
		Toast.makeText(context, R.string.message_no_internet_connection,Toast.LENGTH_LONG).show();
	}

	public static EggGroupType eggGroupTypeFromTypeId(int typeId){
		switch(typeId){
			case 1:
				return EggGroupType.DITTO;
			case 2:
				return EggGroupType.HUMAN_LIKE;
			case 3:
				return EggGroupType.FLYING;
			case 4:
			case 7:
				return EggGroupType.BUG;
			case 8:
			case 10002:
				return EggGroupType.AMORPHOUS;
			case 9:
			case 5:
			case 6:
				return EggGroupType.MINERAL;
			case 10:
				return EggGroupType.MONSTER;
			case 11:
				return EggGroupType.WATER2;
			case 12:
				return EggGroupType.GRASS;
			case 13:
			case 14:
				return EggGroupType.FIELD;
			case 15:
				return EggGroupType.WATER3;
			case 16:
				return EggGroupType.DRAGON;
			case 17:
			case 10001:
				return EggGroupType.NO_EGGS;
			case 18:
				return EggGroupType.FAIRY;
			default:
				return EggGroupType.WATER1;

		}
	}

}
