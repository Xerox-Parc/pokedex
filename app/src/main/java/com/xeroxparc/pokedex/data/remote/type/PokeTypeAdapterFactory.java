package com.xeroxparc.pokedex.data.remote.type;

import androidx.annotation.NonNull;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;
import java.util.Map;

import static com.xeroxparc.pokedex.utils.Utils.urlToId;
import static com.xeroxparc.pokedex.utils.Utils.urlToPageNumber;

/**
 * Custom TypeAdapterFactory to correctly handle JSON results
 *
 * @author Fabio Buracchi
 */
public class PokeTypeAdapterFactory implements TypeAdapterFactory {
	@Override
	public <T> TypeAdapter<T> create(@NonNull Gson gson, @NonNull TypeToken<T> type) {
		final TypeAdapter<T> delegateAdapter = gson.getDelegateAdapter(this, type);
		final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);

		return new TypeAdapter<T>() {

			@Override
			public void write(JsonWriter out, T value) throws IOException {
				delegateAdapter.write(out, value);
			}

			@Override
			public T read(JsonReader in) throws IOException {
				JsonElement tree = elementAdapter.read(in);
				return delegateAdapter.fromJsonTree(afterRead(tree));
			}

			private JsonElement afterRead(@NonNull JsonElement jsonElement) {
				if (jsonElement instanceof JsonObject) {
					JsonObject jsonObject = ((JsonObject) jsonElement);
					for (Map.Entry<String, JsonElement> entry : jsonObject.entrySet()) {
						if (entry.getValue() instanceof JsonPrimitive) {
							String url;
							switch (entry.getKey()) {
								case "next":
									url = jsonObject.get(entry.getKey()).toString()
											.replace("\"", "");
									jsonObject.addProperty("next", urlToPageNumber(url));
									afterRead(entry.getValue());
									break;
								case "previous":
									url = jsonObject.get(entry.getKey()).toString()
											.replace("\"", "");
									jsonObject.addProperty("previous", urlToPageNumber(url));
									afterRead(entry.getValue());
									break;
								case "url":
									url = jsonObject.get(entry.getKey()).toString()
											.replace("\"", "");
									jsonObject.addProperty("id", urlToId(url));
									jsonObject.remove("url");
									break;
								default:
									afterRead(entry.getValue());
							}
						}
					}
				}
				return jsonElement;
			}

		}.nullSafe();

	}

}
