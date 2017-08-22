package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.HashSet;
import java.util.List;


public class GroupCreationTests extends TestBase{

  @Test
  public void groupCreationTests() {
    //loginPage("admin", "secret");

    app.getNavigationHelper().gotoGroupPage();
    List <GroupData> groupBefore= app.getGroupHelper().getGroupList();
    //int groupBefore=app.getGroupHelper().getGroupCount();
    app.getGroupHelper().initGroupCreation();
    GroupData group =new GroupData( "test135", null, null);//groupBefore.get(groupBefore.size()-1).getId()
    app.getGroupHelper().fillGroupForm(group);
    app.getGroupHelper().submitGroupCreation();
    app.getGroupHelper().returnGroupsPage();
    List <GroupData> groupAfter= app.getGroupHelper().getGroupList();
    //int groupAfter=app.getGroupHelper().getGroupCount();
    Assert.assertEquals(groupAfter.size(),groupBefore.size()+1);

    int max=0;
    for (GroupData g: groupAfter)
    {
      if (g.getId()>max) {max=g.getId();}
    }
    group.setId(max);
    groupBefore.add(group);
    Assert.assertEquals(new HashSet<Object>(groupBefore) ,new HashSet<Object>(groupAfter));
  }

}
