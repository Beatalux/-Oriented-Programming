package pm1;

public class PaymentOnFile extends PayrollManager{
	public void writePayment(long amount) {
		System.out.println("����"+amount);
	}
	
	public void writePayment(long amount,String name) {
		System.out.println(name+"���� ����"+amount+"���� ���Ͽ� ����մϴ�");
	}

}
