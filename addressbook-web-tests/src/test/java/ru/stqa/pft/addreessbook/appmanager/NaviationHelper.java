package ru.stqa.pft.addreessbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by Евгения on 24.07.2017.
 */
public class NaviationHelper {
  private FirefoxDriver wd;

  public NaviationHelper(FirefoxDriver wd) {
    this.wd=wd;
  }

  public void goToContactPage() {
    wd.findElement(By.linkText("ADD_NEW")).click();
  }

  public void gotoHomepage() {
      wd.findElement(By.linkText("HOME")).click();
  }
}
