package ru.stqa.pft.addreessbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addreessbook.model.ContactData;

import java.util.List;

public class DeleteContact extends TestBase {


  @Test
  public void deleteContact() {
    app.getNavigationHelper().gotoHomepage();
    if (!app.getContactHelper().isThereContact()) {
      app.getNavigationHelper().goToContactPage();
      app.getContactHelper().createContact(new ContactData("test1", "test2", "test3", "test4", "test5", "test6", "test7", "1234567", "234567", "1234567", null, null, null, "test135"), true);
    }
    List<ContactData> contactBefore= app.getContactHelper().getContactList();
    app.getNavigationHelper().gotoHomepage();
   // int contactBefore = app.getContactHelper().getContactCount();

    app.getContactHelper().selectContact(contactBefore.size()-1);
    app.getContactHelper().deleteButton();
    app.getContactHelper().okDialogDeletionButton();

    app.getNavigationHelper().gotoHomepage();
    app.getNavigationHelper().goToContactPage();
    app.getNavigationHelper().gotoHomepage();
   // int contactAfter = app.getContactHelper().getContactCount();
    List<ContactData> contactAfter= app.getContactHelper().getContactList();
    Assert.assertEquals(contactAfter.size(), contactBefore.size() - 1);
    contactBefore.remove(contactBefore.size()-1);
    Assert.assertEquals(contactAfter, contactBefore);
  }

}
