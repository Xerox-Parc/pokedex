package com.xeroxparc.pokedex.ui.ability;

import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.xeroxparc.pokedex.R;
import com.xeroxparc.pokedex.data.filtering.FilterableResourceProvider;
import com.xeroxparc.pokedex.data.filtering.TextFilter;
import com.xeroxparc.pokedex.data.filtering.TextFilterable;
import com.xeroxparc.pokedex.data.model.pokemon.ability.Ability;
import com.xeroxparc.pokedex.data.repository.AbilityRepository;
import com.xeroxparc.pokedex.databinding.FragmentAbilityBinding;
import com.xeroxparc.pokedex.databinding.ItemAbilityBinding;
import com.xeroxparc.pokedex.ui.parents.SearchableFragment;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class AbilityFragment extends SearchableFragment {
    private AbilityBinder binder;
    private FragmentAbilityBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binder = new AbilityBinder(this);
        binder.bind();
        return binder.getRoot();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return onQueryTextChange(query);
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        if (binder != null) {
            binder.getComponentListAdapter().getFilter().filter(newText);
        }
        return true;
    }

    public static class AbilityViewModel extends AndroidViewModel {
        private final AbilityRepository repository;
        private AbilityFragment fragment;

        public AbilityViewModel(@NonNull Application application) {
            super(application);
            repository = new AbilityRepository(application);
        }

        public LiveData<Optional<Ability>> getAbility(int id) {
            return repository.getAbility(id);
        }
    }


    public abstract class AbilityListAdapter extends RecyclerView.Adapter<AbilityListAdapter.AbilityViewHolder>
            implements TextFilterable<Ability>, FilterableResourceProvider<Ability> {
        private List<Ability> abilityList = new ArrayList<>();
        private List<Ability> filteredList = new ArrayList<>();

        abstract void onClickCallback(Ability ability);

        @NonNull
        @Override
        public AbilityFragment.AbilityListAdapter.AbilityViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new AbilityFragment.AbilityListAdapter.AbilityViewHolder(new AbilityListItemBinder(parent.getContext(), parent, false));
        }

        @Override
        public int getItemCount() {
            return filteredList.size();
        }

        @Override
        public void onBindViewHolder(@NonNull AbilityFragment.AbilityListAdapter.AbilityViewHolder holder, int position) {
            if (abilityList != null) {
                if (filteredList.size() > position) {
                    Ability ability = filteredList.get(position);
                    /*Funzione di trasferimento*/
                    AbilityFragmentDirections.ActionNavAbilitiesToNavAbilitiesDetail action = AbilityFragmentDirections.actionNavAbilitiesToNavAbilitiesDetail();
                    holder.cardView.setOnClickListener(v -> {
                        Log.d("Myapp", "You clicked ability: " + (position + 1));
                        action.setAbilityId(ability.getId());
                        Navigation.findNavController(requireView()).navigate(action);
                    });
                    holder.binder.bind(ability);
                    holder.binder.getRoot().setOnClickListener(c -> onClickCallback(ability));
                }
            }
        }

        void addAbility(Ability ability) {
            if (filteredList.size() == abilityList.size()) {
                filteredList.add(ability);
            }
            abilityList.add(ability);
            notifyDataSetChanged();
        }

        protected List<Ability> getAbilityList() {
            return abilityList;
        }

        protected List<Ability> getFilteredList() {
            return filteredList;
        }

        public class AbilityViewHolder extends RecyclerView.ViewHolder {
            final AbilityListItemBinder binder;
            public FragmentAbilityBinding binding;
            public CardView cardView;

            AbilityViewHolder(@NonNull AbilityListItemBinder binder) {
                super(binder.getRoot());
                this.binder = binder;
                cardView = itemView.findViewById(R.id.card_view_ability);
            }
        }
    }

    public class AbilityBinder {
        private final FragmentAbilityBinding binding;
        private final AbilityFragment fragment;
        private AbilityViewModel viewModel;
        private AbilityFragment.AbilityListAdapter componentListAdapter;


        AbilityBinder(@NonNull AbilityFragment fragment) {
            this.fragment = fragment;
            binding = FragmentAbilityBinding.inflate(fragment.getLayoutInflater());
            viewModel = new ViewModelProvider(fragment).get(AbilityViewModel.class);

        }

        View getRoot() {
            return binding.getRoot();
        }

        void bind() {
            componentListAdapter = new AbilityFragment.AbilityListAdapter() {
                @Override
                public String getFilterableResource(Ability source) {
                    return source.getName();
                }

                @Override
                public void postFiltering(List<Ability> filteredData) {
                    getFilteredList().clear();
                    getFilteredList().addAll(filteredData);
                    notifyDataSetChanged();
                }

                @Override
                public TextFilter<Ability> getFilter() {
                    return new TextFilter<>(getAbilityList(), this, this);
                }

                @Override
                void onClickCallback(Ability ability) {
                    showDetail(ability);
                }
            };
            binding.recyclerViewAbility.setAdapter(componentListAdapter);
            binding.recyclerViewAbility.setLayoutManager(new LinearLayoutManager(fragment.getContext()));

            int MAX_ABILITY_ID = 233;
            for (int i = 1; i < MAX_ABILITY_ID + 1; i++) {
                viewModel.getAbility(i).observe(fragment, ability -> ability.ifPresent(componentListAdapter::addAbility));

            }
        }

        private void showDetail(@NonNull Ability ability) {
        }

        public AbilityListAdapter getComponentListAdapter() {
            return componentListAdapter;
        }
    }

    class AbilityListItemBinder {
        private final ItemAbilityBinding binding;

        AbilityListItemBinder(Context context, ViewGroup root, Boolean attachToRoot) {
            binding = ItemAbilityBinding.inflate(LayoutInflater.from(context), root, attachToRoot);
        }

        View getRoot() {
            return binding.getRoot();
        }


        // request ability name and description from either the database or the web
        void bind(@NonNull Ability ability) {
            binding.textViewNameAbility.setText(ability.getName());
            binding.abilityDescription.setText(ability.getEffectEntryList().get(1).getShortEffect());
            binding.textViewNameAbility.setText(String.format(
                    "%s%s",
                    Character.toUpperCase(
                            ability.getName().charAt(0)),
                    ability.getName().substring(1)
                    )
            );
        }
    }

}