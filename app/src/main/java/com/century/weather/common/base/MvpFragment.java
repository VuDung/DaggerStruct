package com.century.weather.common.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import com.century.weather.common.mvp.MvpLifeCycleDelegate;
import com.century.weather.common.mvp.MvpPresenter;
import com.century.weather.common.mvp.MvpView;

/**
 * Created by CUSDungVT on 5/15/2017.
 */

public abstract class MvpFragment<DaggerComponent, V extends MvpView>
    extends DaggerFragment<DaggerComponent> {
  private MvpLifeCycleDelegate<V> mvpLifeCycleDelegate;

  protected abstract void injectDependencies();

  protected abstract MvpPresenter<V> mvpPresenter();

  protected abstract V mvpView();

  @Override public void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    injectDependencies();
    mvpLifeCycleDelegate = new MvpLifeCycleDelegate<>(mvpPresenter(), mvpView());
  }

  @Override public void onStart() {
    super.onStart();
    mvpLifeCycleDelegate.onStart();
  }

  @Override public void onStop() {
    super.onStop();
    mvpLifeCycleDelegate.onStop();
  }
}