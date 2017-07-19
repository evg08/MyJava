package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

public class GroupCreationTests extends TestBase{

  @Test
  public void groupCreationTests() {
    //loginPage("admin", "secret");
    app.getNavigationHelper().gotoGroupPage();
    app.getGroupHelper().fillNewGroup(new GroupData("test135", "test56", "test56"));
    app.getGroupHelper().submitGroupCreation();
    app.getGroupHelper().returnGroupsPage();
  }

}
