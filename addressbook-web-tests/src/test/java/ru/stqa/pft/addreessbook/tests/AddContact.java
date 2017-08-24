package ru.stqa.pft.addreessbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addreessbook.model.ContactData;

import java.util.List;

public class AddContact extends TestBase {

  @Test
  public void testAddContact() {
    app.getNavigationHelper().gotoHomepage();
    List<ContactData> contactBefore= app.getContactHelper().getContactList();
    //int contactBefore=app.getContactHelper().getContactCount();

    app.getNavigationHelper().goToContactPage();
    app.getContactHelper().fillContact(new ContactData("test1", "test2", "test3", "test4", "test5", "test6", "test7", "1234567", "234567", "1234567", null, null, null,"group1"),true);
    app.getContactHelper().submitContactCreation();
    app.getContactHelper().returnToContact();

    app.getNavigationHelper().gotoHomepage();
    List<ContactData> contactAfter= app.getContactHelper().getContactList();
    int temp1 =contactAfter.size();
    int temp2 =contactBefore.size();

    //int contactAfter=app.getContactHelper().getContactCount();
    Assert.assertEquals(contactAfter.size(),contactBefore.size()+1);
  }

}
