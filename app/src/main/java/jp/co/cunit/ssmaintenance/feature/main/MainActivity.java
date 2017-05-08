package jp.co.cunit.ssmaintenance.feature.main;

import jp.co.cunit.ssmaintenance.App;
import jp.co.cunit.ssmaintenance.common.base.DaggerActivity;
import jp.co.cunit.ssmaintenance.common.dagger.DaggerComponentFactory;

/**
 * Created by CUSDungVT on 4/21/2017.
 */

public class MainActivity extends DaggerActivity<MainComponent>{

  @Override protected DaggerComponentFactory<MainComponent> daggerComponentFactory() {
    return () -> App.get(this).getAppComponent().plus(new MainModule());
  }


}
