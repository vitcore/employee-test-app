package test.rg.com.employee_app.ui.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.text.Spanned;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import test.rg.com.employee_app.R;
import test.rg.com.employee_app.ui.model.Employee;

public class EmployeeDetailsActivity extends AppCompatActivity {

  public static final String EMPLOYEE_EXTRA = "employee_extra_data";

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_employee_details);

    Employee employee = (Employee) getIntent().getSerializableExtra(EMPLOYEE_EXTRA);

    ImageView avatarImageView = findViewById(R.id.avatar);
    TextView nameTextView = findViewById(R.id.name);
    TextView companyTextView = findViewById(R.id.company);
    TextView titleTextView = findViewById(R.id.title);
    TextView bioTextView = findViewById(R.id.bio);

    Picasso.with(this).load(employee.getAvatar()).fit().centerCrop().placeholder(R.drawable.user_blank).error(
      R.drawable.user_blank).into(avatarImageView);
    nameTextView.setText(employee.getName());
    companyTextView.setText(employee.getCompany());
    titleTextView.setText(employee.getTitle());
    Spanned html;
    if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
      html = Html.fromHtml(employee.getBio(), Html.FROM_HTML_MODE_COMPACT);
    } else {
      html = Html.fromHtml(employee.getBio());
    }
    bioTextView.setText(html);
  }
}
