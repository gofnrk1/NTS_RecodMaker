package service.impl;

import java.util.List;

import dao.impl.EmployeeDaoImpl;
import service.EmployeeService;
import vo.EmployeeVO;

/**
 * @since 2016.05.20
 * @author Jongwan
 * <<Class>> - EmployeeServiceImpl
 */
public class EmployeeServiceImpl implements EmployeeService{
	
	//Field
	private EmployeeDaoImpl employeeDao;
	
	//Constructor
	public EmployeeServiceImpl() {
		//employeeDao��ü ���� �� �ʱ�ȭ
		employeeDao = new EmployeeDaoImpl();
	}

	
	/** 
	 * Employee ����Ʈ ����
	 * @param count - ����ϰ��� �ϴ� ����� ��
	 * @throws Exception - �Էµ� count�� 99999�� �Ѿ�� ���
	 */
	@Override
	public void create_EmployeeList(int count) throws Exception{
		employeeDao.create_EmployeeList(count);
	}


	/** 
	 * Employee ����Ʈ ���
	 */
	@Override
	public void print_Employee_List() {
		List<EmployeeVO> employee_List = employeeDao.getEmployee_List();
		
		for(EmployeeVO vo : employee_List){
			System.out.println(vo);
		}
	}
}
