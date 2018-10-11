package test.rg.com.employee_app.ui.view;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import test.rg.com.employee_app.R;
import test.rg.com.employee_app.ui.model.Employee;

/**
 * Adapter for the Employee list.
 */
public class EmployeesAdapter extends RecyclerView.Adapter<EmployeesAdapter.EmployeeViewHolder> {

  private List<Employee> employeeList;

  /**
   * View Holder.
   */
  public class EmployeeViewHolder extends RecyclerView.ViewHolder {
    private ImageView avatar;
    private TextView name;
    private TextView company;

    /**
     * Default constructor.
     *
     * @param view item view.
     */
    public EmployeeViewHolder(View view) {
      super(view);
      avatar = view.findViewById(R.id.avatar);
      name = view.findViewById(R.id.name);
      company = view.findViewById(R.id.company);
    }
  }

  /**
   * Employee adapter constructor.
   *
   * @param employeeList the employee list.
   */
  public EmployeesAdapter(List<Employee> employeeList) {
    this.employeeList = employeeList;
  }

  @Override
  public EmployeeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.empoyee_list_row, parent, false);

    return new EmployeeViewHolder(itemView);
  }

  @Override
  public void onBindViewHolder(EmployeeViewHolder holder, int position) {
    Employee employee = employeeList.get(position);
    Picasso.with(holder.avatar.getContext()).load(employee.getAvatar()).fit().centerCrop().placeholder(
      R.drawable.user_blank).error(R.drawable.user_blank).into(holder.avatar);
    holder.name.setText(employee.getName());
    holder.company.setText(employee.getCompany());
  }

  @Override
  public int getItemCount() {
    return employeeList.size();
  }
}
