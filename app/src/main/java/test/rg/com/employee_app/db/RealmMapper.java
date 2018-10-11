package test.rg.com.employee_app.db;

import java.util.ArrayList;
import java.util.List;

import test.rg.com.employee_app.rest.EmployeeResponseModel;

/**
 * Realm db mapper.
 */
public final class RealmMapper {

  /**
   * Mpas a list of {@link EmployeeResponseModel}s into List of {@link RealmEmployee}s.
   *
   * @param employeeResponseModels the input list.
   * @return list od db models.
   */
  public static final List<RealmEmployee> mapList(List<EmployeeResponseModel> employeeResponseModels) {
    List<RealmEmployee> realmEmployees = new ArrayList<>();
    for (EmployeeResponseModel employeeResponseModel : employeeResponseModels) {
      realmEmployees.add(mapToRealmEmployee(employeeResponseModel));
    }
    return realmEmployees;
  }

  private static final RealmEmployee mapToRealmEmployee(EmployeeResponseModel employee) {
    RealmEmployee realmEmployee = new RealmEmployee(employee.getUuid(), employee.getCompany(), employee.getName());
    realmEmployee.setAvatar(employee.getAvatar());
    realmEmployee.setBio(employee.getBio());
    realmEmployee.setTitle(employee.getTitle());

    return realmEmployee;
  }
}
