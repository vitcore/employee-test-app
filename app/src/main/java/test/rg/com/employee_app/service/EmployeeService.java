package test.rg.com.employee_app.service;

import java.util.List;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;
import test.rg.com.employee_app.db.DatabaseService;
import test.rg.com.employee_app.db.RealmMapper;
import test.rg.com.employee_app.ui.model.Employee;
import test.rg.com.employee_app.rest.EmployeeResponseModel;
import test.rg.com.employee_app.rest.RestService;

/**
 * Employees service.
 */
public class EmployeeService {

  private final RestService restService;
  private final DatabaseService databaseService;

  /**
   * Default constructor.
   */
  public EmployeeService() {
    databaseService = new DatabaseService();
    restService = new RestService();
  }

  /**
   * Creates an observable that triggers a rest api call. If the rest api call returns a valid response, it saves the
   * list of employees in db and returns the list of employees from the db. If the rest api call fails, it will try
   * to get the results from the db and return a list of employees.
   *
   * @return List of Employees.
   */
  public Observable<List<Employee>> getEmployees() {
    Observable<List<Employee>> apiEmployees = restService.getAllEmployees().flatMap(
      new Func1<List<EmployeeResponseModel>, Observable<List<Employee>>>() {
        @Override
        public Observable<List<Employee>> call(List<EmployeeResponseModel> employeeResponseModels) {
          return databaseService.saveEmployees(RealmMapper.mapList(employeeResponseModels)).subscribeOn(
            Schedulers.computation());
        }
      }).onErrorResumeNext(databaseService.findAllEmployees().subscribeOn(Schedulers.computation())).subscribeOn(
      Schedulers.io());
    return apiEmployees.observeOn(AndroidSchedulers.mainThread());
  }
}
