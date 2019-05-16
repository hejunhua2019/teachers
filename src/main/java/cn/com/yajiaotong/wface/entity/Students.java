package cn.com.yajiaotong.wface.entity;

import java.util.Date;
import java.util.List;

public class Students extends WBaseEntity{
	
	private static final long serialVersionUID = 6230962019251637753L;
	
	private String mobile; //手机号码;
	private String pwd; //密码;
	private String email; //邮箱;
	private String avatar;//用户头像(URL)
	private String nickName; //昵称：展示给客户的名称;
	private String realName; //真实姓名;
	private int toPay; //是否付费学员（1：表示已经付费；0：表示免费）;
	private int learning; //是否在学习（1：在学习；2：不住学习）;
	private String classes; //所在班级;
	private char sex; //性别;
	private String education; //学历;
	private String wechat; //微信号;
	private int loginCounts; //登录次数;
	private int loginStatus;//登录状态(1：已登录；0：未登录)
	private String appId;//小程序 appId
	private String secret;//小程序 Secret
	private String js_code;//登录时获取的 code
	private Date lastLoginDate; //最后登录时间;
	private int lockStatus; //锁定状态（1：锁定；0：未锁定）;
	private int resetPwd; //是否重置过密码;
	private int enableFlag; //启用状态（1：启用；0：禁用）;
	private String content;//学员反馈内容
	private int courseNumbers;//已学课程次数
	private int courseDuration;//学员播放课程章节视频学习时长
	private int completeNumbers;//学员完成作业数
	private int taskNumbers;//已做作业次数
	private String remark; //备注;
	private String coursesId;//所报读课程(外键);		
	//一对多的关系
    private List<Relation> relationList;
       
	public Students() {
		super();
	}

	
	public Students(String mobile, String pwd, String email, String avatar, String nickName, String realName, int toPay,
			int learning, String classes, char sex, String education, String wechat, int loginCounts, int loginStatus,
			String appId, String secret, String js_code, Date lastLoginDate, int lockStatus, int resetPwd,
			int enableFlag, String content, int courseNumbers, int courseDuration, int completeNumbers, int taskNumbers,
			String remark, String coursesId, List<Relation> relationList) {
		super();
		this.mobile = mobile;
		this.pwd = pwd;
		this.email = email;
		this.avatar = avatar;
		this.nickName = nickName;
		this.realName = realName;
		this.toPay = toPay;
		this.learning = learning;
		this.classes = classes;
		this.sex = sex;
		this.education = education;
		this.wechat = wechat;
		this.loginCounts = loginCounts;
		this.loginStatus = loginStatus;
		this.appId = appId;
		this.secret = secret;
		this.js_code = js_code;
		this.lastLoginDate = lastLoginDate;
		this.lockStatus = lockStatus;
		this.resetPwd = resetPwd;
		this.enableFlag = enableFlag;
		this.content = content;
		this.courseNumbers = courseNumbers;
		this.courseDuration = courseDuration;
		this.completeNumbers = completeNumbers;
		this.taskNumbers = taskNumbers;
		this.remark = remark;
		this.coursesId = coursesId;
		this.relationList = relationList;
	}


	public int getCompleteNumbers() {
		return completeNumbers;
	}


	public void setCompleteNumbers(int completeNumbers) {
		this.completeNumbers = completeNumbers;
	}


	public int getCourseDuration() {
		return courseDuration;
	}


	public void setCourseDuration(int courseDuration) {
		this.courseDuration = courseDuration;
	}


	public String getCoursesId() {
		return coursesId;
	}



	public void setCoursesId(String coursesId) {
		this.coursesId = coursesId;
	}



	public String getAppId() {
		return appId;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}

	public String getSecret() {
		return secret;
	}

	public void setSecret(String secret) {
		this.secret = secret;
	}


	public String getJs_code() {
		return js_code;
	}


	public void setJs_code(String js_code) {
		this.js_code = js_code;
	}


	public int getLoginStatus() {
		return loginStatus;
	}

	public void setLoginStatus(int loginStatus) {
		this.loginStatus = loginStatus;
	}

	public int getCourseNumbers() {
		return courseNumbers;
	}



	public void setCourseNumbers(int courseNumbers) {
		this.courseNumbers = courseNumbers;
	}



	public int getTaskNumbers() {
		return taskNumbers;
	}



	public void setTaskNumbers(int taskNumbers) {
		this.taskNumbers = taskNumbers;
	}



	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public List<Relation> getRelationList() {
		return relationList;
	}
	public void setRelationList(List<Relation> relationList) {
		this.relationList = relationList;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getRealName() {
		return realName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}
	public int getToPay() {
		return toPay;
	}
	public void setToPay(int toPay) {
		this.toPay = toPay;
	}
	public int getLearning() {
		return learning;
	}
	public void setLearning(int learning) {
		this.learning = learning;
	}
	public String getClasses() {
		return classes;
	}
	public void setClasses(String classes) {
		this.classes = classes;
	}
	public char getSex() {
		return sex;
	}
	public void setSex(char sex) {
		this.sex = sex;
	}
	public String getEducation() {
		return education;
	}
	public void setEducation(String education) {
		this.education = education;
	}
	public String getWechat() {
		return wechat;
	}
	public void setWechat(String wechat) {
		this.wechat = wechat;
	}
	public int getLoginCounts() {
		return loginCounts;
	}
	public void setLoginCounts(int loginCounts) {
		this.loginCounts = loginCounts;
	}
	public Date getLastLoginDate() {
		return lastLoginDate;
	}
	public void setLastLoginDate(Date lastLoginDate) {
		this.lastLoginDate = lastLoginDate;
	}
	public int getLockStatus() {
		return lockStatus;
	}
	public void setLockStatus(int lockStatus) {
		this.lockStatus = lockStatus;
	}
	public int getResetPwd() {
		return resetPwd;
	}
	public void setResetPwd(int resetPwd) {
		this.resetPwd = resetPwd;
	}
	public int getEnableFlag() {
		return enableFlag;
	}
	public void setEnableFlag(int enableFlag) {
		this.enableFlag = enableFlag;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	

    
    
}