package jp.co.cunit.ssmaintenance.feature.login;

import com.jakewharton.rxbinding2.widget.TextViewEditorActionEvent;
import io.reactivex.Observable;
import jp.co.cunit.ssmaintenance.common.mvp.MvpView;

/**
 * Created by CUSDungVT on 4/28/2017.
 */

public interface LoginView extends MvpView{

  Observable<CharSequence> constractCodeChange();
  Observable<CharSequence> loginIdChange();
  Observable<CharSequence> passwordChange();
  Observable<TextViewEditorActionEvent> actionDone();
  Observable<Object> actionSubmit();

  void renderLoading(boolean loading);
  void renderSuccess();
  void renderError();
}
