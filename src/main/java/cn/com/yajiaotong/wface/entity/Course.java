package cn.com.yajiaotong.wface.entity;

import java.util.List;

public class Course extends WBaseEntity{
	
	private static final long serialVersionUID = -1538694845096029718L;
	
	private String courseName; //课程名;
	private int classHours; //课时数;
	private char enableFlag; //启用状态（1：启用，0：禁用）;
	private String courseIntroduction; //课程介绍;
	private String courseContent; //课程内容;
	private String courseReview; //课程评论;
	private char lockStatus; //锁定状态（1：锁定，0：未锁定）;
	private char courseCategory; //课程类别（1：表示线上课程，0：表示线下课程）;
	private char courseClass; //课程分类（1：眼镜定配工，2：学历，3：技能）;
	private String coursePicture; //课程图片（url链接）;
	private String courseVideo; //课程视频(url链接);
	private int studyNumbers; //课程学习人数;
	private String price;//价格；
	private String groupPrice;//团购价；
	private String instructor;//授课老师;
	private int videoClassification;//视频分类（1：录播；2直播）;
	private String courseCatalog;//课程目录;
	private String recordingStarttime;//录播开始时间
	private String recordingEndtime;//录播结束时间
	private String broadcastingStarttime;//直播开始时间
	private String broadcastingEndtime;//直播结束时间
	private String learningTime;//学习时间
	private int numbers;//成交量/咨询次数
	private int shelfState;//上架状态(1:表示上架,0:表示下架)
	private int sort;//排序
	private String teachersId;//授课老师ID(外键)
	private String studentsId;//学员ID(外键)
	private Teachers teachers;
	
	
	//一对多的关系
    private List<Relation> relationList;
    //一对多的关系
    private List<Question> questionList;
    
    
    
    public Course() {
		super();
	}
    
	
	public Course(String courseName, int classHours, char enableFlag, String courseIntroduction, String courseContent,
			String courseReview, char lockStatus, char courseCategory, char courseClass, String coursePicture,
			String courseVideo, int studyNumbers, String price, String groupPrice, String instructor,
			int videoClassification, String courseCatalog, String recordingStarttime, String recordingEndtime,
			String broadcastingStarttime, String broadcastingEndtime, String learningTime, int numbers, int shelfState,
			int sort, String teachersId, String studentsId, Teachers teachers, List<Relation> relationList,
			List<Question> questionList) {
		super();
		this.courseName = courseName;
		this.classHours = classHours;
		this.enableFlag = enableFlag;
		this.courseIntroduction = courseIntroduction;
		this.courseContent = courseContent;
		this.courseReview = courseReview;
		this.lockStatus = lockStatus;
		this.courseCategory = courseCategory;
		this.courseClass = courseClass;
		this.coursePicture = coursePicture;
		this.courseVideo = courseVideo;
		this.studyNumbers = studyNumbers;
		this.price = price;
		this.groupPrice = groupPrice;
		this.instructor = instructor;
		this.videoClassification = videoClassification;
		this.courseCatalog = courseCatalog;
		this.recordingStarttime = recordingStarttime;
		this.recordingEndtime = recordingEndtime;
		this.broadcastingStarttime = broadcastingStarttime;
		this.broadcastingEndtime = broadcastingEndtime;
		this.learningTime = learningTime;
		this.numbers = numbers;
		this.shelfState = shelfState;
		this.sort = sort;
		this.teachersId = teachersId;
		this.studentsId = studentsId;
		this.teachers = teachers;
		this.relationList = relationList;
		this.questionList = questionList;
	}


	public int getNumbers() {
		return numbers;
	}

	public void setNumbers(int numbers) {
		this.numbers = numbers;
	}

	public int getShelfState() {
		return shelfState;
	}

	public void setShelfState(int shelfState) {
		this.shelfState = shelfState;
	}

	public int getSort() {
		return sort;
	}

	public void setSort(int sort) {
		this.sort = sort;
	}

	public String getRecordingStarttime() {
		return recordingStarttime;
	}

