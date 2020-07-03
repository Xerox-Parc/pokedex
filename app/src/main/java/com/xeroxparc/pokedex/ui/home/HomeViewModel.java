package com.xeroxparc.pokedex.ui.home;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;

import com.xeroxparc.pokedex.data.model.utility.language.Language;
import com.xeroxparc.pokedex.data.repository.LanguageRepository;

/**
 * View model class.
 * Maintains state of the model data.
 * Implement the business logic.
 *
 * @author Fabio Buracchi
 */
public class HomeViewModel extends AndroidViewModel {


	private final LanguageRepository berryRepository;
	private final LiveData<Language> language;
	private final MutableLiveData<Boolean> forceUpdate;

	public HomeViewModel(@NonNull Application application) {
		super(application);
		berryRepository = new LanguageRepository(application);
		forceUpdate = new MutableLiveData<>(false);
		language = Transformations.switchMap(forceUpdate, force ->
				berryRepository.getLanguage(1, force)
		);
	}

	public LiveData<Language> getLanguage() {
		return language;
	}

	void setForceUpdate() {
		forceUpdate.setValue(true);
	}

}
