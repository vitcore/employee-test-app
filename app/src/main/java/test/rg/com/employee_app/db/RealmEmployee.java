package test.rg.com.employee_app.db;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;

/**
 * RealmEmployee db object.
 */
public class RealmEmployee extends RealmObject {

  /**
   * Default constructor.
   */
  public RealmEmployee() {
  }

  @Required
  @PrimaryKey
  private String uuid;
  @Required
  private String company;
  private String bio;
  @Required
  private String name;
  private String title;
  private String avatar;

  /**
   * Constructor with mandatory fields.
   *
   * @param uuid the uuid.
   * @param company the company.
   * @param name the name.
   */
  public RealmEmployee(String uuid, String company, String name) {
    this.uuid = uuid;
    this.company = company;
    this.name = name;
  }

  public String getUuid() {
    return uuid;
  }

  public void setUuid(String uuid) {
    this.uuid = uuid;
  }

  public String getCompany() {
    return company;
  }

  public void setCompany(String company) {
    this.company = company;
  }

  public String getBio() {
    return bio;
  }

  public void setBio(String bio) {
    this.bio = bio;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getAvatar() {
    return avatar;
  }

  public void setAvatar(String avatar) {
    this.avatar = avatar;
  }
}
