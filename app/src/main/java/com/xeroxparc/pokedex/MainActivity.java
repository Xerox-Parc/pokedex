package com.xeroxparc.pokedex;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;
import android.view.Menu;
import android.view.View;

import com.xeroxparc.pokedex.databinding.ActivityMainBinding;

import java.util.Objects;


public class MainActivity extends AppCompatActivity {

    private Holder holder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        holder = new Holder(this);
        setContentView(holder.getRoot());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        return holder.onNavigateUp() || super.onSupportNavigateUp();
    }

    class Holder {

        private final ActivityMainBinding binding;
        private final NavController navController;
        private final AppBarConfiguration appBarConfiguration;

        Holder(AppCompatActivity activity){
            binding = ActivityMainBinding.inflate(getLayoutInflater());

            setSupportActionBar(binding.appBar.toolbar);

            navController = ((NavHostFragment) (Objects.requireNonNull(getSupportFragmentManager()
                    .findFragmentById(binding.contentPanel.navigationHostFragment.getId()))))
                    .getNavController();

            appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph())
                    .setOpenableLayout(binding.drawerLayout)
                    .build();

            NavigationUI.setupActionBarWithNavController(
                    activity,
                    navController,
                    appBarConfiguration
            );
            NavigationUI.setupWithNavController(binding.navigationView, navController);

        }

        View getRoot() {
            return binding.getRoot();
        }

        Boolean onNavigateUp() {
            return NavigationUI.navigateUp(navController, appBarConfiguration);
        }

    }
}
