package dao;

import java.util.List;

import vo.EmployeeVO;

/**
 * @since 2016.05.20
 * @author Jongwan
 * <<Interface>> - EmployeeDao
 */
public interface EmployeeDao {
	//���
	String PREFIX = "NT";		//��ġ��
	int MAX_EMPNUM = 99999;		//�����ȣ�� �ִ밪
	int MAX_EMPNUM_LENGTH = 5;	//�����ȣ�� �ִ� ����	
	int MAX_SCORE = 100;		//������ �ִ밪
	
	//Abstract Methods
	public abstract void create_EmployeeList(int count) throws Exception;
	public abstract EmployeeVO insert_Employee();
	public abstract String makeFormat_EmpNum(int number);
	public abstract List<EmployeeVO> getEmployee_List();
}
