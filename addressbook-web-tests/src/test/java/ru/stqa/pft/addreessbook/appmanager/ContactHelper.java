package ru.stqa.pft.addreessbook.appmanager;

import com.sun.javafx.binding.ExpressionHelperBase;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import ru.stqa.pft.addreessbook.model.ContactData;

/**
 * Created by Евгения on 24.07.2017.
 */
public class ContactHelper extends HelperBase{


  public ContactHelper(WebDriver wd) {

    super(wd);
  }

  public void fillContact(ContactData contactData,boolean creation) {
    type(By.name("firstname"),contactData.getFirstname());
    type(By.name("middlename"), contactData.getMiddlename());
    type(By.name("lastname"), contactData.getLastname());
    type(By.name("nickname"), contactData.getNickname());
    type(By.name("title"), contactData.getTitle());
    type(By.name("company"), contactData.getAddress());
    type(By.name("address"), contactData.getAddress2());
    //click(By.name("theform"));
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
//   click (By.xpath("//div[@id='content']//label[.='GROUP:']"));
//    if (!elementIsSelected(By.xpath("//div[@id='content']/form/select[5]//option[2]"))) {
 //     click (By.xpath("//div[@id='content']/form/select[5]//option[2]"));
  //  }
    //click(By.name("theform"));
    type(By.name("address2"), contactData.getAddr());
    type(By.name("phone2"), contactData.getPhone3());
    //if element is exist then pick up element of dialog popup list
    if (creation){
      new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
    }else{//exception
    Assert.assertFalse( islementPresent(By.name("new_group")));
    }
  }

  public void returnToContact() {
    click(By.xpath("//table[@id='maintable']/tbody/tr[2]/td[7]/a/img"));
  }

  public void submitContactCreation() {
    click(By.xpath("//div[@id='content']/form/input[21]"));
  }

  public void deleteButton() {
    click(By.xpath("//div[@id='content']/form[2]/div[2]/input"));
   // click(By.xpath("//div[@id='content']/form[2]/div[2]/input"));
  }

  public void selectContact() {
   WebElement select =wd.findElement(By.xpath("//div/div[4]/form[2]/table/tbody/tr[2]/td[1]/input"));
      select.click();

}

  public void ChangeContact() {

    actionPerform(By.name("selected[]"));
//    click(By.id("container"));
    actionPerform(By.xpath("//table[@id='maintable']/tbody/tr[2]/td[8]/a/img"));


  }
//.//*[@id='maintable']/tbody/tr[1]/th[1]
  public void submitContactModification() {
    click(By.name("update"));


  }


  }