package mrth.legion.joprst;

import android.app.Application;
import android.util.Log;

import mrth.legion.joprst.modules.ContextModule;

public class App extends Application{
    private static Api googleCuSearchAPI;
    @Override
    public void onCreate() {
        super.onCreate();

        GoogleSearchComponent daggerGoogleSearchComponent = DaggerGoogleSearchComponent.builder()
                .contextModule(new ContextModule(this))
                .build();

        googleCuSearchAPI = daggerGoogleSearchComponent.getGoogleSearchService();
    }

    public static Api getApi() {
        Log.d("Blet", "start getting component");
        return googleCuSearchAPI;
    }
}