	public void setRecordingStarttime(String recordingStarttime) {
		this.recordingStarttime = recordingStarttime;
	}

	public String getRecordingEndtime() {
		return recordingEndtime;
	}

	public void setRecordingEndtime(String recordingEndtime) {
		this.recordingEndtime = recordingEndtime;
	}

	public String getBroadcastingStarttime() {
		return broadcastingStarttime;
	}

	public void setBroadcastingStarttime(String broadcastingStarttime) {
		this.broadcastingStarttime = broadcastingStarttime;
	}

	public String getBroadcastingEndtime() {
		return broadcastingEndtime;
	}

	public void setBroadcastingEndtime(String broadcastingEndtime) {
		this.broadcastingEndtime = broadcastingEndtime;
	}

	public String getLearningTime() {
		return learningTime;
	}

	public void setLearningTime(String learningTime) {
		this.learningTime = learningTime;
	}

	public Teachers getTeachers() {
		return teachers;
	}

	public void setTeachers(Teachers teachers) {
		this.teachers = teachers;
	}

	public String getTeachersId() {
		return teachersId;
	}

	public void setTeachersId(String teachersId) {
		this.teachersId = teachersId;
	}

	

	public List<Question> getQuestionList() {
		return questionList;
	}

	public void setQuestionList(List<Question> questionList) {
		this.questionList = questionList;
	}

	public List<Relation> getRelationList() {
		return relationList;
	}
	public void setRelationList(List<Relation> relationList) {
		this.relationList = relationList;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public int getClassHours() {
		return classHours;
	}
	public void setClassHours(int classHours) {
		this.classHours = classHours;
	}
	public char getEnableFlag() {
		return enableFlag;
	}
	public void setEnableFlag(char enableFlag) {
		this.enableFlag = enableFlag;
	}
	public String getCourseIntroduction() {
		return courseIntroduction;
	}
	public void setCourseIntroduction(String courseIntroduction) {
		this.courseIntroduction = courseIntroduction;
	}
	public String getCourseContent() {
		return courseContent;
	}
	public void setCourseContent(String courseContent) {
		this.courseContent = courseContent;
	}
	public String getCourseReview() {
		return courseReview;
	}
	public void setCourseReview(String courseReview) {
		this.courseReview = courseReview;
	}
	public char getLockStatus() {
		return lockStatus;
	}
	public void setLockStatus(char lockStatus) {
		this.lockStatus = lockStatus;
	}
	public char getCourseCategory() {
		return courseCategory;
	}
	public void setCourseCategory(char courseCategory) {
		this.courseCategory = courseCategory;
	}
	public char getCourseClass() {
		return courseClass;
	}
	public void setCourseClass(char courseClass) {
		this.courseClass = courseClass;
	}
	public String getCoursePicture() {
		return coursePicture;
	}
	public void setCoursePicture(String coursePicture) {
		this.coursePicture = coursePicture;
	}
	public String getCourseVideo() {
		return courseVideo;
	}
	public void setCourseVideo(String courseVideo) {
		this.courseVideo = courseVideo;
	}
	public int getStudyNumbers() {
		return studyNumbers;
	}
	public void setStudyNumbers(int studyNumbers) {
		this.studyNumbers = studyNumbers;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getGroupPrice() {
		return groupPrice;
	}
	public void setGroupPrice(String groupPrice) {
		this.groupPrice = groupPrice;
	}
	public String getInstructor() {
		return instructor;
	}
	public void setInstructor(String instructor) {
		this.instructor = instructor;
	}
	public int getVideoClassification() {
		return videoClassification;
	}
	public void setVideoClassification(int videoClassification) {
		this.videoClassification = videoClassification;
	}
	public String getCourseCatalog() {
		return courseCatalog;
	}
	public void setCourseCatalog(String courseCatalog) {
		this.courseCatalog = courseCatalog;
	}
	public String getStudentsId() {
		return studentsId;
	}
	public void setStudentsId(String studentsId) {
		this.studentsId = studentsId;
	}
	
	

   
    
}