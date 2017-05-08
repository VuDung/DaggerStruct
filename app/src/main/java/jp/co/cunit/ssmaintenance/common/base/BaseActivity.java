package jp.co.cunit.ssmaintenance.common.base;

import android.support.v7.app.AppCompatActivity;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by CUSDungVT on 4/21/2017.
 */

public class BaseActivity extends AppCompatActivity {
  private Unbinder unbinder;

  protected void bindViews() {
    unbinder = ButterKnife.bind(this);
  }

  @Override protected void onDestroy() {
    super.onDestroy();
    if (unbinder != null) {
      unbinder.unbind();
    }
  }
}
