package mrth.legion.joprst.presenters;

import android.util.Log;

import com.arellomobile.mvp.InjectViewState;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import mrth.legion.joprst.App;
import mrth.legion.joprst.models.Item;
import mrth.legion.joprst.models.Result;
import mrth.legion.joprst.views.MainView;

@InjectViewState
public class ResultsPresenter extends BasePresenter<MainView> {

    private static final String KEY = "AIzaSyBhyyGlpv18LFbwNKKrYh15Sl3BKQNw0Xo";
    private static final String CX = "016576717547248085790:zpizgomjgu8";

    @Inject
    GoogleService mService;

    
    public ResultsPresenter() {
        App.getAppComponent().inject(this);
    }

   /* protected void updateView() {
        if (model.size() == 0) {
            getViewState().showEmpty();
        } else {
            Log.d("Loggy", "start showing");
            getViewState().showItems(model);
            Log.d("Loggy", "finish updating");
        }
    }

    public void bindView(MainView view, String userQuery) {
        Log.d("Loggy", "start binding view");
        super.bindView(view);
        if (userQuery != "") {
            loadData(userQuery, false);
        }
        Log.d("Loggy", "finish getting component");
    }*/

    private void loadData(String requestUser,  boolean isPageLoading) {
        Log.d("Loggy", "start getting data");

        final Observable<Result> observable = mService.getQuery(requestUser);

        Disposable subscription = observable
                .compose(mrth.legion.joprst.common.Utils.applySchedulers())
                .subscribe(items -> {
                    onLoadingSuccess(isPageLoading, items.getItems());
                }, error -> {
                    onLoagingFailed(isPageLoading, error);
                });

        unsubscribeOnDestroy(subscription);

//        App.getApi().getData(requestUser, CX, KEY, "image", "medium").enqueue(new Callback<Result>() {
//            @Override
//            public void onResponse(Call<Result> call, Response<Result> response) {
//                if (model != null) {
//                    model.clear();
//                    updateView();
//                }
//                if (response.body() != null)
//                {
//                    Log.d("Loggy","подгрузка начата");
//                    model = new ArrayList<>();
//                    Log.d("Loggy", response.body().toString());
//                    if (Long.parseLong(response.body().getSearchInformation().getTotalResults()) > 0) {
//                        Log.d("Loggy","Inputing elements");
//                        model.addAll(response.body().getItems());
//                    } else {
//                        Log.d("Loggy","nothing to input");
//                        view().showEmpty();
//                    }
//
//                    setModel(model);
//                    Log.d("Loggy","подгрузка закончена");
//                //    updateView();
//                    Log.d("Loggy","обновление view закончено");
//                    updateView();
//                }
//            }
//
//            @Override
//            public void onFailure(Call<Result> call, Throwable t) {
//            }
//        });
//        Log.d("Loggy", "finish getting component");

    }

    private void onLoadingSuccess( boolean isPageLoading, List<Item> items) {
        if (isPageLoading) {
            getViewState().addItems(items);
        } else {
            getViewState().showItems(items);
        }
    }
    private void onLoagingFailed( boolean isPageLoading, Throwable error) {
        getViewState().showEmpty();
    }



}
