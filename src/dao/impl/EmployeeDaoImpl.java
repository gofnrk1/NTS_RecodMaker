package dao.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;

import dao.EmployeeDao;
import vo.EmployeeVO;

/**
 * @since 2016.05.20
 * @author Jongwan
 * <<Class>> - EmployeeDaoImpl
 */
public class EmployeeDaoImpl implements EmployeeDao {
	//Field
	private List<EmployeeVO> employee_List;	//사원 리스트
	private HashSet<Integer> empNum_Set; 	//사원번호의 집합
	private Random random;

	//Constructor
	public EmployeeDaoImpl() {
		//각 객체 생성 및 초기화
		employee_List = new ArrayList<EmployeeVO>();
		empNum_Set = new HashSet<Integer>();
		random = new Random();
	}
	
	
	/** 
	 * Employee 리스트 생성
	 * @param count - 출력하고자 하는 사원의 수
	 * @throws Exception - 입력된 count가 99999를 넘어갔을 경우
	 */
	@Override
	public void create_EmployeeList(int count) throws Exception{
		
		//사원번호의 최대값을 넘어갔을 경우 범위 Error를 던짐
		if(count > MAX_EMPNUM){
			throw new Exception("[Range Error] : Please enter the number [ 0 ~ " + MAX_EMPNUM + " ]");
		}
		
		//사원을 생성하여 리스트에 추가
		for(int i=0 ; i<count ; i++){
			employee_List.add(insert_Employee());
		}
	}

	/** 
	 * Employee 객체 생성
	 * @return EmployeeVO - 사원객체 반환
	 */
	@Override
	public EmployeeVO insert_Employee(){
		//1~99999 사이의 사원번호와 0~100 사이의 성적을 랜덤값으로 할당
		int number = random.nextInt(MAX_EMPNUM) + 1;
		int score = random.nextInt(MAX_SCORE);
		
		//생성된 번호가 사원번호의 집합에 없을 때까지 반복
		while(empNum_Set.contains(number)){
			number = random.nextInt(MAX_EMPNUM) + 1;
		}
		
		//새로운 사원번호를 set에 추가
		empNum_Set.add(number);
		
		//사원번호의 format을 만든다.
		String empNumber = makeFormat_EmpNum(number);
		
		//사원번호와 성적으로 사원객체를 생성하여 반환
		return new EmployeeVO(empNumber, score);
	}
	
	/** 
	 * random한 사원번호의 값이 99999 이하면 0으로 채우고 앞에 전치사NT를 붙임
	 * @param number - 사원번호
	 * @return String - 새로운 format의 사원번호를 반환
	 */
	@Override
	public String makeFormat_EmpNum(int number){
		StringBuffer s_Buffer = new StringBuffer(Integer.toString(number));
		
		//사원번호의 최대 길이에서 현재 사원번호의 길이를 빼 0으로 채울 공백의 수를 구한뒤 
		int blank_Num = MAX_EMPNUM_LENGTH - s_Buffer.length();
		//앞쪽부터 0으로 채움
		for(int i = 0; i < blank_Num ; i++){
			s_Buffer.insert(0, "0");
		}
		
		//전치사 NT를 맨앞에 붙임
		s_Buffer.insert(0, PREFIX);
		
		return s_Buffer.toString();
	}

	/** 
	 * Employee 리스트 반환
	 * @return List<EmployeeVO> - 사원 리스트
	 */
	@Override
	public List<EmployeeVO> getEmployee_List() {
		return employee_List;
	}
}