package com.xeroxparc.pokedex.data.remote.call;

import androidx.annotation.NonNull;

import java.lang.reflect.Type;

import retrofit2.Call;
import retrofit2.CallAdapter;

/**
 * @author Fabio Buracchi
 */
public class PokeCallAdapter<R> implements CallAdapter<R, PokeCall<R>> {

	private Type responseType;

	public PokeCallAdapter(Type responseType) {
		this.responseType = responseType;
	}

	@NonNull
	@Override
	public Type responseType() {
		return responseType;
	}

	@NonNull
	@Override
	public PokeCall<R> adapt(@NonNull Call<R> call) {
		return new PokeCall<>(call);
	}
}
