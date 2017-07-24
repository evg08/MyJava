package ru.stqa.pft.addreessbook.tests;

import org.testng.annotations.Test;

/**
 * Created by Евгения on 24.07.2017.
 */
public class ModificationContact extends TestBase {

  @Test
  public void deleteContact() {

    app.getNaviationHelper().gotoHomepage();
    app.getContactHelper().selectContact();
    app.getContactHelper().ChangeContact();
    app.getContactHelper().submitContactModification();
    app.getNaviationHelper().gotoHomepage();

  }
}
