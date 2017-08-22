package ru.stqa.pft.addressbook.model;

public class GroupData {


  private int id;
  private final String groupName;
  private final String groupHeader;
  private final String groupFooter;
  public GroupData( String groupName, String groupHeader, String GroupFooter) {
    this.id = 0;
    this.groupName = groupName;
    this.groupHeader = groupHeader;
    groupFooter = GroupFooter;
  }

  public GroupData(int id, String groupName, String groupHeader, String GroupFooter) {
    this.id = id;
    this.groupName = groupName;
    this.groupHeader = groupHeader;
    groupFooter = GroupFooter;
  }
  public void setId(int id) {
    this.id = id;
  }
  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    GroupData groupData = (GroupData) o;

    if (id != groupData.id) return false;
    if (groupName != null ? !groupName.equals(groupData.groupName) : groupData.groupName != null) return false;
    if (groupHeader != null ? !groupHeader.equals(groupData.groupHeader) : groupData.groupHeader != null) return false;
    return groupFooter != null ? groupFooter.equals(groupData.groupFooter) : groupData.groupFooter == null;

  }

  @Override
  public int hashCode() {
    int result = id;
    result = 31 * result + (groupName != null ? groupName.hashCode() : 0);
    return result;
  }

  public int getId() {
    return id;
  }

  @Override
  public String toString() {
    return "GroupData{" +
            "id='" + id + '\'' +
            ", groupName='" + groupName + '\'' +
            '}';
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
