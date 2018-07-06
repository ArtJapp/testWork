package mrth.legion.joprst.modules;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import mrth.legion.joprst.App;

@Module
public class AppModule {
    private final App mApp;

    public AppModule(App app) {
        this.mApp = app;
    }

    @Provides
    @Singleton
    App provideApplicationContext() {
        return mApp;
    }
}
