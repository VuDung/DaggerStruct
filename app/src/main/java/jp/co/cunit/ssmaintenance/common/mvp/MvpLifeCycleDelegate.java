package jp.co.cunit.ssmaintenance.common.mvp;

/**
 * Created by CUSDungVT on 4/28/2017.
 */

public class MvpLifeCycleDelegate<V extends MvpView> {
  private MvpPresenter<V> mvpPresenter;
  private V mvpView;

  public MvpLifeCycleDelegate(MvpPresenter<V> mvpPresenter, V view){
    this.mvpPresenter = mvpPresenter;
    this.mvpView = view;
  }

  public void onStart(){
    mvpPresenter.attachView(mvpView);
  }

  public void onStop(){
    mvpPresenter.detachView();
  }
}
