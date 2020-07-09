package com.xeroxparc.pokedex.ui.home;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.paging.PagedListAdapter;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.xeroxparc.pokedex.data.model.pokemon.Pokemon;
import com.xeroxparc.pokedex.data.model.utility.language.Language;

import java.util.Objects;

public class PokemonAdapter extends PagedListAdapter<Pokemon, PokemonAdapter.PokemonViewHolder> {

	protected PokemonAdapter() {
		super(DIFF_CALLBACK);
	}

	@NonNull
	@Override
	public PokemonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
		return new PokemonViewHolder(new PokemonItemBinder(parent.getContext(), parent, false));
	}

	@Override
	public void onBindViewHolder(@NonNull PokemonViewHolder holder, int position) {
		Pokemon pokemon = getItem(position);
		if (pokemon != null) {
			holder.binder.bind(pokemon);
		}
		else {
			// Null defines a placeholder item - PagedListAdapter automatically
			// invalidates this row when the actual object is loaded from the
			// database.
			holder.binder.clear();
		}
	}

	private static DiffUtil.ItemCallback<Pokemon> DIFF_CALLBACK =
			new DiffUtil.ItemCallback<Pokemon>() {
				// Language details may have changed if reloaded from the database,
				// but ID is fixed.
				@Override
				public boolean areItemsTheSame(Pokemon oldLanguage, Pokemon newLanguage) {
					return oldLanguage.getId().equals(newLanguage.getId());
				}

				@Override
				public boolean areContentsTheSame(@NonNull Pokemon oldLanguage,
				                                  @NonNull Pokemon newLanguage) {
					return Objects.equals(oldLanguage, newLanguage);
				}
			};

	static class PokemonViewHolder extends RecyclerView.ViewHolder {

		final PokemonItemBinder binder;

		public PokemonViewHolder(@NonNull PokemonItemBinder binder) {
			super(binder.getRoot());
			this.binder = binder;
		}
	}

}
