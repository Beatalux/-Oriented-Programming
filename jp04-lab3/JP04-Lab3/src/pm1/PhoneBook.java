package pm1;
//1876187 ������
//3-1 �ǽ� ��ȭ��ȣ��
import java.util.Scanner;

public class PhoneBook {
	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("�ο���>>");
		int num = scanner.nextInt();


		Phone numArray[] = new Phone[num];

		for (int i = 0; i < num; i++) {
			System.out.print("�̸��� ��ȭ��ȣ(������� �Է�)>>");
			String name = scanner.next();
			String number = scanner.next();
			
			numArray[i]=new Phone(name,number);
	
			System.out.println();
		}
		
		System.out.println("����Ǿ����ϴ�\n");

		while (true) {
			System.out.print("�˻��� �̸�>>");
			String searchName = scanner.next();
			int n=0;
			for (int i = 0; i < num; i++) 
			{
				if (numArray[i].isYourName(searchName)==true) 
					{System.out.println(searchName + " ��ȭ��ȣ: " + numArray[i].getPhoneNum());
					n++;
					}
			}
					
			if(n==0)
				System.out.println(searchName + "�� �����ϴ�");
					
				
			else if(searchName.equals("�׸�"))
				break;
				
		
				


		}
	}
}
	

