package com.xeroxparc.pokedex.ui.home;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.xeroxparc.pokedex.databinding.FragmentHomeBinding;

/**
 * Binder class, it synchronize the view model and the view.
 * It replace data binding and BindingAdapter classes providing similar results with actual testable
 * code instead of fill XML with logic and lambda expression.
 *
 * @author Fabio Buracchi
 */
public class HomeBinder {

	private FragmentHomeBinding binding;
	private HomeFragment fragment;
	private HomeViewModel viewModel;

	HomeBinder(@NonNull HomeFragment fragment) {
		this.fragment = fragment;
		binding = FragmentHomeBinding.inflate(fragment.getLayoutInflater());
		viewModel = new ViewModelProvider(fragment).get(HomeViewModel.class);
	}

	View getRoot() {
		return binding.getRoot();
	}

	void clear() {
		fragment = null;
		binding = null;
		viewModel = null;
	}

	void bind() {

		PokemonAdapter adapter = new PokemonAdapter();
		binding.recyclerView.setAdapter(adapter);
		binding.recyclerView.setLayoutManager(new LinearLayoutManager(fragment.getContext()));
		viewModel.getPokemonList().observe(fragment, adapter::submitList);

		binding.swipeRefresh.setOnRefreshListener(() -> {
			viewModel.invalidate();
			binding.swipeRefresh.setRefreshing(false);
		});
	}

}
