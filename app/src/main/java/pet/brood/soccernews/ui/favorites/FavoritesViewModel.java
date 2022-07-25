package pet.brood.soccernews.ui.favorites;

import android.os.AsyncTask;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

import pet.brood.soccernews.data.SoccerNewsRepository;
import pet.brood.soccernews.domain.News;

public class FavoritesViewModel extends ViewModel {

    private final LiveData<List<News>> news = new MutableLiveData<>();

    public FavoritesViewModel() {
    }

    public LiveData<List<News>> LoadFavoriteNews() {
        return SoccerNewsRepository.getInstance().getLocalDb().newsDao().loadFavoriteNews();
    }

    public void saveNews(News news) {
        AsyncTask.execute(()-> SoccerNewsRepository.getInstance().getLocalDb().newsDao().save(news));
    }
}