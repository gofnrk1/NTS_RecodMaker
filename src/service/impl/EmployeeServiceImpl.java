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
		//employeeDao객체 생성 및 초기화
		employeeDao = new EmployeeDaoImpl();
	}

	
	/** 
	 * Employee 리스트 생성
	 * @param count - 출력하고자 하는 사원의 수
	 * @throws Exception - 입력된 count가 99999를 넘어갔을 경우
	 */
	@Override
	public void create_EmployeeList(int count) throws Exception{
		employeeDao.create_EmployeeList(count);
	}


	/** 
	 * Employee 리스트 출력
	 */
	@Override
	public void print_Employee_List() {
		List<EmployeeVO> employee_List = employeeDao.getEmployee_List();
		
		for(EmployeeVO vo : employee_List){
			System.out.println(vo);
		}
	}
}
