package com.xeroxparc.pokedex.data.repository;

import android.content.Context;
import android.os.AsyncTask;

import com.xeroxparc.pokedex.data.database.dao.pokemon.EggGroupDao;
import com.xeroxparc.pokedex.data.model.pokemon.egggroup.EggGroup;
import com.xeroxparc.pokedex.data.remote.ApiError;

import java.io.IOException;
import java.util.Optional;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

/*
 *
 *
 * @author Abdelrahman Abdelrahman (CptPackage)
 * */
public class EggGroupsRepository extends BaseRepository {
    private EggGroupDao eggGroupDao;

    public EggGroupsRepository(Context context) {
        super(context);
        eggGroupDao = database.eggGroupDao();
    }

    public LiveData<Optional<EggGroup>> getEggGroup(int id) {
        MutableLiveData<Optional<EggGroup>> eggGroup = new MutableLiveData<>();
        AsyncTask.execute(() -> {
            if (eggGroupDao.getEggGroup(id) == null) {
                try {
                    eggGroupDao.insert(apiService.getEggGroup(id));
                } catch (IOException | ApiError e) {
                    e.printStackTrace();
                }
            }
            eggGroup.postValue(Optional.ofNullable(eggGroupDao.getEggGroup(id)));
        });
        return eggGroup;
    }
}
