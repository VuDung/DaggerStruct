package jp.co.cunit.ssmaintenance.common.base;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by CUSDungVT on 5/12/2017.
 */

public abstract class BaseFragment extends Fragment{
  private Unbinder unbinder;

  protected abstract @LayoutRes int layoutResId();

  @Nullable @Override
  public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {
    int layoutResId = layoutResId();
    if(layoutResId != 0){
      View view = inflater.inflate(layoutResId, container, false);
      unbinder = ButterKnife.bind(this, view);
      return view;
    }else {
      return super.onCreateView(inflater, container, savedInstanceState);
    }
  }

  @Override public void onDestroyView() {
    super.onDestroyView();
    if(unbinder != null){
      unbinder.unbind();
      unbinder = null;
    }
  }
}
