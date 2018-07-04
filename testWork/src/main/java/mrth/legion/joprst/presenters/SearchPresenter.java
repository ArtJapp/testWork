package mrth.legion.joprst.presenters;

import android.util.Log;

import java.util.List;

import mrth.legion.joprst.Api;
import mrth.legion.joprst.App;
import mrth.legion.joprst.Item;
import mrth.legion.joprst.Result;
import mrth.legion.joprst.views.ResultView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SearchPresenter extends BasePresenter<Item, ResultView> {

    Item result;

    @Override
    protected void updateView() {
        Log.d("Blet", "start updating");

        view().setResultItems(result);
        Log.d("Blet", "finish updating");
    }

}
