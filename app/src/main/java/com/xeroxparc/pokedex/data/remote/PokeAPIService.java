package com.xeroxparc.pokedex.data.remote;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.GsonBuilder;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PokeApiService {

	public static class ErrorResponse extends Throwable {
		ErrorResponse(@NonNull Integer code,@NonNull String message) {
			super("(" + code.toString() + ") " + message);
		}
	}

	private static PokeApi service;

	public PokeApiService() {
		getService();
	}

	private synchronized void getService() {
		if (service == null){
			service = new Retrofit.Builder()
					.baseUrl("https://pokeapi.co/api/v2/")
					.addConverterFactory(GsonConverterFactory.create(
							new GsonBuilder()
									.setFieldNamingPolicy(
											FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES
									)
									.registerTypeAdapterFactory(
											new ResourceTypeAdapterFactory()
									)
									.create()
							)
					)
					.build().create(PokeApi.class);
		}
	}

	private <T> LiveData<T> result(Call<T> request) throws ErrorResponse {
		MutableLiveData<T> result = new MutableLiveData<>();
		request.enqueue(new Callback<T>() {
			@Override
			public void onResponse(Call<T> call, Response<T> response) {
				if (response.isSuccessful()) {
					result.setValue(response.body());
				}
			}

			@Override
			public void onFailure(Call<T> call, Throwable t) {

			}
		});
		return result;
	}

}
