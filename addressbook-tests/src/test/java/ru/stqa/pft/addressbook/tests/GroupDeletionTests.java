package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

public class GroupDeletionTests extends TestBase {
  @Test
    public void groupDeletion() {
    app.getNavigationHelper().gotoGroupPage();
    if (!app.getGroupHelper().isThereGroup()){
      app.getGroupHelper().createGroup(new GroupData("test135", null, null));
    }
    app.getNavigationHelper().gotoGroupPage();
    int groupBefore=app.getGroupHelper().getGroupCount();

    app.getGroupHelper().selectGroup(groupBefore-1);
    app.getGroupHelper().deleteSelectedGroups();
    app.getGroupHelper().returnGroupsPage();
    int groupAfter=app.getGroupHelper().getGroupCount();
    Assert.assertEquals(groupAfter,groupBefore-1);
  }

}
