package pm1;

public class PaymentOnFile extends PayrollManager{
	public void writePayment(long amount) {
		System.out.println("월급"+amount);
	}
	
	public void writePayment(long amount,String name) {
		System.out.println(name+"직언 월급"+amount+"원을 파일에 출력합니다");
	}

}
