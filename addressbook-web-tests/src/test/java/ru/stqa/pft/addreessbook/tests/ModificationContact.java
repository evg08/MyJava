package ru.stqa.pft.addreessbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addreessbook.model.ContactData;

import java.util.List;

/**
 * Created by Евгения on 24.07.2017.
 */
public class ModificationContact extends TestBase {

  @Test
  public void modifyContact() {
    app.getNavigationHelper().gotoHomepage();
    if (!app.getContactHelper().isThereContact()){
      app.getNavigationHelper().goToContactPage();
      app.getContactHelper().createContact(new ContactData("test1", "test2", "test3", "test4", "test5", "test6", "test7", "1234567", "234567", "1234567", null, null, null,"test135"),true);
    }
    app.getNavigationHelper().gotoHomepage();
    List<ContactData> contactBefore= app.getContactHelper().getContactList();
    //int contactBefore=app.getContactHelper().getContactCount();

    app.getContactHelper().selectContact(contactBefore.size()-1);
    app.getContactHelper().ChangeContact();
    app.getContactHelper().fillContact(new ContactData("test1", "test2", "test3", "test4", "test5", "test6", "test7", "1234567", "234567", "1234567", "1988", "test", "1353456","test135"),false);
    app.getContactHelper().submitContactModification();
    app.getNavigationHelper().gotoHomepage();
    //int contactAfter=app.getContactHelper().getContactCount();
    List<ContactData> contactAfter= app.getContactHelper().getContactList();
    Assert.assertEquals(contactAfter.size(),contactBefore.size());

  }
}
