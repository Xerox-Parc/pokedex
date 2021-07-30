package com.xeroxparc.pokedex.data.repository;

import android.content.Context;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.xeroxparc.pokedex.data.database.dao.move.MoveDao;
import com.xeroxparc.pokedex.data.model.move.Move;

import java.io.IOException;
import java.util.Optional;

import retrofit2.HttpException;

public class MoveRepository extends BaseRepository {

    private MoveDao moveDao;

    public MoveRepository(Context context) {
        super(context);
        moveDao = database.moveDao();
    }

    public LiveData<Optional<Move>> getMove(int id){
        MutableLiveData<Optional<Move>> move = new MutableLiveData<>();
        AsyncTask.execute(() ->{
            if(moveDao.getMove(id) == null){
                try{
                    moveDao.insert(service.getMove(id).result());
                } catch (IOException | HttpException e){
                    e.printStackTrace();
                }
            }
            move.postValue(Optional.ofNullable(moveDao.getMove(id)));
        });
        return move;
    }
}
