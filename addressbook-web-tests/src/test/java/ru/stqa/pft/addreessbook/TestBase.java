package ru.stqa.pft.addreessbook;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

/**
 * Created by Евгения on 19.07.2017.
 */
public class TestBase {
  FirefoxDriver wd;

  public static boolean isAlertPresent(FirefoxDriver wd) {
    try {
      wd.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  @BeforeMethod
  public void setUp() throws Exception {
    System.setProperty("webdriver.gecko.driver", "C:\\geckodriver\\geckodriver.exe");
    wd = new FirefoxDriver();
    wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    wd.get("http://localhost/addressbook/edit.php");
    loginPage("admin", "secret");
  }

  private void loginPage(String username, String password) {
    wd.findElement(By.name("pass")).click();
    wd.findElement(By.name("pass")).sendKeys("\\undefined");
    wd.findElement(By.name("user")).click();
    wd.findElement(By.name("user")).clear();
    wd.findElement(By.name("user")).sendKeys(username);
    wd.findElement(By.name("pass")).click();
    wd.findElement(By.name("pass")).clear();
    wd.findElement(By.name("pass")).sendKeys(password);
    wd.findElement(By.xpath("//form[@id='LoginForm']/input[3]")).click();
  }

  public void fillContact(ContactData contactData) {
    wd.findElement(By.name("firstname")).click();
    wd.findElement(By.name("firstname")).clear();
    wd.findElement(By.name("firstname")).sendKeys(contactData.getFirstname());
    wd.findElement(By.name("middlename")).click();
    wd.findElement(By.name("middlename")).clear();
    wd.findElement(By.name("middlename")).sendKeys(contactData.getMiddlename());
    wd.findElement(By.name("lastname")).click();
    wd.findElement(By.name("lastname")).clear();
    wd.findElement(By.name("lastname")).sendKeys(contactData.getLastname());
    wd.findElement(By.name("nickname")).click();
    wd.findElement(By.name("nickname")).clear();
    wd.findElement(By.name("nickname")).sendKeys(contactData.getNickname());
    wd.findElement(By.name("title")).click();
    wd.findElement(By.name("title")).clear();
    wd.findElement(By.name("title")).sendKeys(contactData.getTitle());
    wd.findElement(By.name("company")).click();
    wd.findElement(By.name("company")).clear();
    wd.findElement(By.name("company")).sendKeys(contactData.getAddress());
    wd.findElement(By.name("address")).click();
    wd.findElement(By.name("address")).clear();
    wd.findElement(By.name("address")).sendKeys(contactData.getAddress2());
    wd.findElement(By.name("theform")).click();
    wd.findElement(By.name("home")).click();
    wd.findElement(By.name("home")).clear();
    wd.findElement(By.name("home")).sendKeys(contactData.getHome());
    wd.findElement(By.name("mobile")).click();
    wd.findElement(By.name("mobile")).clear();
    wd.findElement(By.name("mobile")).sendKeys(contactData.getMobile());
    wd.findElement(By.name("work")).click();
    wd.findElement(By.name("work")).clear();
    wd.findElement(By.name("work")).sendKeys(contactData.getWorkphone());
    if (!wd.findElement(By.xpath("//div[@id='content']/form/select[1]//option[17]")).isSelected()) {
      wd.findElement(By.xpath("//div[@id='content']/form/select[1]//option[17]")).click();
    }
    if (!wd.findElement(By.xpath("//div[@id='content']/form/select[2]//option[2]")).isSelected()) {
      wd.findElement(By.xpath("//div[@id='content']/form/select[2]//option[2]")).click();
    }
    wd.findElement(By.name("byear")).click();
    wd.findElement(By.name("byear")).clear();
    wd.findElement(By.name("byear")).sendKeys(contactData.getYearBirthday());
    wd.findElement(By.xpath("//div[@id='content']//label[.='GROUP:']")).click();
    if (!wd.findElement(By.xpath("//div[@id='content']/form/select[5]//option[2]")).isSelected()) {
      wd.findElement(By.xpath("//div[@id='content']/form/select[5]//option[2]")).click();
    }
    wd.findElement(By.name("theform")).click();
    wd.findElement(By.name("address2")).click();
    wd.findElement(By.name("address2")).clear();
    wd.findElement(By.name("address2")).sendKeys(contactData.getAddr());
    wd.findElement(By.name("phone2")).click();
    wd.findElement(By.name("phone2")).clear();
    wd.findElement(By.name("phone2")).sendKeys(contactData.getPhone3());
  }

  public void returnToContact() {
    wd.findElement(By.xpath("//table[@id='maintable']/tbody/tr[2]/td[7]/a/img")).click();
  }

  public void submitContactCreation() {
    wd.findElement(By.xpath("//div[@id='content']/form/input[21]")).click();
  }

  protected void goToContactPage() {
    wd.findElement(By.linkText("ADD_NEW")).click();
  }

  @AfterMethod
  public void tearDown() {
    wd.quit();
  }

  public void gotoHomepage() {
      wd.findElement(By.linkText("HOME")).click();
  }

  public void okDialogDeletionButton() {

    //Alert alert = wd.switchTo().alert();
    Alert alert =(new WebDriverWait(wd, 10)).until(ExpectedConditions.alertIsPresent());
    isAlertAccept(alert);
   // wd.findElement(By.xpath("//table[@id='maintable']/tbody/tr[9]/td[5]")).click();
    //new Actions(wd).doubleClick(wd.findElement(By.xpath("//table[@id='maintable']/tbody/tr[9]/td[5]"))).build().perform();

  }

  public void deleteButton() {
      wd.findElement(By.xpath("//div[@id='content']/form[2]/div[2]/input")).click();
  }

  public void selectDeletedContact() {
    if (!wd.findElement(By.name("selected[]")).isSelected()) {
      wd.findElement(By.name("selected[]")).click();
    }
  }

  protected void isAlertAccept(Alert alert){
    try {
      alert.accept();
      return ;
    } catch (NoAlertPresentException e) {
      return ;
    }
  }
  protected void isAlertCancel(Alert alert){
    try {
      alert.dismiss();
      return ;
    } catch (NoAlertPresentException e) {
      return ;
    }
  }

}


