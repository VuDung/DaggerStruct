package jp.co.cunit.ssmaintenance.common.base;

import android.content.Context;

/**
 * DaggerFragment must be attach on DaggerActivity
 */
public abstract class DaggerFragment<DaggerComponent> extends BaseFragment {

  @Override public void onAttach(Context context) {
    super.onAttach(context);
    if (!(context instanceof DaggerActivity)) {
      throw new IllegalStateException(getClass().getName()
          + " must be attach on Activity instance of DaggerActivity");
    }
  }

  @SuppressWarnings("unchecked")
  protected final DaggerComponent daggerComponent() {
    DaggerActivity<DaggerComponent> daggerActivity =
        (DaggerActivity<DaggerComponent>) getActivity();
    return daggerActivity.daggerComponent();
  }
}
