package pet.brood.soccernews.data;

import androidx.room.Room;

import pet.brood.soccernews.App;
import pet.brood.soccernews.data.local.SoccerNewsDb;
import pet.brood.soccernews.data.remote.SoccerNewsApi;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SoccerNewsRepository {

    private static final String REMOTE_API_URL = "https://plucenaa.github.io/soccer-news-api/";
    private static final String LOCAL_DB_NAME = "soccer-news";

    private SoccerNewsApi remoteApi;
    private SoccerNewsDb localDb;

    public SoccerNewsApi getRemoteApi(){return remoteApi;}

    public SoccerNewsDb getLocalDb() {return localDb;}

    private SoccerNewsRepository(){
        remoteApi = new Retrofit.Builder()
                .baseUrl(REMOTE_API_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(SoccerNewsApi.class);

        localDb = Room.databaseBuilder(App.getInstance(), SoccerNewsDb.class, LOCAL_DB_NAME)
                .build();
    }
    public static SoccerNewsRepository getInstance(){ return LazyHolder.INSTANCE;}

    public static class LazyHolder {
        private static final SoccerNewsRepository INSTANCE = new SoccerNewsRepository();
    }
}
