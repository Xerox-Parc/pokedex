package com.xeroxparc.pokedex.ui.ability;

import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.xeroxparc.pokedex.R;
import com.xeroxparc.pokedex.data.model.pokemon.ability.Ability;
import com.xeroxparc.pokedex.data.repository.AbilityRepository;
import com.xeroxparc.pokedex.databinding.FragmentAbilityBinding;
import com.xeroxparc.pokedex.databinding.ItemAbilityBinding;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public class AbilityFragment extends Fragment  {
    private AbilityBinder binder;
    private FragmentAbilityBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){
        new CustomActionBarFragment();
        binder = new AbilityBinder(this);
        binder.bind();
        return binder.getRoot();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binder = null;
    }

    public class CustomActionBarFragment extends AppCompatActivity {

        @Override
        public void onCreate(@Nullable Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setHasOptionsMenu(true);
        }

        @Override
        public boolean onCreateOptionsMenu(Menu menu) {
            getMenuInflater().inflate(R.menu.pokedex_menu, menu);
            return true;
        }
    }

    public abstract class AbilityListAdapter extends RecyclerView.Adapter<AbilityListAdapter.AbilityViewHolder> {
        private List<Ability> abilityList = new ArrayList<>();

        abstract void onClickCallback(Ability ability);
        @NonNull
        @Override
        public AbilityFragment.AbilityListAdapter.AbilityViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new AbilityFragment.AbilityListAdapter.AbilityViewHolder(new AbilityListItemBinder(parent.getContext(), parent, false));
        }

        @Override
        public int getItemCount() {
            return (abilityList != null) ? abilityList.size(): 0;
        }

        @Override
        public void onBindViewHolder(@NonNull AbilityFragment.AbilityListAdapter.AbilityViewHolder holder, int position) {
            if (abilityList != null){
                Ability ability = abilityList.get(position);
                /*Funzione di trasferimento*/
                AbilityFragmentDirections.ActionNavAbilitiesToNavAbilitiesDetail action = AbilityFragmentDirections.actionNavAbilitiesToNavAbilitiesDetail();
                holder.cardView.setOnClickListener(v -> {
                    Log.d("Myapp","You clicked ability: "+(position+1));
                    action.setAbilityId(ability.getId());
                    Navigation.findNavController(requireView()).navigate(action);
                });
                holder.binder.bind(ability,position);
                holder.binder.getRoot().setOnClickListener(c -> onClickCallback(ability));
            }
        }

        void addAbility(Ability ability) {
            abilityList.add(ability);
            notifyItemInserted(abilityList.size());
        }


        public class AbilityViewHolder extends RecyclerView.ViewHolder {
            final AbilityListItemBinder binder;
            public FragmentAbilityBinding binding;
            public CardView cardView;

            AbilityViewHolder(@NonNull AbilityListItemBinder binder) {
                super(binder.getRoot());
                this.binder = binder;
                cardView=itemView.findViewById(R.id.card_view_ability);
            }
        }
    }
    public class AbilityBinder  {
        private final FragmentAbilityBinding binding;
        private final AbilityFragment fragment;
        private AbilityViewModel viewModel;


        AbilityBinder(@NonNull AbilityFragment fragment) {
            this.fragment = fragment;
            binding = FragmentAbilityBinding.inflate(fragment.getLayoutInflater());
            viewModel = new ViewModelProvider(fragment).get(AbilityViewModel.class);

        }

        View getRoot() { return binding.getRoot(); }

        void bind(){
            AbilityFragment.AbilityListAdapter componentListAdapter = new AbilityFragment.AbilityListAdapter() {
                @Override
                void onClickCallback(Ability ability) {
                    showDetail(ability);
                }
            };
            binding.recyclerViewAbility.setAdapter(componentListAdapter);
            binding.recyclerViewAbility.setLayoutManager(new LinearLayoutManager(fragment.getContext()));
            int MAX_ABILITY_ID = 233;
            for(int i=1;i<MAX_ABILITY_ID+1; i++){
                viewModel.getAbility(i).observe(fragment, ability -> ability.ifPresent(componentListAdapter::addAbility));

            }
        }

        private void showDetail(@NonNull Ability ability) {

        }

    }

    public static class AbilityViewModel extends AndroidViewModel {
            private AbilityFragment fragment;
            private final AbilityRepository repository;
            public AbilityViewModel(@NonNull Application application) {
                super(application);
                repository = new AbilityRepository(application);
            }
            public LiveData<Optional<Ability>> getAbility(int id){
                return repository.getAbility(id);
            }
    }

    class AbilityListItemBinder {
        private final ItemAbilityBinding binding;
        AbilityListItemBinder(Context context, ViewGroup root, Boolean attachToRoot){
            binding = ItemAbilityBinding.inflate(LayoutInflater.from(context), root, attachToRoot);
        }
        View getRoot(){
            return binding.getRoot();
        }
        void bind(@NonNull Ability ability, int position) {
           binding.textViewNameAbility.setText(ability.getName());
           binding.abilityDescription.setText(ability.getEffectEntryList().get(1).getShortEffect());
           binding.textViewNameAbility.setText(String.format(Character.toUpperCase(ability.getName().charAt(0))+ability.getName().substring(1)));

        }
    }

}