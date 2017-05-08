package jp.co.cunit.ssmaintenance.common.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import jp.co.cunit.ssmaintenance.common.mvp.MvpLifeCycleDelegate;
import jp.co.cunit.ssmaintenance.common.mvp.MvpPresenter;
import jp.co.cunit.ssmaintenance.common.mvp.MvpView;

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
