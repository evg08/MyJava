package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
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
    app.getNavigationHelper().gotoGroupPage();
    int groupBefore=app.getGroupHelper().getGroupCount();

    app.getGroupHelper().selectGroup(groupBefore-1);
    app.getGroupHelper().initGroupModification();
    app.getGroupHelper().fillGroupForm(new GroupData("test135", "test56", "test56"));
    app.getGroupHelper().submitGroupModification();
    app.getGroupHelper().returnGroupsPage();
    int groupAfter=app.getGroupHelper().getGroupCount();
    Assert.assertEquals(groupAfter,groupBefore);
  }

}
