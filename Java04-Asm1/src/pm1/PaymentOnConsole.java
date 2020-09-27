package pm1;

public class PaymentOnConsole extends PayrollManager {
	public void writePayment(long amount) {
		System.out.println("직원의 월급은"+amount);
	}
	public void writePayment(long amount, String name) {
		System.out.println(name+"직원의 월급은"+amount+"원입니다");
	}

}
