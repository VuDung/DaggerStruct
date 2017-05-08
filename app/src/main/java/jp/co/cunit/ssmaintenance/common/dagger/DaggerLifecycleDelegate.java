package jp.co.cunit.ssmaintenance.common.dagger;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by CUSDungVT on 4/21/2017.
 */

public class DaggerLifecycleDelegate<DaggerComponent> {
  private DaggerComponent daggerComponent;

  private DaggerComponentFactory<DaggerComponent> daggerComponentFactory;

  public DaggerLifecycleDelegate(
      DaggerComponentFactory<DaggerComponent> daggerComponentFactory) {
    this.daggerComponentFactory = daggerComponentFactory;
  }

  @SuppressWarnings("unchecked")
  public void onCreate(AppCompatActivity appCompatActivity){
    daggerComponent = (DaggerComponent)appCompatActivity.getLastCustomNonConfigurationInstance();
    if(daggerComponent == null){
      daggerComponent = daggerComponentFactory.makeComponent();
    }
  }

  public Object onRetainCustomNonConfigurationInstance(){
    return daggerComponent;
  }

  public DaggerComponent daggerComponent(){
    return daggerComponent;
  }
}
