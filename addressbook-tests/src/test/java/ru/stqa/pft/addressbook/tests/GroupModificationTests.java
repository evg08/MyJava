package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.HashSet;
import java.util.List;

/**
 * Created by Евгения on 24.07.2017.
 */
public class GroupModificationTests extends TestBase{
  @Test
  public void groupCreationTests() {

    app.getNavigationHelper().gotoGroupPage();

    if (!app.getGroupHelper().isThereGroup()){
      app.getGroupHelper().createGroup(new GroupData( "test135", null, null));
    }
    app.getNavigationHelper().gotoGroupPage();
   // int groupBefore=app.getGroupHelper().getGroupCount();
    List<GroupData> groupBefore= app.getGroupHelper().getGroupList();
    app.getGroupHelper().selectGroup(groupBefore.size()-1);
    app.getGroupHelper().initGroupModification();
    GroupData group=new GroupData( groupBefore.get(groupBefore.size()-1).getId(),"test136", "test56", "test56");//
    app.getGroupHelper().fillGroupForm(group);//(new GroupData("test135", "test56", "test56"));
    app.getGroupHelper().submitGroupModification();
    app.getGroupHelper().returnGroupsPage();
    List <GroupData> groupAfter= app.getGroupHelper().getGroupList();
    //int groupAfter=app.getGroupHelper().getGroupCount();
    Assert.assertEquals(groupAfter.size(),groupBefore.size());
    groupBefore.remove(groupBefore.size()-1);

    groupBefore.add(group);
    Assert.assertEquals(new HashSet<Object>(groupBefore) ,new HashSet<Object>(groupAfter));
  }

}
