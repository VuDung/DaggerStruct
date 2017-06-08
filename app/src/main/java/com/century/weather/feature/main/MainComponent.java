package com.century.weather.feature.main;

import dagger.Subcomponent;
import com.century.weather.ActivityScope;

/**
 * Created by CUSDungVT on 4/21/2017.
 */
@ActivityScope
@Subcomponent(modules = MainModule.class)
public interface MainComponent {
  void inject(MainActivity mainActivity);
}
