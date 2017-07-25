package ru.stqa.pft.addreessbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by Евгения on 24.07.2017.
 */
public class NaviationHelper extends HelperBase {

  public NaviationHelper(WebDriver wd) {
    super (wd);
  }

  public void goToContactPage() {
    click(By.linkText("ADD_NEW"));
  }

  public void gotoHomepage() {
    click(By.linkText("HOME"));
       }
}
