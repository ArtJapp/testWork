package mrth.legion.joprst.presenters;

import android.util.Log;

import mrth.legion.joprst.models.Item;
import mrth.legion.joprst.views.ResultView;

public class SearchPresenter extends BasePresenter<Item, ResultView> {

    @Override
    protected void updateView() {
        Log.d("Loggy", "start updating");
        view().setResultItemTitle(model.getTitle());

        view().setResultItemImage(model.getLink(), model.getImage().getWidth(), model.getImage().getHeight());


        Log.d("Loggy", "finish updating");
    }

}
