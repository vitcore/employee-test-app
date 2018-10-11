package test.rg.com.employee_app.rest;

import java.util.List;

import retrofit2.http.GET;
import rx.Observable;


/**
 * Definitions of endpoints.
 */
public interface GetDataService {

  @GET("/list")
  Observable<List<EmployeeResponseModel>> getAllEmployees();
}