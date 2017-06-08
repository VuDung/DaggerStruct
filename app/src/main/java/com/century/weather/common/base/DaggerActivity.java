package com.century.weather.common.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import com.century.weather.common.dagger.DaggerComponentFactory;
import com.century.weather.common.dagger.DaggerLifecycleDelegate;

/**
 * Created by CUSDungVT on 4/21/2017.
 */

public abstract class DaggerActivity<DaggerComponent> extends BaseActivity{

  private DaggerLifecycleDelegate<DaggerComponent> daggerLifecycleDelegate;

  protected abstract DaggerComponentFactory<DaggerComponent> daggerComponentFactory();

  @Override public Object onRetainCustomNonConfigurationInstance() {
    return daggerLifecycleDelegate.onRetainCustomNonConfigurationInstance();
  }

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    daggerLifecycleDelegate = new DaggerLifecycleDelegate<>(daggerComponentFactory());
    daggerLifecycleDelegate.onCreate(this);
  }

  protected final DaggerComponent daggerComponent(){
    return daggerLifecycleDelegate.daggerComponent();
  }


}
