package ru.stqa.pft.addreessbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addreessbook.model.ContactData;

public class AddContact extends TestBase {

  @Test
  public void testAddContact() {

    app.getNaviationHelper().goToContactPage();
    app.getContactHelper().fillContact(new ContactData("test1", "test2", "test3", "test4", "test5", "test6", "test7", "1234567", "234567", "1234567", "1987", "wery", "123"));
    app.getContactHelper().submitContactCreation();
    app.getContactHelper().returnToContact();
  }

}
