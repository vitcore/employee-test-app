package test.rg.com.employee_app.ui.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import rx.Observer;
import rx.Subscription;
import test.rg.com.employee_app.service.EmployeeService;
import test.rg.com.employee_app.R;
import test.rg.com.employee_app.ui.model.Employee;

/**
 * The Main Activity.
 */
public class MainActivity extends AppCompatActivity {

  private static final String TAG = MainActivity.class.getName();
  private List<Employee> employeeList = new ArrayList<>();
  private Subscription subscription;
  private RecyclerView recyclerView;
  private View emptyListView;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    recyclerView = findViewById(R.id.recycler_view);
    emptyListView = findViewById(R.id.empty_view);

    final EmployeesAdapter employeesAdapter = new EmployeesAdapter(employeeList);
    RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
    recyclerView.setLayoutManager(mLayoutManager);
    recyclerView.setItemAnimator(new DefaultItemAnimator());
    recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
    recyclerView.setAdapter(employeesAdapter);

    recyclerView.addOnItemTouchListener(
      new RecyclerTouchListener(getApplicationContext(), new RecyclerTouchListener.ClickListener() {
        @Override
        public void onClick(View view, int position) {
          Employee employee = employeeList.get(position);
          Intent intent = new Intent(MainActivity.this, EmployeeDetailsActivity.class);
          intent.putExtra(EmployeeDetailsActivity.EMPLOYEE_EXTRA, employee);
          startActivity(intent);
        }
      }));

    prepareData(employeesAdapter);

    FloatingActionButton fab = findViewById(R.id.fab);
    fab.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        prepareData(employeesAdapter);
      }
    });
  }

  private void prepareData(final EmployeesAdapter employeesAdapter) {
    subscription = new EmployeeService().getEmployees().subscribe(new Observer<List<Employee>>() {
      @Override
      public void onCompleted() {
        Log.d(TAG, "onCompleted()");
      }

      @Override
      public void onError(Throwable e) {
        Log.e(TAG, "onError()", e);
      }

      @Override
      public void onNext(List<Employee> employees) {
        Log.d(TAG, "onNext()");
        if (employees != null && employees.size() > 0) {
          recyclerView.setVisibility(View.VISIBLE);
          emptyListView.setVisibility(View.GONE);
          employeeList.clear();
          employeeList.addAll(employees);
          employeesAdapter.notifyDataSetChanged();
        } else {
          recyclerView.setVisibility(View.GONE);
          emptyListView.setVisibility(View.VISIBLE);
        }
      }
    });
  }

  @Override
  protected void onDestroy() {
    if (subscription != null && !subscription.isUnsubscribed()) {
      subscription.unsubscribe();
    }
    super.onDestroy();
  }
}
