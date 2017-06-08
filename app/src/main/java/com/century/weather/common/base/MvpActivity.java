package com.century.weather.common.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import com.century.weather.common.mvp.MvpLifeCycleDelegate;
import com.century.weather.common.mvp.MvpPresenter;
import com.century.weather.common.mvp.MvpView;

/**
 * Created by CUSDungVT on 4/28/2017.
 */

public abstract class MvpActivity<DaggerComponent, V extends MvpView> extends DaggerActivity<DaggerComponent> {
  private MvpLifeCycleDelegate<V> mvpLifeCycleDelegate;

  protected abstract void injectDependencies();
  protected abstract MvpPresenter<V> mvpPresenter();
  protected abstract V mvpView();


  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    injectDependencies();
    mvpLifeCycleDelegate = new MvpLifeCycleDelegate<>(mvpPresenter(), mvpView());
  }

  @Override protected void onStart() {
    super.onStart();
    mvpLifeCycleDelegate.onStart();
  }

  @Override protected void onStop() {
    super.onStop();
    mvpLifeCycleDelegate.onStop();
  }
}
