package cn.com.yajiaotong.wface.entity;

public class GroupSysResource extends WBaseEntity{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1138359926883629173L;

    private Long groupID;
    private Long sysResourceID;
    
	
	public Long getGroupID() {
		return groupID;
	}
	public void setGroupID(Long groupID) {
		this.groupID = groupID;
	}
	public Long getSysResourceID() {
		return sysResourceID;
	}
	public void setSysResourceID(Long sysResourceID) {
		this.sysResourceID = sysResourceID;
	}

	
    
}