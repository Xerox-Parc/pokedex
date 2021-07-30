package com.xeroxparc.pokedex.data.repository;

import android.content.Context;
import android.os.AsyncTask;

import com.xeroxparc.pokedex.data.database.dao.location.LocationAreaDao;
import com.xeroxparc.pokedex.data.model.location.area.LocationArea;

import java.io.IOException;
import java.util.Optional;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import retrofit2.HttpException;

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
                    locationAreaDao.insert(service.getLocationArea(id).result());
                } catch (IOException | HttpException e) {
                    e.printStackTrace();
                }
            }
            area.postValue(Optional.ofNullable(locationAreaDao.getLocationArea(id)));
        });
        return area;
    }
}