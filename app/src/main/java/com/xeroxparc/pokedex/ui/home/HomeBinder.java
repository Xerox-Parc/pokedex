package com.xeroxparc.pokedex.ui.home;

import android.view.View;

import com.xeroxparc.pokedex.databinding.FragmentHomeBinding;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModelProvider;

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

    void clean() {
        fragment = null;
        binding = null;
        viewModel = null;
    }

    void bind() {
        viewModel.getLanguage().observe(fragment, language ->
                {
                    if (language != null) {
                        binding.textView.setText(language.getName());

                    }
                }
        );

        binding.swipeRefresh.setOnRefreshListener(() -> {
            viewModel.setForceUpdate();
            binding.swipeRefresh.setRefreshing(false);
        });
    }

}
