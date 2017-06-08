package com.century.weather.feature.spash;

import dagger.Module;
import dagger.Provides;

/**
 * Created by CUSDungVT on 4/21/2017.
 */
@Module
public class SplashModule {

  @Provides
  SplashPresenter provideSplashPresenter(){
    return new SplashPresenter();
  }
}
