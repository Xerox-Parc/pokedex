package com.xeroxparc.pokedex.data.remote;

import android.util.Log;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.GsonBuilder;
import com.xeroxparc.pokedex.data.remote.call.PokeCallAdapterFactory;
import com.xeroxparc.pokedex.data.remote.type.PokeTypeAdapterFactory;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @author Fabio Buracchi
 */
public abstract class PokeApi implements PokeApiService {

	private static PokeApiService service;

	private PokeApi() {}

	public static synchronized PokeApiService getService() {
		if (service == null) {
			service = new Retrofit.Builder()
					.baseUrl("https://pokeapi.co/api/v2/")
					.client(
							new OkHttpClient.Builder()
									.addInterceptor(new HttpLoggingInterceptor(
											s -> Log.d("API", s))
											.setLevel(HttpLoggingInterceptor.Level.BASIC)
									)
									.build()
					)
					.addConverterFactory(GsonConverterFactory.create(
							new GsonBuilder()
									.setFieldNamingPolicy(
											FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES
									)
									.registerTypeAdapterFactory(
											new PokeTypeAdapterFactory()
									)
									.create()
							)
					)
					.addCallAdapterFactory(
							new PokeCallAdapterFactory()
					)
					.build()
					.create(PokeApiService.class);
		}
		return service;
	}

}
