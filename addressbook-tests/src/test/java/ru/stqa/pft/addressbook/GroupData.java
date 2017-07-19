package ru.stqa.pft.addressbook;

public class GroupData {
  private final String groupName;
  private final String groupHeader;
  private final String groupFooter;

  public GroupData(String groupName, String groupHeader, String GroupFooter) {
    this.groupName = groupName;
    this.groupHeader = groupHeader;
    groupFooter = GroupFooter;
  }

  public String getGroupName() {
    return groupName;
  }

  public String getGroupHeader() {
    return groupHeader;
  }

  public String getGroupFooter() {
    return groupFooter;
  }
}
