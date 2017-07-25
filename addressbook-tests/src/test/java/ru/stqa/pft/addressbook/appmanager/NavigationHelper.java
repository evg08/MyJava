package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by Евгения on 19.07.2017.
 */
public class NavigationHelper extends HelperBase {

  public NavigationHelper(WebDriver wd) {

    super(wd);
  }
  //FirefoxDriver wd;

  // main link for Groups
  public void gotoGroupPage() {
   click(By.linkText("GROUPS"));

  }
}
