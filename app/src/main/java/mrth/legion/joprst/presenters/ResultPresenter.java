package mrth.legion.joprst.presenters;

import android.util.Log;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

import mrth.legion.joprst.models.Item;
import mrth.legion.joprst.views.ResultView;

@InjectViewState
public class ResultPresenter extends MvpPresenter<ResultView> {
    public static final String TAG = "ResultPresenter";
    private Item model;

    public ResultPresenter(Item item) {
        super();
        model = item;
    }

    protected void updateView() {
        Log.d("Loggy", "start updating");
        if (model == null) {
            Log.d("Loggy", "stop updating, null model");
            return;
        }
        getViewState().setResultItemTitle(model.getTitle());

        getViewState().setResultItemImage(model.getLink());


        Log.d("Loggy", "finish updating");
    }

}
