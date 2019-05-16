package cn.com.yajiaotong.wface.entity;

import java.util.Date;

public class Relation extends WBaseEntity{
	
	private static final long serialVersionUID = 2545521079463346183L;
	
	private String studentsId;//学员ID;
	private String coursesId;//课程ID;
	private String teachersId;//教师ID
	private String sectionId;//课程章节ID
	private String recordsId;//学员学习记录ID
	private Students students;
	private Course course;
    private Teachers teachers;
    private Courses courses;
    private Records records;
    
    
	public Relation() {
		super();
	}  

	public Relation(String studentsId, String coursesId, String teachersId, String sectionId, String recordsId,
			Students students, Course course, Teachers teachers, Courses courses, Records records) {
		super();
		this.studentsId = studentsId;
		this.coursesId = coursesId;
		this.teachersId = teachersId;
		this.sectionId = sectionId;
		this.recordsId = recordsId;
		this.students = students;
		this.course = course;
		this.teachers = teachers;
		this.courses = courses;
		this.records = records;
	}



	public Courses getCourses() {
		return courses;
	}

	public void setCourses(Courses courses) {
		this.courses = courses;
	}

	public Records getRecords() {
		return records;
	}

	public void setRecords(Records records) {
		this.records = records;
	}

	public String getSectionId() {
		return sectionId;
	}

	public void setSectionId(String sectionId) {
		this.sectionId = sectionId;
	}

	public String getRecordsId() {
		return recordsId;
	}

	public void setRecordsId(String recordsId) {
		this.recordsId = recordsId;
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

	public String getStudentsId() {
		return studentsId;
	}
	public void setStudentsId(String studentsId) {
		this.studentsId = studentsId;
	}
	public String getCoursesId() {
		return coursesId;
	}
	public void setCoursesId(String coursesId) {
		this.coursesId = coursesId;
	}
	public Students getStudents() {
		return students;
	}
	public void setStudents(Students students) {
		this.students = students;
	}
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	
	
	
    
}