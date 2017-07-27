package ru.stqa.pft.addreessbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addreessbook.model.ContactData;

public class AddContact extends TestBase {

  @Test
  public void testAddContact() {
    app.getNavigationHelper().gotoHomepage();
    int contactBefore=app.getContactHelper().getContactCount();

    app.getNavigationHelper().goToContactPage();
    app.getContactHelper().fillContact(new ContactData("test1", "test2", "test3", "test4", "test5", "test6", "test7", "1234567", "234567", "1234567", null, null, null,"test135"),true);
    app.getContactHelper().submitContactCreation();
    app.getContactHelper().returnToContact();

    app.getNavigationHelper().gotoHomepage();
    int contactAfter=app.getContactHelper().getContactCount();
    Assert.assertEquals(contactAfter,contactBefore+1);
  }

}
