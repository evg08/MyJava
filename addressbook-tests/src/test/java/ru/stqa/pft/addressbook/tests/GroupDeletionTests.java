package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.List;

public class GroupDeletionTests extends TestBase {
  @Test
    public void groupDeletion() {
    app.getNavigationHelper().gotoGroupPage();
    if (!app.getGroupHelper().isThereGroup()){
      app.getGroupHelper().createGroup(new GroupData("test135", null, null));
    }
    app.getNavigationHelper().gotoGroupPage();
    List<GroupData> groupBefore= app.getGroupHelper().getGroupList();
    //int groupBefore=app.getGroupHelper().getGroupCount();

    app.getGroupHelper().selectGroup(groupBefore.size()-1);
    app.getGroupHelper().deleteSelectedGroups();
    app.getGroupHelper().returnGroupsPage();
    List <GroupData> groupAfter= app.getGroupHelper().getGroupList();
    //int groupAfter=app.getGroupHelper().getGroupCount();
    Assert.assertEquals(groupAfter.size(),groupBefore.size()-1);
  }

}
