package com.xeroxparc.pokedex.data.repository;

import android.content.Context;

import com.xeroxparc.pokedex.data.database.PokeDatabase;
import com.xeroxparc.pokedex.data.remote.PokeApi;
import com.xeroxparc.pokedex.data.remote.PokeApiService;

/*
* Created this base repository to avoid duplication of the initialization code
*  of the PokeApiService and PokeDatabase
*
* @author Abdelrahman Abdelrahman (CptPackage)
* */
public abstract class BaseRepository {
    protected PokeApiService apiService;
    protected PokeDatabase database;

    public BaseRepository(Context context) {
        apiService = PokeApi.getService();
        database = PokeDatabase.getDatabase(context);
    }
}
