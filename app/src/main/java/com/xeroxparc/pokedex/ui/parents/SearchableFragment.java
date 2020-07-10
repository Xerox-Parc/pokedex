package com.xeroxparc.pokedex.ui.parents;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.xeroxparc.pokedex.R;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.SearchView.OnQueryTextListener;
import androidx.navigation.Navigation;

public abstract class SearchableFragment extends CustomActionBarFragment implements OnQueryTextListener {
    private static final String TAG = "SearchableFragment";

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(R.menu.menu_egg_group_details, menu);
        SearchView searchView = (SearchView) menu.findItem(R.id.search).getActionView();
        searchView.setOnQueryTextListener(this);
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.search) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
