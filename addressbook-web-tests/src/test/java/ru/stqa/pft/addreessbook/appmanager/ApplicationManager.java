package ru.stqa.pft.addreessbook.appmanager;

import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.BrowserType;

import java.util.concurrent.TimeUnit;

/**
 * Created by Евгения on 24.07.2017.
 */
public class ApplicationManager {
  WebDriver wd;
  private NavigationHelper navigationHelper;
  private ContactHelper contactHelper;
  private SessionHelper sessionHelper;
  private String browser;

  public ApplicationManager(String browser) {
    this.browser = browser;
  }

  public static boolean isAlertPresent(FirefoxDriver wd) {
    try {
      wd.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  public void init() {
    if (browser.equals(BrowserType.FIREFOX)) {
      System.setProperty("webdriver.gecko.driver", "C:\\geckodriver\\geckodriver.exe");
      wd = new FirefoxDriver();
    } else if (browser.equals(BrowserType.CHROME)) {
      System.setProperty("webdriver.chrome.driver", "C:\\geckodriver\\chromedriver.exe");
      wd = new ChromeDriver();
    } else if (browser.equals(BrowserType.IE)) {
      System.setProperty("webdriver.ie.driver", "C:\\geckodriver\\IEDriverServer.exe");
      wd = new InternetExplorerDriver();
      // wd.st("mode=disableSecurity")
    }

   // System.setProperty("webdriver.gecko.driver", "C:\\geckodriver\\geckodriver.exe");
    //wd = new FirefoxDriver();
    wd.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);//60
    wd.get("http://localhost/addressbook/edit.php");
    contactHelper = new ContactHelper(wd);
    navigationHelper = new NavigationHelper(wd);
     sessionHelper= new SessionHelper (wd);
    sessionHelper.loginPage("admin", "secret");
  }



  public void stop() {
    wd.quit();
  }

  public ContactHelper getContactHelper() {
    return contactHelper;
  }

  public NavigationHelper getNavigationHelper() {
    return navigationHelper;
  }
}
