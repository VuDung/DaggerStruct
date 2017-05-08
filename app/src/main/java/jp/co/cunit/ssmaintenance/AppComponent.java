package jp.co.cunit.ssmaintenance;

import dagger.Component;
import javax.inject.Singleton;
import jp.co.cunit.ssmaintenance.feature.login.LoginComponent;
import jp.co.cunit.ssmaintenance.feature.login.LoginModule;
import jp.co.cunit.ssmaintenance.feature.main.MainComponent;
import jp.co.cunit.ssmaintenance.feature.main.MainModule;

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

  LoginComponent plus(LoginModule loginModule);
  MainComponent plus(MainModule mainModule);
}
