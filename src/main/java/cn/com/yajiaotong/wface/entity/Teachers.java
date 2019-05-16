package cn.com.yajiaotong.wface.entity;

import java.util.List;

public class Teachers extends WBaseEntity{
	
	private static final long serialVersionUID = -5438591433080750436L;
	
	private String mobile;//教师的手机号码;
	private String name;//教师的名字;
	private String classes;//所教授班级;
	private int enableFlag;//启用状态（1:启用，0：禁用）;
	private char sex;//性别;
	private String introduction;//自我介绍;
	private String headPicture;//讲师头像(url链接)
	private String remark;//备注;
	private String coursesId;//所教授课程（外键）;
	//private Course course;
	
	
	//一对多的关系
    private List<Course> courseList;
	
    
	
	/*public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}
*/
	public List<Course> getCourseList() {
		return courseList;
	}

	public void setCourseList(List<Course> courseList) {
		this.courseList = courseList;
	}

	public Teachers() {
		super();
	}
   
	public String getHeadPicture() {
		return headPicture;
	}
	public Teachers(String mobile, String name, String classes, int enableFlag, char sex, String introduction,
			String headPicture, String remark, String coursesId, List<Course> courseList) {
		super();
		this.mobile = mobile;
		this.name = name;
		this.classes = classes;
		this.enableFlag = enableFlag;
		this.sex = sex;
		this.introduction = introduction;
		this.headPicture = headPicture;
		this.remark = remark;
		this.coursesId = coursesId;
		this.courseList = courseList;
	}

	public void setHeadPicture(String headPicture) {
		this.headPicture = headPicture;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getClasses() {
		return classes;
	}
	public void setClasses(String classes) {
		this.classes = classes;
	}
	public int getEnableFlag() {
		return enableFlag;
	}
	public void setEnableFlag(int enableFlag) {
		this.enableFlag = enableFlag;
	}
	public char getSex() {
		return sex;
	}
	public void setSex(char sex) {
		this.sex = sex;
	}
	public String getIntroduction() {
		return introduction;
	}
	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getCoursesId() {
		return coursesId;
	}
	public void setCoursesId(String coursesId) {
		this.coursesId = coursesId;
	}
	
	
   
    
}