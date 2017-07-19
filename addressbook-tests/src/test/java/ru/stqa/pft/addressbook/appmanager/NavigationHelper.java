package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by Евгения on 19.07.2017.
 */
public class NavigationHelper {
  private FirefoxDriver wd;
  public NavigationHelper(FirefoxDriver wd) {
    this.wd=wd;
  }
  //FirefoxDriver wd;

  // main link for Groups
  public void gotoGroupPage() {
    wd.findElement(By.linkText("GROUPS")).click();

  }
}
