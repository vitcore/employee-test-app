package test.rg.com.employee_app.rest;

import java.util.List;

import rx.Observable;

/**
 * Rest service.
 */
public class RestService {

  private final GetDataService service;

  /**
   * Default constructor.
   */
  public RestService() {
    service = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);
  }

  /**
   * Creates an observable to get all employees from the api.
   *
   * @return observable.
   */
  public Observable<List<EmployeeResponseModel>> getAllEmployees() {
    return service.getAllEmployees();
  }
}
