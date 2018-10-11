package test.rg.com.employee_app.rest;

import java.io.IOException;

import okhttp3.Credentials;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Interceptor for Basic Authentication.
 */
public class BasicAuthInterceptor implements Interceptor {

  private String credentials;

  /**
   * Constructor for the interceptor.
   *
   * @param user username
   * @param password password
   */
  public BasicAuthInterceptor(String user, String password) {
    this.credentials = Credentials.basic(user, password);
  }

  @Override
  public Response intercept(Chain chain) throws IOException {
    Request request = chain.request();
    Request authenticatedRequest = request.newBuilder().header("Authorization", credentials).build();
    return chain.proceed(authenticatedRequest);
  }

}