package cn.com.yajiaotong.wface.entity;

public class Records extends WBaseEntity{
	
	private static final long serialVersionUID = 2244257041459368941L;
	
	
	private String time;//课程直播时间
	private int courseStates;//课程学习状态：(1：表示已学习 2：学习中 0：未学习)
	private String courseDuration;//课程学习时长
	private String courseLearning;//课程学习时间
	private int sectionStates;//章节学习状态：(1：已学完 2：学习中  0：未学习)
	private String sectionDuration;//章节学习时长
	private String sectionLearning;//章节学习时间
	private String homework;//作业完成情况
	private String homeworkCompletion;//作业完成时间
	
	
	
	public String getCourseLearning() {
		return courseLearning;
	}
	public void setCourseLearning(String courseLearning) {
		this.courseLearning = courseLearning;
	}
	public String getSectionLearning() {
		return sectionLearning;
	}
	public void setSectionLearning(String sectionLearning) {
		this.sectionLearning = sectionLearning;
	}
	public String getHomeworkCompletion() {
		return homeworkCompletion;
	}
	public void setHomeworkCompletion(String homeworkCompletion) {
		this.homeworkCompletion = homeworkCompletion;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public int getCourseStates() {
		return courseStates;
	}
	public void setCourseStates(int courseStates) {
		this.courseStates = courseStates;
	}
	public String getCourseDuration() {
		return courseDuration;
	}
	public void setCourseDuration(String courseDuration) {
		this.courseDuration = courseDuration;
	}
	public int getSectionStates() {
		return sectionStates;
	}
	public void setSectionStates(int sectionStates) {
		this.sectionStates = sectionStates;
	}
	public String getSectionDuration() {
		return sectionDuration;
	}
	public void setSectionDuration(String sectionDuration) {
		this.sectionDuration = sectionDuration;
	}
	public String getHomework() {
		return homework;
	}
	public void setHomework(String homework) {
		this.homework = homework;
	}
	
    
}