package mrth.legion.joprst.presenters;

import android.util.Log;

import com.arellomobile.mvp.InjectViewState;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import mrth.legion.joprst.App;
import mrth.legion.joprst.GoogleSearchComponent;
import mrth.legion.joprst.common.Utils;
import mrth.legion.joprst.models.Item;
import mrth.legion.joprst.models.Result;
import mrth.legion.joprst.views.ResultsView;

@InjectViewState
public class ResultsPresenter extends BasePresenter<ResultsView> {

    public static final String TAG = "ResultsPresenter";

    private static final String KEY = "AIzaSyBhyyGlpv18LFbwNKKrYh15Sl3BKQNw0Xo";
    private static final String CX = "016576717547248085790:zpizgomjgu8";

    @Inject
    GoogleService mService;


    public ResultsPresenter() {
        GoogleSearchComponent g =  App.getAppComponent();
        //g.inject(this);
    }


   public void loadResults(String uRequest) {
       loadData(uRequest, false);
   }

    private void loadData(String requestUser,  boolean isPageLoading) {
        Log.d("Loggy", "start getting data");
        Log.d("Pis", "user request is " + requestUser);

        Log.d("Pis", "Start subscription");

        /*Subscription subscription = observable
                .compose(Utils.applySchedulers())
                .subscribe(repositories -> {
                    Log.d("Pis", "Success loading");
                    onLoadingSuccess(isPageLoading, repositories.getItems());
                }, error -> {
                    Log.d("Pis", "Failed loading");
                    error.printStackTrace();
                    onLoagingFailed(isPageLoading, error);
                });
*/
        final Observable<Result> observable = //mService.getQuery(requestUser);
            App.getApi().getData("cat", CX, KEY,"image", "large");
        Disposable subscription = observable
                .compose(mrth.legion.joprst.common.Utils.applySchedulers())
                .subscribe(items -> {
                    Log.d("Pis", "Success loading");
                    onLoadingSuccess(isPageLoading, items.getItems());
                }, error -> {
                    Log.d("Pis", "Failed loading");
                    error.printStackTrace();
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

            System.out.println("Easy Beasy");
            for (Item x : items) {
                System.out.println("New item " + x.getTitle());
            }
        } else {
            getViewState().showItems(items);
            System.out.println("Easy Beasy");
            for (Item x : items) {
                System.out.println("New item " + x.getTitle());
            }
        }
    }
    private void onLoagingFailed( boolean isPageLoading, Throwable error) {
        getViewState().showEmpty();
    }



}
