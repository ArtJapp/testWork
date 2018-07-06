package mrth.legion.joprst.common;

import android.util.Log;

import io.reactivex.ObservableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;


/**
 * Date: 11.01.2017
 * Time: 16:39
 *
 * @author Yuri Shmakov
 */

public class Utils {

    public static <T> ObservableTransformer<T, T> applySchedulers() {
        Log.d("Bleaar", "applying schedulers");

        return observable -> observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}