package com.century.weather.data.model;

import android.support.annotation.WorkerThread;
import io.reactivex.Single;
import com.century.weather.data.api.MaintenanceService;

/**
 * Created by CUSDungVT on 4/25/2017.
 */

public class UserModel {
  private MaintenanceService maintenanceService;

  public UserModel(MaintenanceService maintenanceService){
    this.maintenanceService = maintenanceService;
  }

  @WorkerThread
  public Single<String> login(String countryCode, int accountKind, String loginId, String password){
    return maintenanceService.login(countryCode, accountKind, loginId, password);
  }
}
