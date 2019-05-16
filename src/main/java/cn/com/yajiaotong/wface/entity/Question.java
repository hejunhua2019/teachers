package cn.com.yajiaotong.wface.entity;

public class Question extends WBaseEntity{

	private static final long serialVersionUID = 5577391975980308413L;
	
	private String content;//题目内容
	private String options;//题目选项
	private char answer;//题目答案
	private String type;//题目题型
	private String analysis;//题目解析
	private String coursesId;//所属课目（外键）
	private String sectionId;//所属章节(外键)
	private String examinationId;//所属试卷(外键)
	private Course course;
	private Courses courses;
	private Examination examination;
	
	
	public Question() {
		super();
	}
	
	public Question(String content, String options, char answer, String type, String analysis, String coursesId,
			String sectionId, String examinationId, Course course, Courses courses, Examination examination) {
		super();
		this.content = content;
		this.options = options;
		this.answer = answer;
		this.type = type;
		this.analysis = analysis;
		this.coursesId = coursesId;
		this.sectionId = sectionId;
		this.examinationId = examinationId;
		this.course = course;
		this.courses = courses;
		this.examination = examination;
	}

	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	public Courses getCourses() {
		return courses;
	}
	public void setCourses(Courses courses) {
		this.courses = courses;
	}
	public Examination getExamination() {
		return examination;
	}
	public void setExamination(Examination examination) {
		this.examination = examination;
	}
	public String getExaminationId() {
		return examinationId;
	}
	public void setExaminationId(String examinationId) {
		this.examinationId = examinationId;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getOptions() {
		return options;
	}
	public void setOptions(String options) {
		this.options = options;
	}
	public char getAnswer() {
		return answer;
	}
	public void setAnswer(char answer) {
		this.answer = answer;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getAnalysis() {
		return analysis;
	}
	public void setAnalysis(String analysis) {
		this.analysis = analysis;
	}
	public String getCoursesId() {
		return coursesId;
	}
	public void setCoursesId(String coursesId) {
		this.coursesId = coursesId;
	}
	public String getSectionId() {
		return sectionId;
	}
	public void setSectionId(String sectionId) {
		this.sectionId = sectionId;
	}
	
	
    
}