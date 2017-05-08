package jp.co.cunit.ssmaintenance;

import android.app.Application;
import android.content.Context;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;
import jp.co.cunit.ssmaintenance.data.api.MaintenanceService;
import jp.co.cunit.ssmaintenance.data.model.UserModel;
import jp.co.cunit.ssmaintenance.data.pref.AppPreference;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by CUSDungVT on 4/21/2017.
 */
@Module
public class AppSingletonModule {
  private final Application application;
  public AppSingletonModule(Application application){
    this.application = application;
  }

  @Singleton
  @Provides Context provideContext(){
    return application;
  }

  @Singleton
  @Provides AppPreference provideAppPreference(){
    return new AppPreference(application);
  }

  @Singleton
  @Provides OkHttpClient provideHttpClient(){
    final OkHttpClient.Builder builder = new OkHttpClient.Builder();
    if(BuildConfig.DEBUG){
      final HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
      loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BASIC);
      builder.addInterceptor(loggingInterceptor);
    }
    return builder.followRedirects(false).build();
  }

  @Singleton
  @Provides MaintenanceService provideMaintenanceService(OkHttpClient httpClient){
    return createRestService(httpClient, MaintenanceService.ENDPOINT, MaintenanceService.class);
  }

  @Singleton
  @Provides
  UserModel providerUserModel(MaintenanceService maintenanceService){
    return new UserModel(maintenanceService);
  }

  private <T> T createRestService(OkHttpClient httpClient, String baseUrl, Class<T> serviceClass){
    final Gson gson = new GsonBuilder().create();
    Retrofit retrofit = new Retrofit.Builder()
        .baseUrl(baseUrl)
        .client(httpClient)
        .addConverterFactory(GsonConverterFactory.create(gson))
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build();
    return retrofit.create(serviceClass);
  }
}
