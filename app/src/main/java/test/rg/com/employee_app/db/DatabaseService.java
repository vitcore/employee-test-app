package test.rg.com.employee_app.db;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;
import rx.Observable;
import test.rg.com.employee_app.ui.model.Employee;

/**
 * DB Service.
 */
public class DatabaseService {

  /**
   * Creates a Observable that finds all Employee models.
   *
   * @return Observable.
   */
  public Observable<List<Employee>> findAllEmployees() {
    Realm realm = Realm.getDefaultInstance();
    RealmResults<RealmEmployee> all = realm.where(RealmEmployee.class).findAll();
    List<Employee> employees = new ArrayList<>();
    for (RealmEmployee realmEmployee : all) {
      employees.add(new Employee(realmEmployee));
    }
    return Observable.just(employees);
  }

  /**
   * Saves the list of {@link RealmEmployee}s and returns them from db.
   *
   * @param realmEmployees list of {@link RealmEmployee}s.
   * @return Observable.
   */
  public Observable<List<Employee>> saveEmployees(final List<RealmEmployee> realmEmployees) {
    Realm realm = Realm.getDefaultInstance();
    realm.beginTransaction();
    // delete all previous
    realm.delete(RealmEmployee.class);
    // insert the new ones.
    realm.insertOrUpdate(realmEmployees);
    realm.commitTransaction();
    return findAllEmployees();
  }
}
