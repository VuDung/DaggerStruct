package jp.co.cunit.ssmaintenance.feature.main;

import dagger.Subcomponent;
import jp.co.cunit.ssmaintenance.ActivityScope;

/**
 * Created by CUSDungVT on 4/21/2017.
 */
@ActivityScope
@Subcomponent(modules = MainModule.class)
public interface MainComponent {
  void inject(MainActivity mainActivity);
}
