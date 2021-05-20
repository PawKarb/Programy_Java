package aplikacja;

import java.util.List;

public class Group {
	private String groupName;
	private List<Person> members; 
	
	public Group(String groupName, List<Person> members) {
		this.groupName = groupName;
		this.members = members;
	}
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	public List<Person> getMembers() {
		return members;
	}
	public void setMembers(List<Person> members) {
		this.members = members;
	}
	@Override
	public String toString() {
		return members.toString();
	}
}
