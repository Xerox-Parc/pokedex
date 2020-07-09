package com.xeroxparc.pokedex.utils;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

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

	@Nullable
	public static Integer urlToPageNumber(@NonNull String url) {
		Matcher matcher = Pattern.compile("(?<=offset=)[0-9]+").matcher(url);
		return matcher.find() ?
				Integer.valueOf(matcher.group()) :
				null;
	}

}
