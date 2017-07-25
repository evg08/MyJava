package ru.stqa.pft.addreessbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addreessbook.model.ContactData;

/**
 * Created by Евгения on 24.07.2017.
 */
public class ModificationContact extends TestBase {

  @Test
  public void deleteContact() {

    app.getNavigationHelper().gotoHomepage();
    app.getContactHelper().selectContact();
    app.getContactHelper().ChangeContact();
    app.getContactHelper().fillContact(new ContactData("test1", "test2", "test3", "test4", "test5", "test6", "test7", "1234567", "234567", "1234567", "1988", "test", "1353456","test135"),false);
    app.getContactHelper().submitContactModification();
    app.getNavigationHelper().gotoHomepage();

  }
}
