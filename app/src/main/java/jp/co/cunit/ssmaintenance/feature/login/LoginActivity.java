package jp.co.cunit.ssmaintenance.feature.login;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.widget.AppCompatButton;
import android.view.inputmethod.EditorInfo;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.jakewharton.rxbinding2.view.RxView;
import com.jakewharton.rxbinding2.widget.RxTextView;
import com.jakewharton.rxbinding2.widget.TextViewEditorActionEvent;
import io.reactivex.Observable;
import javax.inject.Inject;
import jp.co.cunit.ssmaintenance.App;
import jp.co.cunit.ssmaintenance.R;
import jp.co.cunit.ssmaintenance.common.base.MvpActivity;
import jp.co.cunit.ssmaintenance.common.dagger.DaggerComponentFactory;
import jp.co.cunit.ssmaintenance.common.mvp.MvpPresenter;

/**
 * Created by CUSDungVT on 4/21/2017.
 */

public class LoginActivity extends MvpActivity<LoginComponent, LoginView>
    implements LoginView {

  @Inject LoginPresenter loginPresenter;

  @BindView(R.id.edtConstractCode) TextInputEditText edtConstractCode;
  @BindView(R.id.tilConstractCode) TextInputLayout tilConstractCode;
  @BindView(R.id.edtLoginId) TextInputEditText edtLoginId;
  @BindView(R.id.tilLoginId) TextInputLayout tilLoginId;
  @BindView(R.id.edtPassword) TextInputEditText edtPassword;
  @BindView(R.id.tilPassword) TextInputLayout tilPassword;
  @BindView(R.id.btnLogin) AppCompatButton btnLogin;

  @Override protected DaggerComponentFactory<LoginComponent> daggerComponentFactory() {
    return () -> App.get(LoginActivity.this).getAppComponent().plus(new LoginModule());
  }

  @Override protected void injectDependencies() {
    daggerComponent().inject(this);
  }

  @Override protected MvpPresenter<LoginView> mvpPresenter() {
    return loginPresenter;
  }

  @Override protected LoginView mvpView() {
    return this;
  }

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_login);
    bindViews();


  }

  @Override public Observable<CharSequence> constractCodeChange() {
    return RxTextView.textChanges(edtConstractCode);
  }

  @Override public Observable<CharSequence> loginIdChange() {
    return RxTextView.textChanges(edtLoginId);
  }

  @Override public Observable<CharSequence> passwordChange() {
    return RxTextView.textChanges(edtPassword);
  }

  @Override public Observable<TextViewEditorActionEvent> actionDone() {
    return RxTextView.editorActionEvents(edtPassword);
  }

  @Override public Observable<Object> actionSubmit() {
    return RxView.clicks(btnLogin);
  }

  @Override public void renderLoading(boolean loading) {

  }

  @Override public void renderSuccess() {

  }

  @Override public void renderError() {

  }
}
