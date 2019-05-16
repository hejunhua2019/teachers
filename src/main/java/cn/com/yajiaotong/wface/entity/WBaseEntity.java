package cn.com.yajiaotong.wface.entity;

import java.io.Serializable;
import java.util.Date;

import cn.com.yajiaotong.wface.common.page.Page;
import cn.com.yajiaotong.wface.dao.WBaseDao;

public class WBaseEntity implements Serializable {
	private static final long serialVersionUID = -67188388306700736L;
	
    private Long id;
 
    private Date createDate;
 
    private Date modifyDate;
    
    private char isDeleted;
    
    private Date deleteDate;
    
    private Long lastOperator;
    
    private Integer start=0;
    
    private Integer size=WBaseDao.QUERY_LIMIT;
    

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getModifyDate() {
		return modifyDate;
	}

	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}
	
	public char getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(char isDeleted) {
		this.isDeleted = isDeleted;
	}

	public Date getDeleteDate() {
		return deleteDate;
	}

	public void setDeleteDate(Date deleteDate) {
		this.deleteDate = deleteDate;
	}

	public Long getLastOperator() {
		return lastOperator;
	}

	public void setLastOperator(Long lastOperator) {
		this.lastOperator = lastOperator;
	}
	
	

	public Integer getStart() {
		return start;
	}

	public void setStart(Integer start) {
		this.start = start;
	}

	public Integer getSize() {
		return size;
	}

	public void setSize(Integer size) {
		this.size = size;
	}



	/**
	 * 分页专用属性
	 * @author yigh
	 */
	protected Page page;
	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}
}
