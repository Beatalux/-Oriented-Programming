package pm1;

import java.util.Scanner;

public class EmployeeC {
public static void main(String args[]) {
	Scanner s=new Scanner(System.in);
	
	System.out.print("�̸� �Է�>>");
	String name=s.next();
	System.out.println("���̵� �Է�>>");
	String id=s.next();
	System.out.println("����ٹ� �ð� �Է�>>");
	int workHours=s.nextInt();
	System.out.println("�ð��� �ٹ��ð� �Է�>>");
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
