package pm1;
//1876187 서유빈
//3-1 실습 전화번호부
import java.util.Scanner;

public class PhoneBook {
	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("인원수>>");
		int num = scanner.nextInt();


		Phone numArray[] = new Phone[num];

		for (int i = 0; i < num; i++) {
			System.out.print("이름과 전화번호(공백없이 입력)>>");
			String name = scanner.next();
			String number = scanner.next();
			
			numArray[i]=new Phone(name,number);
	
			System.out.println();
		}
		
		System.out.println("저장되었습니다\n");

		while (true) {
			System.out.print("검색할 이름>>");
			String searchName = scanner.next();
			int n=0;
			for (int i = 0; i < num; i++) 
			{
				if (numArray[i].isYourName(searchName)==true) 
					{System.out.println(searchName + " 전화번호: " + numArray[i].getPhoneNum());
					n++;
					}
			}
					
			if(n==0)
				System.out.println(searchName + "이 없습니다");
					
				
			else if(searchName.equals("그만"))
				break;
				
		
				


		}
	}
}
	

