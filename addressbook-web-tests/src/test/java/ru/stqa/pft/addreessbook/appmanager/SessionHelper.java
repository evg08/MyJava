package ru.stqa.pft.addreessbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by Евгения on 24.07.2017.
 */
public class SessionHelper extends HelperBase {

  public SessionHelper(WebDriver wd ) {
    super(wd);
  }

  public void loginPage(String userName, String password) {
    type(By.name("user"),userName);
    type(By.name("pass"),password);
    click(By.xpath("//form[@id='LoginForm']/input[3]"));
  }
}
