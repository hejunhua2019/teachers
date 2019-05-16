package cn.com.yajiaotong.wface.entity;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class LoginHistory extends WBaseEntity{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1138359926883629173L;

    private String ip;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")  
    private Date date;
    private Long userID;
    
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Long getUserID() {
		return userID;
	}
	public void setUserID(Long userID) {
		this.userID = userID;
	}
}