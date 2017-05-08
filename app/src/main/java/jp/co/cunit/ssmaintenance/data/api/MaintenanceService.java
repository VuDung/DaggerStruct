package jp.co.cunit.ssmaintenance.data.api;

import io.reactivex.Single;
import retrofit2.http.Field;
import retrofit2.http.POST;

/**
 * Created by CUSDungVT on 4/21/2017.
 */

public interface MaintenanceService {
  String ENDPOINT = "http://admin.ssmaintenance.net/api/";

  @POST("login")
  Single<String> login(
      @Field("contract_code") String countryCode,
      @Field("account_kind") int accountKind,
      @Field("login_id") String loginId,
      @Field("password") String password);
}
