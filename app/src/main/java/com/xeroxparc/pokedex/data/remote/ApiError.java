package com.xeroxparc.pokedex.data.remote;

/**
 * @author Fabio Buracchi
 */
public class ApiError extends Exception {

	ApiError(int code, String message) {
		super("(" + code + "): " + message);
	}

}
