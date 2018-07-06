package mrth.legion.joprst;

import com.squareup.picasso.Picasso;

import javax.inject.Singleton;

import dagger.Component;
import mrth.legion.joprst.modules.AppModule;
import mrth.legion.joprst.modules.ContextModule;
import mrth.legion.joprst.modules.GoogleSearchModule;
import mrth.legion.joprst.modules.PicassoModule;
import mrth.legion.joprst.presenters.ResultPresenter;
import mrth.legion.joprst.presenters.ResultsPresenter;

@Singleton
@Component(modules = {GoogleSearchModule.class, PicassoModule.class, AppModule.class})
public interface GoogleSearchComponent {
    Api getGoogleSearchService();
    Picasso getPicasso();

    void inject(ResultPresenter presenter);
//    void inject(ResultsPresenter presenter);
}