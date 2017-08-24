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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Евгения on 24.07.2017.
 */
public class ContactHelper extends HelperBase {


  public ContactHelper(WebDriver wd) {

    super(wd);
  }

  public void fillContact(ContactData contactData, boolean creation) {
    type(By.name("firstname"), contactData.getFirstname());
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
      click(By.xpath("//div[@id='content']/form/select[1]//option[17]"));
    }
    if (!elementIsSelected(By.xpath("//div[@id='content']/form/select[2]//option[2]"))) {
      click(By.xpath("//div[@id='content']/form/select[2]//option[2]"));
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

    if (creation) {
      List <WebElement> options = wd.findElement(By.name("new_group")).findElements(By.tagName("option"));
      int i=0;
      for (WebElement option : options) {
        if (contactData.getGroup().equalsIgnoreCase(option.getText())){
          option.click();
          i=1;
        }
      }
      if (i==0){wd.findElement(By.name("new_group")).findElement(By.tagName("option")).click();}
     /* if(! wd.findElement(By.name("new_group")).findElements(By.tagName("option")).equals(contactData.getGroup()))
      { int index=1;
        String k= wd.findElement(By.name("new_group")).findElements(By.tagName("option")).ge;
        contactData.setGroup(k);
      }*/
    //  new Select(wd.findElement(By.name("new_group"))).selectByVisibleText("[NONE]");//(contactData.getGroup());
    } else {//exception
      Assert.assertFalse(islementPresent(By.name("new_group")));
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
    // click(By.xpath("//div[@id='content']/form[2]/div[2]/input"));
  }

  public void selectContact(int index) {
    //нашли все элементы с selected и кликнули на index по счету
    wd.findElements(By.name("selected[]")).get(index).click();

    //wd.findElement(By.xpath("//div/div[4]/form[2]/table/tbody/tr[3]/td[1]/input")).click();
            //.get(index).click();
            //div/div[4]/form[2]/table/tbody/tr[2]/td[1]/input")).get(index).click();
    // WebElement select = wd.findElement(By.xpath("//div/div[4]/form[2]/table/tbody/tr[2]/td[1]/input"));
    // select.click();

  }

  public void ChangeContact() {
    //"selected[]"
    actionPerform(By.xpath("//div/div[4]/form[2]/table/tbody/tr[2]/td[1]/input"));
//    click(By.id("container"));
    actionPerform(By.xpath("//table[@id='maintable']/tbody/tr[2]/td[8]/a/img"));


  }

  //.//*[@id='maintable']/tbody/tr[1]/th[1]
  public void submitContactModification() {
    click(By.name("update"));
  }


  public void createContact(ContactData contactData, boolean create) {
    fillContact(contactData, true);
    submitContactCreation();
    returnToContact();

  }

  public boolean isThereContact() {
    ////By.name("selected[]"
    return islementPresent(By.xpath("//div/div[4]/form[2]/table/tbody/tr[2]/td[1]/input"));
    //islementPresent(By.xpath("//div/div[4]/form[2]/table/tbody/tr[2]/td[1]/input"));
  }

  public int getContactCount() {
    //By.name("selected[]"
    return wd.findElements(By.xpath("//div/div[4]/form[2]/table/tbody/tr[2]/td[1]/input")).size();
    //wd.findElements(By.name("selected[]")).size();
  }


  public List<ContactData> getContactList() {
    List<ContactData> contacts = new ArrayList<ContactData>();
    //-----------------
    int i = 2;
    int j;
    String tablecol;
    Boolean temp = false;
    List<WebElement> elements;
    if (islementPresent(By.xpath(" //div/div[4]/form[2]/table/tbody/tr[2]/td[1]/input"))) {
      temp = true;
    }
    while (temp == true) {

      List<String> TableRow = new ArrayList<>();
      for (j = 2; j < 7; j++) {
        String StringPath = "//div/div[4]/form[2]/table/tbody/tr[" + i + "]/td[" + j + "]";
        tablecol = wd.findElement(By.xpath(StringPath)).getText();//getText();
        if (tablecol.isEmpty()){tablecol=null;}
        TableRow.add(tablecol);
      }
      String d = TableRow.get(2);
     ContactData contact = new ContactData(TableRow.get(1), null, TableRow.get(0), null, null, TableRow.get(2), TableRow.get(3), null, TableRow.get(4), null, null, null, null, null);
  //    contacts.add(contact);

     // ContactData contact = new ContactData(null, null,null, null, null, null, null, null, null, null, null, null, null, null);
     contacts.add(contact);


      String StringPath = "//div/div[4]/form[2]/table/tbody/tr[" + (i + 1) + "]/td[1]";
      if (islementPresent(By.xpath(StringPath))) {
        temp = true;
      } else {
        temp = false;
      }
      i++;

    }
    //---------------


    // List<WebElement>elements =wd.findElements(By.name("name selected[]") );
    /*for (WebElement element:elements){
        String lname = element.getText();
    ContactData  contact =new ContactData(lname,null,null,null,null,null,null,null,null,null,null,null,null,null);
      contacts.add(contact);
    }*/
    return contacts;
  }
}