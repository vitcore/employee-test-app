package test.rg.com.employee_app.rest;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * The Retrofit Client Instance.
 */
public class RetrofitClientInstance {

  private static Retrofit retrofit;
  private static final String BASE_URL = "http://hiring.rewardgateway.net";

  /**
   * Returns an instance of retrofit.
   *
   * @return instance of retrofit.
   */
  public static Retrofit getRetrofitInstance() {
    if (retrofit == null) {
      OkHttpClient okHttpClient = new OkHttpClient.Builder().addInterceptor(
        new BasicAuthInterceptor("medium", "medium")).build();

      retrofit = new retrofit2.Retrofit.Builder().client(okHttpClient).baseUrl(BASE_URL).addConverterFactory(
        GsonConverterFactory.create()).addCallAdapterFactory(RxJavaCallAdapterFactory.create()).build();
    }
    return retrofit;
  }
}