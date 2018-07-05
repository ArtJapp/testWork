package mrth.legion.joprst.presenters;

import android.util.Log;

import com.arellomobile.mvp.InjectViewState;

import mrth.legion.joprst.models.Item;
import mrth.legion.joprst.views.ResultView;

@InjectViewState
public class SearchPresenter extends BasePresenter<Item, ResultView> {
    public static final String TAG = "SearchPresenter";
    @Override
    protected void updateView() {
        Log.d("Loggy", "start updating");
        view().setResultItemTitle(model.getTitle());

        view().setResultItemImage(model.getLink());


        Log.d("Loggy", "finish updating");
    }

}
