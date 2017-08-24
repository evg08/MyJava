package ru.stqa.pft.addreessbook.model;

public class ContactData {
  private int id;



  private final String firstname;
  private final String middlename;
  private final String lastname;
  private final String nickname;
  private final String title;
  private final String address;
  private final String address2;
  private final String home;
  private final String mobile;
  private final String workphone;
  private final String yearBirthday;
  private final String addr;
  private final String phone3;
  private  String group;

  public void setGroup(String group) {
    this.group = group;
  }
  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }




  public ContactData(String firstname, String middlename, String lastname, String nickname, String title, String address, String address2, String home, String mobile, String workphone, String yearBirthday, String addr, String phone3, String group) {
    this.id = 0;
    this.firstname = firstname;
    this.middlename = middlename;
    this.lastname = lastname;
    this.nickname = nickname;
    this.title = title;
    this.address = address;
    this.address2 = address2;
    this.home = home;
    this.mobile = mobile;
    this.workphone = workphone;
    this.yearBirthday = yearBirthday;
    this.addr = addr;
    this.phone3 = phone3;
    this.group = group;
  }
  public ContactData(int id,String firstname, String middlename, String lastname, String nickname, String title, String address, String address2, String home, String mobile, String workphone, String yearBirthday, String addr, String phone3,  String group) {
    this.firstname = firstname;
    this.middlename = middlename;
    this.lastname = lastname;
    this.nickname = nickname;
    this.title = title;
    this.address = address;
    this.address2 = address2;
    this.home = home;
    this.mobile = mobile;
    this.workphone = workphone;
    this.yearBirthday = yearBirthday;
    this.addr = addr;
    this.phone3 = phone3;
    this.id = id;
    this.group = group;
  }
  public String getFirstname() {
    return firstname;
  }

  public String getMiddlename() {
    return middlename;
  }

  public String getLastname() {
    return lastname;
  }

  public String getNickname() {
    return nickname;
  }

  public String getTitle() {
    return title;
  }

  public String getAddress() {
    return address;
  }

  public String getAddress2() {
    return address2;
  }

  public String getHome() {
    return home;
  }

  public String getMobile() {
    return mobile;
  }

  public String getWorkphone() {
    return workphone;
  }

  public String getYearBirthday() {
    return yearBirthday;
  }

  public String getAddr() {
    return addr;
  }

  public String getPhone3() {
    return phone3;
  }

  public String getGroup() {
    return group;
  }

  @Override
  public String toString() {
    return "ContactData{" +
            "id=" + id +
            ", lastname='" + lastname + '\'' +
            '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    ContactData that = (ContactData) o;

    if (id != that.id) return false;
    if (firstname != null ? !firstname.equals(that.firstname) : that.firstname != null) return false;
    if (middlename != null ? !middlename.equals(that.middlename) : that.middlename != null) return false;
    if (lastname != null ? !lastname.equals(that.lastname) : that.lastname != null) return false;
    if (nickname != null ? !nickname.equals(that.nickname) : that.nickname != null) return false;
    if (title != null ? !title.equals(that.title) : that.title != null) return false;
    if (address != null ? !address.equals(that.address) : that.address != null) return false;
    if (address2 != null ? !address2.equals(that.address2) : that.address2 != null) return false;
    if (home != null ? !home.equals(that.home) : that.home != null) return false;
    if (mobile != null ? !mobile.equals(that.mobile) : that.mobile != null) return false;
    if (workphone != null ? !workphone.equals(that.workphone) : that.workphone != null) return false;
    if (yearBirthday != null ? !yearBirthday.equals(that.yearBirthday) : that.yearBirthday != null) return false;
    if (addr != null ? !addr.equals(that.addr) : that.addr != null) return false;
    if (phone3 != null ? !phone3.equals(that.phone3) : that.phone3 != null) return false;
    return group != null ? group.equals(that.group) : that.group == null;

  }

  @Override
  public int hashCode() {
    int result = id;
    result = 31 * result + (firstname != null ? firstname.hashCode() : 0);
    result = 31 * result + (middlename != null ? middlename.hashCode() : 0);
    result = 31 * result + (lastname != null ? lastname.hashCode() : 0);
    result = 31 * result + (nickname != null ? nickname.hashCode() : 0);
    result = 31 * result + (title != null ? title.hashCode() : 0);
    result = 31 * result + (address != null ? address.hashCode() : 0);
    result = 31 * result + (address2 != null ? address2.hashCode() : 0);
    result = 31 * result + (home != null ? home.hashCode() : 0);
    result = 31 * result + (mobile != null ? mobile.hashCode() : 0);
    result = 31 * result + (workphone != null ? workphone.hashCode() : 0);
    result = 31 * result + (yearBirthday != null ? yearBirthday.hashCode() : 0);
    result = 31 * result + (addr != null ? addr.hashCode() : 0);
    result = 31 * result + (phone3 != null ? phone3.hashCode() : 0);
    result = 31 * result + (group != null ? group.hashCode() : 0);
    return result;
  }
}