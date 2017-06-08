package com.century.weather.common.mvp;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.lang.ref.WeakReference;

/**
 * Created by CUSDungVT on 4/27/2017.
 */

public class MvpPresenter<V extends MvpView> {
  private WeakReference<V> viewRef;
  private CompositeDisposable compositeDisposable;

  protected void onViewAttached(){
    //no-op
  }
  protected void onViewDetached(){
    //no-op
  }

  public void attachView(V view){
    this.viewRef = new WeakReference<>(view);
    this.onViewAttached();
  }

  public void detachView(){
    if(viewRef != null){
      viewRef.clear();
      viewRef = null;
    }
    if(compositeDisposable != null){
      compositeDisposable.clear();
      compositeDisposable = null;
    }
    this.onViewDetached();
  }

  public V getView(){
    return viewRef != null ? viewRef.get() : null;
  }

  protected void disposeOnDetach(Disposable disposable){
    if(compositeDisposable == null){
      compositeDisposable = new CompositeDisposable();
    }
    compositeDisposable.add(disposable);
  }
}
