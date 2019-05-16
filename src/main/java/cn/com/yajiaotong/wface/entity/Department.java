package cn.com.yajiaotong.wface.entity;

public class Department extends WBaseEntity{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1138359926883629173L;

    private String addr;
    private Long groupID;
    
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public Long getGroupID() {
		return groupID;
	}
	public void setGroupID(Long groupID) {
		this.groupID = groupID;
	}
}