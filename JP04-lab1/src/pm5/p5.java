package pm5;

import java.util.Scanner;

public class p5 {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int countL[]= {0,0,0,0,0};
		String phoneL[]= {"������", "����","��Ƽ�ӽ�","��̳�","������"};
		
		while(true) {
			String phone=s.next();
			if(phone.equals("���̴�")) {
				String temp=s.next();
				if(temp.equals("��ȣ!"))
					break;
			}
			int count=s.nextInt();
			for(int i=0;i<5;i++) {
				if(phone.equals(phoneL[i])) {
					countL[i]+=count;
					break;
				}
			}
		}
		
		for(int i=0;i<5;i++) {
			System.out.println(countL[i]);
		}
		s.close();
	}
}
