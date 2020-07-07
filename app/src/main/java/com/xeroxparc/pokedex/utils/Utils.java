package com.xeroxparc.pokedex.utils;

import android.content.Context;
import android.widget.Toast;

import com.xeroxparc.pokedex.R;
import com.xeroxparc.pokedex.data.model.pokemon.species.PokemonSpecies;
import com.xeroxparc.pokedex.data.model.pokemon.species.PokemonSpeciesVariety;

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

	public static String imgFromSpecie(PokemonSpecies specie) {
		if(specie != null){
			Optional<PokemonSpeciesVariety> speciesVariety = specie.getVarietyList().
					stream().filter(PokemonSpeciesVariety::getDefault).findFirst();
			if (speciesVariety.isPresent()) {
				return speciesVariety.get().getPokemon().getSprite().getFrontDefault();
			}
		}
		return "";
	}

	public static int defaultPokemonIdFromSpecie(){
		return 0;
	}

}
