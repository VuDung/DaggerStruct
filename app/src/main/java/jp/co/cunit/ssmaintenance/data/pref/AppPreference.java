package jp.co.cunit.ssmaintenance.data.pref;

import android.content.Context;

/**
 * Created by CUSDungVT on 3/7/2017.
 */

public class AppPreference {
  private PreferenceUtils preferenceUtils;

  public AppPreference(Context context){
    preferenceUtils = new PreferenceUtils(context);
  }

}
