package com.century.weather.common.dagger;

/**
 * Created by CUSDungVT on 4/21/2017.
 */

public interface DaggerComponentFactory<DaggerComponent> {
  DaggerComponent makeComponent();
}
