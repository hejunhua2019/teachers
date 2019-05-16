package cn.com.yajiaotong.wface.entity;

import java.util.List;

public class Courses extends WBaseEntity{
	
	private static final long serialVersionUID = 204116717293452283L;
	
	private String number;//课程章目录编号;
	private String summary; //章概要;
	private String catalogue; //章目录介绍;
	private String chapterVideo; //章视频url;
	private int isFree; //章视频是否免费体验(1：不免费；0：免费);
	private String coursesId; //课程ID（外键）;
	//一对多的关系
    private List<Question> questionList;
    
	public Courses() {
		super();
	}
	public Courses(String number, String summary, String catalogue, String chapterVideo, int isFree, String coursesId,
			List<Question> questionList) {
		super();
		this.number = number;
		this.summary = summary;
		this.catalogue = catalogue;
		this.chapterVideo = chapterVideo;
		this.isFree = isFree;
		this.coursesId = coursesId;
		this.questionList = questionList;
	}


	public List<Question> getQuestionList() {
		return questionList;
	}
	public void setQuestionList(List<Question> questionList) {
		this.questionList = questionList;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public String getCatalogue() {
		return catalogue;
	}
	public void setCatalogue(String catalogue) {
		this.catalogue = catalogue;
	}
	public String getChapterVideo() {
		return chapterVideo;
	}
	public void setChapterVideo(String chapterVideo) {
		this.chapterVideo = chapterVideo;
	}
	public int getIsFree() {
		return isFree;
	}
	public void setIsFree(int isFree) {
		this.isFree = isFree;
	}
	public String getCoursesId() {
		return coursesId;
	}
	public void setCoursesId(String coursesId) {
		this.coursesId = coursesId;
	}
	
	
   
    
}