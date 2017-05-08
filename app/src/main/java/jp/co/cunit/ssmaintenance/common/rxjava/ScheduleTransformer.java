package jp.co.cunit.ssmaintenance.common.rxjava;

import io.reactivex.ObservableTransformer;
import io.reactivex.SingleTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by CUSDungVT on 5/3/2017.
 */

public class ScheduleTransformer {

  public static <T>SingleTransformer<T, T> singleIoToMain(){
    return upstream -> upstream.subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread());
  }

  public static <T>ObservableTransformer<T, T> observableIoToMain(){
    return upstream -> upstream.subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread());
  }


}
