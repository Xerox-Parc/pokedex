package com.xeroxparc.pokedex;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.navigation.fragment.NavHostFragment;

import android.os.Bundle;
import android.view.View;

import com.xeroxparc.pokedex.databinding.ActivityMainBinding;

import java.util.Objects;


public class MainActivity extends AppCompatActivity {

    Holder holder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        holder = new Holder();
        setContentView(holder.getRoot());
    }

    class Holder{

        private ActivityMainBinding binding;

        Holder(){

            binding = ActivityMainBinding.inflate(getLayoutInflater());

            setSupportActionBar(binding.topAppBar);

            binding.topAppBar.setNavigationOnClickListener(item ->{
                binding.drawerLayout.openDrawer(GravityCompat.START);
            });

            binding.navigationView.setNavigationItemSelectedListener(item -> {
                ((NavHostFragment) (Objects.requireNonNull(getSupportFragmentManager()
                        .findFragmentById(binding.navigationHostFragment.getId()))))
                        .getNavController()
                        .navigate(item.getItemId());
                item.setChecked(true);
                binding.drawerLayout.closeDrawer(GravityCompat.START);
                return true;
            });

        }
        View getRoot() {
            return binding.getRoot();
        }
    }
}