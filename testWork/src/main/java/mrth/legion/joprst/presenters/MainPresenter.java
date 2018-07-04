package mrth.legion.joprst.presenters;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import mrth.legion.joprst.App;
import mrth.legion.joprst.Item;
import mrth.legion.joprst.Result;
import mrth.legion.joprst.views.MainView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainPresenter extends BasePresenter<List<Item>, MainView> {

    private static final String KEY = "AIzaSyBhyyGlpv18LFbwNKKrYh15Sl3BKQNw0Xo";
    private static final String CX = "016576717547248085790:zpizgomjgu8";

    @Override
    protected void updateView() {
        if (model.size() == 0) {
            view().showEmpty();
        } else {
            Log.d("Blet", "start showing");
            view().showResults(model);
            Log.d("Blet", "finish updating");
        }
    }

    public void bindView(MainView view,String userQuery) {
        Log.d("Blet", "start binding view");
        super.bindView(view);
        if (model == null && userQuery != "") {
            loadData(userQuery);
        }
        Log.d("Blet", "finish getting component");
    }

    private void loadData(String requestUser) {
        Log.d("Blet", "start getting data");
        App.getApi().getData(requestUser, CX, KEY, "image", "medium").enqueue(new Callback<Result>() {
            @Override
            public void onResponse(Call<Result> call, Response<Result> response) {
                if (model != null) {
                    model.clear();
                }
                if (response.body() != null)
                {
                    Log.d("Blet","подгрузка начата");
                    model = new ArrayList<>();
                    model.addAll(response.body().getItems());
                    setModel(model);
                    Log.d("Blet","подгрузка закончена");
                //    updateView();
                    Log.d("Blet","обновление view закончено");
                }
            }

            @Override
            public void onFailure(Call<Result> call, Throwable t) {
                view().showEmpty();
            }
        });
        Log.d("Blet", "finish getting component");

    }
}
