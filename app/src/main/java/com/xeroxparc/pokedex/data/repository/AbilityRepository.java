package com.xeroxparc.pokedex.data.repository;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.xeroxparc.pokedex.data.database.dao.pokemon.AbilityDao;
import com.xeroxparc.pokedex.data.model.pokemon.ability.Ability;
import com.xeroxparc.pokedex.data.remote.ApiError;

import java.io.IOException;
import java.util.Optional;

public class AbilityRepository extends BaseRepository {
    private AbilityDao abilityDao;

    public AbilityRepository(@NonNull Context context) {
        super(context);
        abilityDao = database.abilityDao();
    }
    public LiveData<Optional<Ability>> getAbility(int id) {
        MutableLiveData<Optional<Ability>> ability = new MutableLiveData<>();
        AsyncTask.execute(() -> {
            if (abilityDao.getAbility(id) == null) {
                try {
                    abilityDao.insert(apiService.getAbility(id));
                } catch (IOException | ApiError e) {
                    e.printStackTrace();
                }
            }
            ability.postValue(Optional.ofNullable(abilityDao.getAbility(id)));
        });
        return ability;
    }


}
