package service;

/**
 * @since 2016.05.20
 * @author Jongwan
 * <<Interface>> - EmployeeService
 */
public interface EmployeeService {
	//Abstract Methods
	public abstract void create_EmployeeList(int count) throws Exception;
	public abstract void print_Employee_List();
}
