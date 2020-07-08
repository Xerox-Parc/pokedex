package com.xeroxparc.pokedex.data.repository;

import android.content.Context;
import android.os.AsyncTask;

import com.xeroxparc.pokedex.data.database.dao.location.LocationDao;
import com.xeroxparc.pokedex.data.model.location.Location;
import com.xeroxparc.pokedex.data.model.pokemon.Pokemon;
import com.xeroxparc.pokedex.data.remote.ApiError;

import java.io.IOException;
import java.util.Optional;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

public class LocationsRepository extends BaseRepository {
    private LocationDao locationDao;
    public LocationsRepository(Context context) {
        super(context);
        locationDao = database.locationDao();
    }

    public LiveData<Optional<Location>> getLocation(int id) {
        MutableLiveData<Optional<Location>> location = new MutableLiveData<>();
        AsyncTask.execute(() -> {
            if (locationDao.getLocation(id) == null) {
                try {
                    locationDao.insert(apiService.getLocation(id));
                } catch (IOException | ApiError e) {
                    e.printStackTrace();
                }
            }
            location.postValue(Optional.ofNullable(locationDao.getLocation(id)));
        });
        return location;
    }
}
