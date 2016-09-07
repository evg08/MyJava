package ru.stqa.pft.addreessbook;

public class ContactData {
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

  public ContactData(String firstname, String middlename, String lastname, String nickname, String title, String address, String address2, String home, String mobile, String workphone, String yearBirthday, String addr, String phone3) {
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
}
