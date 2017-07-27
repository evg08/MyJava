package ru.stqa.pft.addreessbook.appmanager;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Евгения on 24.07.2017.
 */
public class HelperBase {
  WebDriver wd;

  public HelperBase(WebDriver wd) {
    this.wd = wd;
  }

  public boolean elementIsSelected(By locator) {
    return wd.findElement(locator).isSelected();
  }

  public void click( By locator) {
    wd.findElement(locator).click();
  }

  public void clickAndWait( By locator) {
    WebDriverWait wait = new WebDriverWait(wd, 500);
    wait.until(ExpectedConditions.elementToBeClickable(locator));
    wd.findElement(locator).click();
  }

  public void actionPerform(By locator) {
    new Actions(wd).doubleClick(wd.findElement(locator)).build().perform();
  }

  public void type(By locator, String text) {
    click(locator);
    if (text != null) {
      String ExistText = wd.findElement(locator).getAttribute("value");
      if (!ExistText.equals(text)) {
        wd.findElement(locator).clear();
        wd.findElement(locator).sendKeys(text);
      }
    }
  }

  public void okDialogDeletionButton() {

    wd.switchTo().alert().accept();
    //Alert alert = (new WebDriverWait(wd, 10)).until(ExpectedConditions.alertIsPresent());
    //isAlertAccept(alert);

  }

  public void isAlertAccept(Alert alert) {
    try {
      alert.accept();
      return;
    } catch (NoAlertPresentException e) {
      return;
    }
  }

  public void isAlertCancel(Alert alert) {
    try {
      alert.dismiss();
      return;
    } catch (NoAlertPresentException e) {
      return;
    }
  }

  protected boolean islementPresent(By locator) {
    try {
      wd.findElement(locator);
      return true;
    }catch (NoSuchElementException ex){
      return false;

    }
  }
}
