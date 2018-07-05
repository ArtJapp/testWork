package mrth.legion.joprst;

import android.app.Application;
import android.util.Log;

import com.squareup.picasso.Picasso;

import mrth.legion.joprst.modules.ContextModule;

public class App extends Application{
    private static Api googleCuSearchAPI;
    private static Picasso picassoDownloader;

    private static GoogleSearchComponent appComponent;
    @Override
    public void onCreate() {
        super.onCreate();

        appComponent = DaggerGoogleSearchComponent.builder()
                .contextModule(new ContextModule(this))
                .build();



        googleCuSearchAPI = appComponent.getGoogleSearchService();
        picassoDownloader = appComponent.getPicasso();

    }

    public static Api getApi() {
        Log.d("Loggy", "start getting component");
        return googleCuSearchAPI;
    }
    public static Picasso getPicasso() {
        Log.d("Loggy", "start getting component");
        return picassoDownloader;
    }

    public static GoogleSearchComponent getAppComponent() {
        return appComponent;
    }

    public GoogleSearchComponent provideGoogleSearchComponent() {
        return new GoogleSearchComponent();
    }
}
