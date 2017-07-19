package ru.stqa.pft.addreessbook;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.*;
import ru.stqa.pft.addreessbook.ContactData;
import ru.stqa.pft.addreessbook.TestBase;

public class AddContact extends TestBase {

  @Test
  public void testAddContact() {

    goToContactPage();
    fillContact(new ContactData("test1", "test2", "test3", "test4", "test5", "test6", "test7", "1234567", "234567", "1234567", "1987", "wery", "123"));
    submitContactCreation();
    returnToContact();
  }

}
