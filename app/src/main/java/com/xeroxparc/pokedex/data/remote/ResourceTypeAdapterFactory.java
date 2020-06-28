package com.xeroxparc.pokedex.data.remote;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

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
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ResourceTypeAdapterFactory implements TypeAdapterFactory {
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
				tree = afterRead(tree);
				return delegateAdapter.fromJsonTree(tree);
			}

			private JsonElement afterRead(@NonNull JsonElement jsonElement) {
				if (jsonElement instanceof JsonObject) {
					JsonObject jsonObject = ((JsonObject) jsonElement);
					for (Map.Entry<String, JsonElement> entry : jsonObject.entrySet()) {
						if (entry.getValue() instanceof JsonPrimitive) {
							if (entry.getKey().equalsIgnoreCase("count")) {
								return jsonObject.getAsJsonArray("results");
							}
							else if (entry.getKey().equalsIgnoreCase("url")) {
								jsonObject.addProperty(
										"id",
										urlToId(jsonObject.get(entry.getKey()).toString())
								);
								jsonObject.remove("url");
							}
						} else {
							afterRead(entry.getValue());
						}
					}
				}
				return jsonElement;
			}

			@Nullable
			private Integer urlToId(@NonNull String url) {
				Matcher matcher = Pattern
						.compile("/-?[0-9]+/$")
						.matcher(url.replace("\"", ""));
				return matcher.find() ?
						Integer.valueOf(matcher.group().replace("/", "")) :
						null;
			}

		}.nullSafe();

	}

}
