package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

public class GroupCreationTests extends TestBase{

  @Test
  public void groupCreationTests() {
    //loginPage("admin", "secret");

    app.getNavigationHelper().gotoGroupPage();
    int groupBefore=app.getGroupHelper().getGroupCount();
    app.getGroupHelper().initGroupCreation();
    app.getGroupHelper().fillGroupForm(new GroupData("test135", null, null));
    app.getGroupHelper().submitGroupCreation();
    app.getGroupHelper().returnGroupsPage();
    int groupAfter=app.getGroupHelper().getGroupCount();
    Assert.assertEquals(groupAfter,groupBefore+1);
  }

}
