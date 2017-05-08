package jp.co.cunit.ssmaintenance.feature.login;

import dagger.Module;
import dagger.Provides;
import jp.co.cunit.ssmaintenance.data.model.UserModel;

/**
 * Created by CUSDungVT on 4/21/2017.
 */
@Module
public class LoginModule {

  @Provides
  LoginPresenter provideLoginPresenter(UserModel userModel){
    return new LoginPresenter(userModel);
  }
}
