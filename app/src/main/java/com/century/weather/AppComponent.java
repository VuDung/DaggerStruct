package com.century.weather;

import dagger.Component;
import javax.inject.Singleton;
import com.century.weather.feature.spash.SplashComponent;
import com.century.weather.feature.spash.SplashModule;
import com.century.weather.feature.main.MainComponent;
import com.century.weather.feature.main.MainModule;

/**
 * Created by CUSDungVT on 4/21/2017.
 */
@Singleton
@Component(modules = {
    AppModule.class,
    AppSingletonModule.class
})
public interface AppComponent {
  void inject(App app);

  SplashComponent plus(SplashModule splashModule);
  MainComponent plus(MainModule mainModule);
}
