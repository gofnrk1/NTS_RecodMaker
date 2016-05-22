package vo;

/**
 * @since 2016.05.20
 * @author Jongwan
 * <<Class>> - EmployeeVO
 */
public class EmployeeVO {
	//Field
	private String empNumber;		//사원번호
	private int score;				//성적
	
	//Constructor
	public EmployeeVO(String empNumber, int score) {
		this.empNumber = empNumber;
		this.score = score;
	}

	//Getters & Setters
	public String getEmpNumber() {
		return empNumber;
	}

	public void setEmpNumber(String empNumber) {
		this.empNumber = empNumber;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	@Override
	public String toString() {
		return empNumber + " " + score;
	}
}
