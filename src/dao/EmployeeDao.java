package dao;

import java.util.List;

import vo.EmployeeVO;

/**
 * @since 2016.05.20
 * @author Jongwan
 * <<Interface>> - EmployeeDao
 */
public interface EmployeeDao {
	//상수
	String PREFIX = "NT";		//전치사
	int MAX_EMPNUM = 99999;		//사원번호의 최대값
	int MAX_EMPNUM_LENGTH = 5;	//사원번호의 최대 길이	
	int MAX_SCORE = 100;		//성적의 최대값
	
	//Abstract Methods
	public abstract void create_EmployeeList(int count) throws Exception;
	public abstract EmployeeVO insert_Employee();
	public abstract String makeFormat_EmpNum(int number);
	public abstract List<EmployeeVO> getEmployee_List();
}
