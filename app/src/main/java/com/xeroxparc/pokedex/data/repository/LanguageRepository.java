package com.xeroxparc.pokedex.data.repository;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.xeroxparc.pokedex.data.database.PokeDatabase;
import com.xeroxparc.pokedex.data.database.dao.utility.LanguageDao;
import com.xeroxparc.pokedex.data.model.utility.language.Language;
import com.xeroxparc.pokedex.data.remote.PokeApiFactory;
import com.xeroxparc.pokedex.data.remote.PokeApiService;

import java.io.IOException;

import retrofit2.HttpException;

/**
 * Repository class.
 * Encapsulate the logic required to access data sources.
 *
 * @author Fabio Buracchi
 */
public class LanguageRepository {

	private final PokeApiService service;
	private final PokeDatabase database;
	private final LanguageDao languageDao;

	public LanguageRepository(Application application) {
		service = PokeApiFactory.getService();
		database = PokeDatabase.getDatabase(application);
		languageDao = database.languageDao();
	}

	public LiveData<Language> getLanguage(int id, boolean forceRefresh) {
		MutableLiveData<Language> language = new MutableLiveData<>();
		AsyncTask.execute(() -> {
			if (forceRefresh || languageDao.getLanguage(id) == null) {
				try {
					languageDao.insert(service.getLanguage(id).result());
				} catch (IOException | HttpException e) {
					e.printStackTrace();
				}
			}
			language.postValue(languageDao.getLanguage(id));
		});
		return language;
	}

}
