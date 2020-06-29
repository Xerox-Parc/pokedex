package com.xeroxparc.pokedex;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;
import android.view.Menu;

import com.xeroxparc.pokedex.databinding.ActivityMainBinding;

import java.util.Objects;


public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private NavController navController;
    private AppBarConfiguration appBarConfiguration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setSupportActionBar(binding.appBar.toolbar);

        navController = ((NavHostFragment) (Objects.requireNonNull(getSupportFragmentManager()
                .findFragmentById(binding.contentPanel.navigationHostFragment.getId()))))
                .getNavController();

        appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph())
                .setOpenableLayout(binding.drawerLayout)
                .build();

        NavigationUI.setupActionBarWithNavController(
                this,
                navController,
                appBarConfiguration
        );
        NavigationUI.setupWithNavController(binding.navigationView, navController);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        return NavigationUI.navigateUp(navController, appBarConfiguration) ||
                super.onSupportNavigateUp();
    }

}
