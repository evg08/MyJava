package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

/**
 * Created by Евгения on 24.07.2017.
 */
public class GroupModificationTests extends TestBase{
  @Test
  public void groupCreationTests() {

    app.getNavigationHelper().gotoGroupPage();
    if (!app.getGroupHelper().isThereGroup()){
      app.getGroupHelper().createGroup(new GroupData("test135", null, null));
    }
    app.getGroupHelper().selectGroup();
    app.getGroupHelper().initGroupModification();
    app.getGroupHelper().fillGroupForm(new GroupData("test135", "test56", "test56"));
    app.getGroupHelper().submitGroupModification();
    app.getGroupHelper().returnGroupsPage();
  }

}
