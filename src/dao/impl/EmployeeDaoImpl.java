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
	private List<EmployeeVO> employee_List;	//��� ����Ʈ
	private HashSet<Integer> empNum_Set; 	//�����ȣ�� ����
	private Random random;

	//Constructor
	public EmployeeDaoImpl() {
		//�� ��ü ���� �� �ʱ�ȭ
		employee_List = new ArrayList<EmployeeVO>();
		empNum_Set = new HashSet<Integer>();
		random = new Random();
	}
	
	
	/** 
	 * Employee ����Ʈ ����
	 * @param count - ����ϰ��� �ϴ� ����� ��
	 * @throws Exception - �Էµ� count�� 99999�� �Ѿ�� ���
	 */
	@Override
	public void create_EmployeeList(int count) throws Exception{
		
		//�����ȣ�� �ִ밪�� �Ѿ�� ��� ���� Error�� ����
		if(count > MAX_EMPNUM){
			throw new Exception("[Range Error] : Please enter the number [ 0 ~ " + MAX_EMPNUM + " ]");
		}
		
		//����� �����Ͽ� ����Ʈ�� �߰�
		for(int i=0 ; i<count ; i++){
			employee_List.add(insert_Employee());
		}
	}

	/** 
	 * Employee ��ü ����
	 * @return EmployeeVO - �����ü ��ȯ
	 */
	@Override
	public EmployeeVO insert_Employee(){
		//1~99999 ������ �����ȣ�� 0~100 ������ ������ ���������� �Ҵ�
		int number = random.nextInt(MAX_EMPNUM) + 1;
		int score = random.nextInt(MAX_SCORE);
		
		//������ ��ȣ�� �����ȣ�� ���տ� ���� ������ �ݺ�
		while(empNum_Set.contains(number)){
			number = random.nextInt(MAX_EMPNUM) + 1;
		}
		
		//���ο� �����ȣ�� set�� �߰�
		empNum_Set.add(number);
		
		//�����ȣ�� format�� �����.
		String empNumber = makeFormat_EmpNum(number);
		
		//�����ȣ�� �������� �����ü�� �����Ͽ� ��ȯ
		return new EmployeeVO(empNumber, score);
	}
	
	/** 
	 * random�� �����ȣ�� ���� 99999 ���ϸ� 0���� ä��� �տ� ��ġ��NT�� ����
	 * @param number - �����ȣ
	 * @return String - ���ο� format�� �����ȣ�� ��ȯ
	 */
	@Override
	public String makeFormat_EmpNum(int number){
		StringBuffer s_Buffer = new StringBuffer(Integer.toString(number));
		
		//�����ȣ�� �ִ� ���̿��� ���� �����ȣ�� ���̸� �� 0���� ä�� ������ ���� ���ѵ� 
		int blank_Num = MAX_EMPNUM_LENGTH - s_Buffer.length();
		//���ʺ��� 0���� ä��
		for(int i = 0; i < blank_Num ; i++){
			s_Buffer.insert(0, "0");
		}
		
		//��ġ�� NT�� �Ǿտ� ����
		s_Buffer.insert(0, PREFIX);
		
		return s_Buffer.toString();
	}

	/** 
	 * Employee ����Ʈ ��ȯ
	 * @return List<EmployeeVO> - ��� ����Ʈ
	 */
	@Override
	public List<EmployeeVO> getEmployee_List() {
		return employee_List;
	}
}