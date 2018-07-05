package mrth.legion.joprst;

import android.app.Application;
import android.util.Log;

import com.squareup.picasso.Picasso;

import mrth.legion.joprst.modules.ContextModule;

public class App extends Application{
    private static Api googleCuSearchAPI;
    private static Picasso picassoDownloader;
    @Override
    public void onCreate() {
        super.onCreate();

        GoogleSearchComponent daggerGoogleSearchComponent = DaggerGoogleSearchComponent.builder()
                .contextModule(new ContextModule(this))
                .build();

        googleCuSearchAPI = daggerGoogleSearchComponent.getGoogleSearchService();
        picassoDownloader = daggerGoogleSearchComponent.getPicasso();
    }

    public static Api getApi() {
        Log.d("Loggy", "start getting component");
        return googleCuSearchAPI;
    }
    public static Picasso getPicasso() {
        Log.d("Loggy", "start getting component");
        return picassoDownloader;
    }
}
