package mrth.legion.joprst.presenters;


import io.reactivex.Observable;
import mrth.legion.joprst.Api;
import mrth.legion.joprst.models.Item;
import mrth.legion.joprst.models.Result;

public class GoogleService {
    private Api mApi;
    private static final String KEY = "AIzaSyBhyyGlpv18LFbwNKKrYh15Sl3BKQNw0Xo";
    private static final String CX = "016576717547248085790:zpizgomjgu8";

    public GoogleService(Api api) {
        mApi = api;
    }

    public Observable<Result> getQuery(String zapros) {
        return mApi.getData(zapros, CX, KEY, "image", "medium");

    }
}
