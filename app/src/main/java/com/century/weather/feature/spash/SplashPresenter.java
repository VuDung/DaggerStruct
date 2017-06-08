package com.century.weather.feature.spash;

import com.century.weather.common.mvp.MvpPresenter;
import com.century.weather.data.validator.EmailValidator;

/**
 * Created by CUSDungVT on 4/28/2017.
 */

public class SplashPresenter extends MvpPresenter<SplashView> {
  private EmailValidator emailInvalid;
  SplashPresenter(){

  }

  @Override protected void onViewAttached() {
    super.onViewAttached();
    final SplashView view = getView();


  }

}
