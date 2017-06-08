package com.century.weather;

import android.app.Application;
import android.content.Context;

/**
 * Created by CUSDungVT on 4/21/2017.
 */

public class App extends Application{
  private AppComponent appComponent;

  @Override public void onCreate() {
    super.onCreate();
    appComponent = makeAppComponent();
  }

  public static App get(Context context){
    return (App)context.getApplicationContext();
  }
  public AppComponent getAppComponent(){
    return appComponent;
  }

  private AppComponent makeAppComponent(){
    return DaggerAppComponent.builder()
        .appModule(new AppModule())
        .appSingletonModule(new AppSingletonModule(this))
        .build();
  }
}
