import service.impl.EmployeeServiceImpl;

/**
 * @since 2016.05.20
 * @author Jongwan
 * <<Class>> - RecordMaker
 */
public class RecordMaker {

	public static void main(String[] args) {
		//employeeService
		EmployeeServiceImpl employeeService = new EmployeeServiceImpl();
		
		try{
			int count = -1;
			
			//�Ķ���� ���� �Է����� ���� ��� ���� Error�� ����.
			if( args.length == 0){
				throw new Exception("[Execute Error] : Please input the parameter ~> java RecordMaker [count]");
			}
			//�Էµ� �Ķ���� ���� ����� �ƴ� ��� Error�� ����
			else if( -1 == (count = numberIsNegative(args[0])) ){
				throw new Exception("[Parameter Error] : Please enter a positive number");
			}
			
			//�Էµ� �Ķ���� �� ��ŭ ����Ʈ�� ����.
			employeeService.create_EmployeeList(count);
			
			//������ ����Ʈ�� ���.
			employeeService.print_Employee_List();
		}catch(Exception e){
			//Error �߻��� �޽��� ���
			System.out.println(e.getMessage());
		}
	}
	
	/**
	 * �Ķ���� ���� Integer�� ��ȯ�Ͽ� ������� �������� ����.
	 * @param str
	 * @return int - �Ķ���� ���� ����̸� ��ȯ�� Integer�� ��ȯ, 0������ ���̰ų� ���ڸ� -1 
	 */
	public static int numberIsNegative(String str){
		try{
			int num = Integer.parseInt(str);
			
			if(num > 0 ) return num;
			else return -1;
		}catch(NumberFormatException e){
			return -1;
		}
	}
}
    