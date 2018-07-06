package mrth.legion.joprst;

import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import mrth.legion.joprst.models.Result;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Api {
    @GET("/customsearch/v1")
    Observable<Result> getData(@Query("q") String userRequest, @Query("cx") String cx, @Query("key") String key, @Query("searchType") String searchType, @Query("imgSize") String imgSize);
}
