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
    if (islementPresent(By.tagName("h1")) &&
            (wd.findElement(By.tagName("h1")).getText().equals("Groups"))
            && (islementPresent(By.name("new")))) {
      return;
    }
    click(By.linkText("GROUPS"));

  }
}
