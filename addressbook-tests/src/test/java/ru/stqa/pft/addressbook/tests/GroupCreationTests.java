package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;
import java.util.List;


public class GroupCreationTests extends TestBase{

  @Test
  public void groupCreationTests() {
    //loginPage("admin", "secret");

    app.getNavigationHelper().gotoGroupPage();
    List <GroupData> groupBefore= app.getGroupHelper().getGroupList();
    //int groupBefore=app.getGroupHelper().getGroupCount();
    app.getGroupHelper().initGroupCreation();
    app.getGroupHelper().fillGroupForm(new GroupData("test135", null, null));
    app.getGroupHelper().submitGroupCreation();
    app.getGroupHelper().returnGroupsPage();
    List <GroupData> groupAfter= app.getGroupHelper().getGroupList();
    //int groupAfter=app.getGroupHelper().getGroupCount();
    Assert.assertEquals(groupAfter.size(),groupBefore.size()+1);
  }

}
