package ru.stqa.pft.addressbook;

import org.testng.annotations.Test;

public class GroupCreationTests extends TestBase{

  @Test
  public void groupCreationTests() {
    //loginPage("admin", "secret");
    gotoGroupPage();
    fillNewGroup(new GroupData("test135", "test56", "test56"));
    submitGroupCreation();
    returnGroupsPage();
  }

}
