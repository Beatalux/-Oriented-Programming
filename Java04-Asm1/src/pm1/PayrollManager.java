package pm1;

public abstract class PayrollManager {
	public void writeEmployeePay(Employee emp) {
		long pay=emp.calculatePay();
		writePayment(pay,emp.getName());
	}
	
	public abstract void writePayment(long amount);
	public abstract void writePayment(long amount, String name);

}
