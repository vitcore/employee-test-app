package test.rg.com.employee_app.rest;

import com.google.gson.annotations.SerializedName;

/**
 * Retrofit response model for Employee.
 */
public class EmployeeResponseModel {


  @SerializedName("uuid")
  private String uuid;
  @SerializedName("company")
  private String company;
  @SerializedName("bio")
  private String bio;
  @SerializedName("name")
  private String name;
  @SerializedName("title")
  private String title;
  @SerializedName("avatar")
  private String avatar;

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
