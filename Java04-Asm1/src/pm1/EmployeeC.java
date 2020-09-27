package pm1;

import java.util.Scanner;

public class EmployeeC {
public static void main(String args[]) {
	Scanner s=new Scanner(System.in);
	
	System.out.print("이름 입력>>");
	String name=s.next();
	System.out.println("아이디 입력>>");
	String id=s.next();
	System.out.println("정상근무 시간 입력>>");
	int workHours=s.nextInt();
	System.out.println("시간외 근무시간 입력>>");
	int overTimeHours=s.nextInt();
	System.out.println();
	
	PayManager payManager=new PayLogic1();
	Employee emp=new Employee(id,name,workHours,overTimeHours);
	emp.setPayManager(payManager);
	
	PayrollManager printManager=new PaymentOnConsole();
	printManager.writeEmployeePay(emp);
	
	s.close();
}
}
