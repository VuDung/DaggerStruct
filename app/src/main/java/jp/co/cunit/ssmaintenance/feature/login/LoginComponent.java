package jp.co.cunit.ssmaintenance.feature.login;

import dagger.Subcomponent;
import jp.co.cunit.ssmaintenance.ActivityScope;

/**
 * Created by CUSDungVT on 4/21/2017.
 */
@ActivityScope
@Subcomponent(modules = LoginModule.class)
public interface LoginComponent {
  void inject(LoginActivity loginActivity);
}
