package mrth.legion.joprst;

import com.squareup.picasso.Picasso;

import dagger.Component;
import mrth.legion.joprst.modules.GoogleSearchModule;
import mrth.legion.joprst.modules.PicassoModule;

@Component(modules = {GoogleSearchModule.class, PicassoModule.class})
interface GoogleSearchComponent {
    Api getGoogleSearchService();
    Picasso getPicasso();
}