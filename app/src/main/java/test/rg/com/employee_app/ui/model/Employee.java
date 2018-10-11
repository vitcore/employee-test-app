package test.rg.com.employee_app.ui.model;

import java.io.Serializable;

import test.rg.com.employee_app.db.RealmEmployee;

/**
 * Employee view model.
 */
public class Employee implements Serializable {
  private String uuid;
  private String company;
  private String bio;
  private String name;
  private String title;
  private String avatar;

  /**
   * Default constructor that uses the realm object.
   *
   * @param realmEmployee the db model.
   */
  public Employee(RealmEmployee realmEmployee) {
    this.uuid = realmEmployee.getUuid();
    this.company = realmEmployee.getCompany();
    this.bio = realmEmployee.getBio();
    this.name = realmEmployee.getName();
    this.title = realmEmployee.getTitle();
    this.avatar = realmEmployee.getAvatar();
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
