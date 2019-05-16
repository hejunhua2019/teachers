package cn.com.yajiaotong.wface.entity;

import java.util.List;

public class Examination extends WBaseEntity{

	private static final long serialVersionUID = -6595491870486820044L;
	
	private String name;//试卷名称
	private int number;//题目数量
	private double scores;//总分
	private double score;//题目分值
	private double passingScore;//及格分值
	//一对多的关系
    private List<Question> questionList;
    	
	public Examination() {
		super();
	}
	public Examination(String name, int number, double scores, double score, double passingScore,
			List<Question> questionList) {
		super();
		this.name = name;
		this.number = number;
		this.scores = scores;
		this.score = score;
		this.passingScore = passingScore;
		this.questionList = questionList;
	}


	public List<Question> getQuestionList() {
		return questionList;
	}
	public void setQuestionList(List<Question> questionList) {
		this.questionList = questionList;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public double getScores() {
		return scores;
	}
	public void setScores(double scores) {
		this.scores = scores;
	}
	public double getScore() {
		return score;
	}
	public void setScore(double score) {
		this.score = score;
	}
	public double getPassingScore() {
		return passingScore;
	}
	public void setPassingScore(double passingScore) {
		this.passingScore = passingScore;
	}
	
	

}