package com.century.weather.feature.main;

import com.century.weather.App;
import com.century.weather.common.base.DaggerActivity;
import com.century.weather.common.dagger.DaggerComponentFactory;

/**
 * Created by CUSDungVT on 4/21/2017.
 */

public class MainActivity extends DaggerActivity<MainComponent>{

  @Override protected DaggerComponentFactory<MainComponent> daggerComponentFactory() {
    return () -> App.get(this).getAppComponent().plus(new MainModule());
  }


}
