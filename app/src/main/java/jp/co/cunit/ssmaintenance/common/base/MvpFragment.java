package jp.co.cunit.ssmaintenance.common.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import jp.co.cunit.ssmaintenance.common.mvp.MvpLifeCycleDelegate;
import jp.co.cunit.ssmaintenance.common.mvp.MvpPresenter;
import jp.co.cunit.ssmaintenance.common.mvp.MvpView;

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