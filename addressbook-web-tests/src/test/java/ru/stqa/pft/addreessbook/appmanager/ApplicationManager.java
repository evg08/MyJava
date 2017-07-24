package ru.stqa.pft.addreessbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created by Евгения on 24.07.2017.
 */
public class ApplicationManager {
  private FirefoxDriver wd;
  private  NaviationHelper naviationHelper;
  private ContactHelper contactHelper;
  private SessionHelper sessionHelper;
  public static boolean isAlertPresent(FirefoxDriver wd) {
    try {
      wd.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  public void init() {
    System.setProperty("webdriver.gecko.driver", "C:\\geckodriver\\geckodriver.exe");
    wd = new FirefoxDriver();
    wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    wd.get("http://localhost/addressbook/edit.php");
    contactHelper = new ContactHelper(wd);
    naviationHelper = new NaviationHelper(wd);
     sessionHelper= new SessionHelper (wd);
    sessionHelper.loginPage("admin", "secret");
  }



  public void stop() {
    wd.quit();
  }

  public ContactHelper getContactHelper() {
    return contactHelper;
  }

  public NaviationHelper getNaviationHelper() {
    return naviationHelper;
  }
}
