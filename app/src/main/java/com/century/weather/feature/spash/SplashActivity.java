package com.century.weather.feature.spash;

import android.os.Bundle;
import android.support.annotation.Nullable;
import com.century.weather.R;
import javax.inject.Inject;
import com.century.weather.App;
import com.century.weather.common.base.MvpActivity;
import com.century.weather.common.dagger.DaggerComponentFactory;
import com.century.weather.common.mvp.MvpPresenter;

/**
 * Created by CUSDungVT on 4/21/2017.
 */

public class SplashActivity extends MvpActivity<SplashComponent, SplashView>
    implements SplashView {

  @Inject SplashPresenter splashPresenter;

  @Override protected DaggerComponentFactory<SplashComponent> daggerComponentFactory() {
    return () -> App.get(SplashActivity.this).getAppComponent().plus(new SplashModule());
  }

  @Override protected void injectDependencies() {
    daggerComponent().inject(this);
  }

  @Override protected MvpPresenter<SplashView> mvpPresenter() {
    return splashPresenter;
  }

  @Override protected SplashView mvpView() {
    return this;
  }

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_splash);
    bindViews();


  }
}
