package com.xeroxparc.pokedex.data.repository;

import android.content.Context;
import android.os.AsyncTask;

import com.xeroxparc.pokedex.data.database.dao.location.LocationDao;
import com.xeroxparc.pokedex.data.model.location.Location;

import java.io.IOException;
import java.util.Optional;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import retrofit2.HttpException;

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
                    locationDao.insert(service.getLocation(id).result());
                } catch (IOException | HttpException e) {
                    e.printStackTrace();
                }
            }
            location.postValue(Optional.ofNullable(locationDao.getLocation(id)));
        });
        return location;
    }
}