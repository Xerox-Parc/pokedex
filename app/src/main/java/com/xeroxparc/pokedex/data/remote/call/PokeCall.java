package com.xeroxparc.pokedex.data.remote.call;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.HttpException;
import retrofit2.Response;

/**
 * @author Fabio Buracchi
 */
public class PokeCall<T> {
	Call<T> call;

	public PokeCall(Call<T> call) {
		this.call = call;
	}

	public T result() throws IOException {
		Response<T> response = call.execute();
		if (response.isSuccessful()) {
			return response.body();
		} else {
			throw new HttpException(response);
		}
	}

}
