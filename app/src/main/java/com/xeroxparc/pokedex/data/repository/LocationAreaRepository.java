package com.xeroxparc.pokedex.data.repository;

import android.content.Context;
import android.os.AsyncTask;

import com.xeroxparc.pokedex.data.database.dao.location.LocationAreaDao;
import com.xeroxparc.pokedex.data.model.location.area.LocationArea;
import com.xeroxparc.pokedex.data.remote.ApiError;

import java.io.IOException;
import java.util.Optional;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

public class LocationAreaRepository extends BaseRepository {
    private LocationAreaDao locationAreaDao;

    public LocationAreaRepository(Context context) {
        super(context);
        locationAreaDao = database.locationAreaDao();
    }

    public LiveData<Optional<LocationArea>> getLocationArea(int id) {
        MutableLiveData<Optional<LocationArea>> area = new MutableLiveData<>();
        AsyncTask.execute(() -> {
            if (locationAreaDao.getLocationArea(id) == null) {
                try {
                    locationAreaDao.insert(apiService.getLocationArea(id));
                } catch (IOException | ApiError e) {
                    e.printStackTrace();
                }
            }
            area.postValue(Optional.ofNullable(locationAreaDao.getLocationArea(id)));
        });
        return area;
    }
}