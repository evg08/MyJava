package ru.stqa.pft.addreessbook.appmanager;

import com.sun.javafx.binding.ExpressionHelperBase;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.stqa.pft.addreessbook.model.ContactData;

/**
 * Created by Евгения on 24.07.2017.
 */
public class ContactHelper extends HelperBase{


  public ContactHelper(WebDriver wd) {

    super(wd);
  }

  public void fillContact(ContactData contactData) {
    type(By.name("firstname"),contactData.getFirstname());
    type(By.name("middlename"), contactData.getMiddlename());
    type(By.name("lastname"), contactData.getLastname());
    type(By.name("nickname"), contactData.getNickname());
    type(By.name("title"), contactData.getTitle());
    type(By.name("company"), contactData.getAddress());
    type(By.name("address"), contactData.getAddress2());
    click(By.name("theform"));
    type(By.name("home"), contactData.getHome());
    type(By.name("mobile"), contactData.getMobile());
    type(By.name("work"), contactData.getWorkphone());
    if (!elementIsSelected(By.xpath("//div[@id='content']/form/select[1]//option[17]"))) {
      click (By.xpath("//div[@id='content']/form/select[1]//option[17]"));
    }
    if (!elementIsSelected(By.xpath("//div[@id='content']/form/select[2]//option[2]"))) {
      click (By.xpath("//div[@id='content']/form/select[2]//option[2]"));
    }
    type(By.name("byear"), contactData.getYearBirthday());
    click (By.xpath("//div[@id='content']//label[.='GROUP:']"));
    if (!elementIsSelected(By.xpath("//div[@id='content']/form/select[5]//option[2]"))) {
      click (By.xpath("//div[@id='content']/form/select[5]//option[2]"));
    }
    click(By.name("theform"));
    type(By.name("address2"), contactData.getAddr());
    type(By.name("phone2"), contactData.getPhone3());
  }

  public void returnToContact() {
    click(By.xpath("//table[@id='maintable']/tbody/tr[2]/td[7]/a/img"));
  }

  public void submitContactCreation() {
    click(By.xpath("//div[@id='content']/form/input[21]"));
  }

  public void deleteButton() {
    click(By.xpath("//div[@id='content']/form[2]/div[2]/input"));
  }

  public void selectContact() {
    if (!elementIsSelected(By.name("selected[]"))) {
      click(By.name("selected[]"));
    }
  }

  public void ChangeContact() {
    actionPerform(By.name("selected[]"));
    click(By.id("container"));
    actionPerform(By.xpath("//table[@id='maintable']/tbody/tr[2]/td[8]/a/img"));

  }

  public void submitContactModification() {
    click(By.name("update"));
  }


  }