package pm1;

public class payLogic2 implements PayManager{
	public long calculatePay(Employee emp) {
		long pay=emp.getWorkHours()*1000+emp.getOverTimeHours()*20000;
		return pay;
	}

}
