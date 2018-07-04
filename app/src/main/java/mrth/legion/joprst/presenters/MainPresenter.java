package mrth.legion.joprst.presenters;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import mrth.legion.joprst.App;
import mrth.legion.joprst.models.Item;
import mrth.legion.joprst.models.Result;
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
            Log.d("Loggy", "start showing");
            view().showResults(model);
            Log.d("Loggy", "finish updating");
        }
    }

    public void bindView(MainView view,String userQuery) {
        Log.d("Loggy", "start binding view");
        super.bindView(view);
        if (userQuery != "") {
            loadData(userQuery);
        }
        Log.d("Loggy", "finish getting component");
    }

    private void loadData(String requestUser) {
        Log.d("Loggy", "start getting data");
        App.getApi().getData(requestUser, CX, KEY, "image", "medium").enqueue(new Callback<Result>() {
            @Override
            public void onResponse(Call<Result> call, Response<Result> response) {
                if (model != null) {
                    model.clear();
                    updateView();
                }
                if (response.body() != null)
                {
                    Log.d("Loggy","подгрузка начата");
                    model = new ArrayList<>();
                    Log.d("Loggy", response.body().toString());
                    if (Long.parseLong(response.body().getSearchInformation().getTotalResults()) > 0) {
                        Log.d("Loggy","Inputing elements");
                        model.addAll(response.body().getItems());
                    } else {
                        Log.d("Loggy","nothing to input");
                        view().showEmpty();
                    }

                    setModel(model);
                    Log.d("Loggy","подгрузка закончена");
                //    updateView();
                    Log.d("Loggy","обновление view закончено");
                    updateView();
                }
            }

            @Override
            public void onFailure(Call<Result> call, Throwable t) {
            }
        });
        Log.d("Loggy", "finish getting component");

    }





}
