package cn.com.yajiaotong.wface.entity;

import java.util.List;

public class Group extends WBaseEntity{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1138359926883629173L;

    private String name;
    private Integer type;
    private Long pGID;
    private List<Group> subGroups;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Long getpGID() {
		return pGID;
	}

	public void setpGID(Long pGID) {
		this.pGID = pGID;
	}

	public List<Group> getSubGroups() {
		return subGroups;
	}

	public void setSubGroups(List<Group> subGroups) {
		this.subGroups = subGroups;
	}	
	
}