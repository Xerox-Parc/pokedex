package com.xeroxparc.pokedex.data.repository;

import android.content.Context;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.xeroxparc.pokedex.data.database.dao.location.RegionDao;
import com.xeroxparc.pokedex.data.model.location.region.Region;

import java.io.IOException;
import java.util.Optional;

import retrofit2.HttpException;

public class RegionRepository extends BaseRepository {
    private RegionDao regionDao;

    public RegionRepository(Context context) {
        super(context);
        regionDao = database.regionDao();
    }

    public LiveData<Optional<Region>> getRegion(int id) {
        MutableLiveData<Optional<Region>> region = new MutableLiveData<>();
        AsyncTask.execute(() -> {
            if (regionDao.getRegion(id) == null) {
                try {
                    regionDao.insert(service.getRegion(id).result());
                } catch (IOException | HttpException e) {
                    e.printStackTrace();
                }
            }
            region.postValue(Optional.ofNullable(regionDao.getRegion(id)));
        });
        return region;
    }
}
