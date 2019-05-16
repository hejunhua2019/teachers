package cn.com.yajiaotong.wface.entity;

public class Order extends WBaseEntity{
 
	private static final long serialVersionUID = -6570006708148404860L;
	
	private double money;//订单金额
	private double payAmount;//支付金额
	private char status;//订单状态(1:已付款，2:待付款,0:已取消)
	private char mode;//支付方式(1:支付宝,2:微信)
	private String coursesId;//所属课程(外键)
	private String studentsId;//所属学员(外键)
	private Course course;
	private Students students;
		
	public Order() {
		super();
	}
		
	public Order(double money, double payAmount, char status, char mode, String coursesId, String studentsId,
			Course course, Students students) {
		super();
		this.money = money;
		this.payAmount = payAmount;
		this.status = status;
		this.mode = mode;
		this.coursesId = coursesId;
		this.studentsId = studentsId;
		this.course = course;
		this.students = students;
	}


	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	public Students getStudents() {
		return students;
	}
	public void setStudents(Students students) {
		this.students = students;
	}
	public String getStudentsId() {
		return studentsId;
	}
	public void setStudentsId(String studentsId) {
		this.studentsId = studentsId;
	}
	public double getMoney() {
		return money;
	}
	public void setMoney(double money) {
		this.money = money;
	}
	public double getPayAmount() {
		return payAmount;
	}
	public void setPayAmount(double payAmount) {
		this.payAmount = payAmount;
	}
	public char getStatus() {
		return status;
	}
	public void setStatus(char status) {
		this.status = status;
	}
	public char getMode() {
		return mode;
	}
	public void setMode(char mode) {
		this.mode = mode;
	}
	public String getCoursesId() {
		return coursesId;
	}
	public void setCoursesId(String coursesId) {
		this.coursesId = coursesId;
	}
	
	

}