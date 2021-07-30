package com.xeroxparc.pokedex.data.remote.call;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import retrofit2.CallAdapter;
import retrofit2.Retrofit;

/**
 * @author Fabio Buracchi
 */
public class PokeCallAdapterFactory extends CallAdapter.Factory{

	@Nullable
	@Override
	public CallAdapter<?, ?> get(
			@NonNull Type returnType,
			@NonNull Annotation[] annotations,
			@NonNull Retrofit retrofit
	) {
		if (getRawType(returnType) != PokeCall.class) {
			return null;
		}
		return new PokeCallAdapter<>(
				getParameterUpperBound(0, (ParameterizedType) returnType)
		);
	}

}
