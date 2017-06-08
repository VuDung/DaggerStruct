package com.century.weather.feature.spash;

import dagger.Subcomponent;
import com.century.weather.ActivityScope;

/**
 * Created by CUSDungVT on 4/21/2017.
 */
@ActivityScope
@Subcomponent(modules = SplashModule.class)
public interface SplashComponent {
  void inject(SplashActivity splashActivity);
}
