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
			
			//파라미터 값을 입력하지 않을 경우 실행 Error를 던짐.
			if( args.length == 0){
				throw new Exception("[Execute Error] : Please input the parameter ~> java RecordMaker [count]");
			}
			//입력된 파라미터 값이 양수가 아닐 경우 Error를 던짐
			else if( -1 == (count = numberIsNegative(args[0])) ){
				throw new Exception("[Parameter Error] : Please enter a positive number");
			}
			
			//입력된 파라미터 값 만큼 리스트를 생성.
			employeeService.create_EmployeeList(count);
			
			//생성된 리스트를 출력.
			employeeService.print_Employee_List();
		}catch(Exception e){
			//Error 발생시 메시지 출력
			System.out.println(e.getMessage());
		}
	}
	
	/**
	 * 파라미터 값을 Integer로 변환하여 양수인지 음수인지 구분.
	 * @param str
	 * @return int - 파라미터 값이 양수이면 변환된 Integer값 반환, 0이하의 수이거나 문자면 -1 
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
    