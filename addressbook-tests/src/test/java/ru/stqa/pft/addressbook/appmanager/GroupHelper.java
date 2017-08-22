package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Евгения on 19.07.2017.
 */
public class GroupHelper extends HelperBase{

  public GroupHelper(WebDriver wd) {

    super(wd);
  }

  public void returnGroupsPage() {
    wd.findElement(By.linkText("group page")).click();
  }

  public void fillGroupForm(GroupData groupData) {

    type(By.name("group_name"), groupData.getGroupName());
    type(By.name("group_header"), groupData.getGroupHeader());
    type(By.name("group_footer"), groupData.getGroupFooter());
  }

  public void initGroupCreation() {
    click(By.name("new"));
  }

  public void submitGroupCreation() {
    click(By.name("submit"));
  }

  public void deleteSelectedGroups() {
    click(By.name("delete"));
  }

  public void selectGroup(int index) {
    wd.findElements(By.name("selected[]")).get(index).click();
   // click(By.name("selected[]"));
  }

  public void initGroupModification() {
    click(By.name("edit"));
  }

  public void submitGroupModification() {
    click(By.name("update"));
  }

  
public void createGroup(GroupData group) {
  initGroupCreation();
  fillGroupForm(group);
  submitGroupCreation();
  returnGroupsPage();
  }

  public boolean isThereGroup() {
    return islementPresent(By.name("selected[]"));

  }


//count of groups
  public int getGroupCount() {
    return   wd.findElements(By.name("selected[]")).size();
  }

  public List<GroupData> getGroupList() {
    List<GroupData>groups =new ArrayList<GroupData>();
    List<WebElement>elements= wd.findElements(By.cssSelector("span.group"));
    for(WebElement element:elements ) {
      String name = element.getText();
      String id = element.findElement(By.tagName("input")).getAttribute("value");
      GroupData group = new GroupData(Integer.parseInt(id), name, null, null);
      groups.add(group);
    }
    return groups;
  }
}

