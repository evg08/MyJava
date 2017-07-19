package ru.stqa.pft.addressbook.tests;

public class GroupDeletion extends TestBase {

    public void groupDeletion() {
    app.getNavigationHelper().gotoGroupPage();
    app.getGroupHelper().selectGroup();
    app.getGroupHelper().deleteSelectedGroups();
    app.getGroupHelper().returnGroupsPage();

  }

}
