package jp.co.cunit.ssmaintenance.feature.login;

import io.reactivex.Observable;
import jp.co.cunit.ssmaintenance.common.mvp.MvpPresenter;
import jp.co.cunit.ssmaintenance.data.model.UserModel;
import jp.co.cunit.ssmaintenance.data.validator.EmailValidator;

/**
 * Created by CUSDungVT on 4/28/2017.
 */

public class LoginPresenter extends MvpPresenter<LoginView> {
  private UserModel userModel;
  private EmailValidator emailInvalid;
  LoginPresenter(UserModel userModel){
    this.userModel = userModel;
  }

  @Override protected void onViewAttached() {
    super.onViewAttached();
    final LoginView view = getView();

    Observable<CharSequence> constractCode$ = view.constractCodeChange();
    Observable<CharSequence> loginId$ = view.loginIdChange();
    Observable<CharSequence> password$ = view.passwordChange();


  }

}
