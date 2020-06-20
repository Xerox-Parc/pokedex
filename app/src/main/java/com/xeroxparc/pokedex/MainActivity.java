package com.xeroxparc.pokedex;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.navigation.fragment.NavHostFragment;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import com.xeroxparc.pokedex.databinding.ActivityMainBinding;

import java.util.Objects;


public class MainActivity extends AppCompatActivity {

    Holder holder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        holder = new Holder(this);
        setContentView(holder.getRoot());
    }

    class Holder{

        private ActivityMainBinding binding;

        Holder(Activity activity){

            binding = ActivityMainBinding.inflate(getLayoutInflater());

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