package pm4;

import java.util.Scanner;

public class p4 {
	
	public static void main(String[] args) {
		Scanner s= new Scanner(System.in);
		int countList[]= {0,0,0,0,0};
		
		while(true) {
			String phone=s.nextLine();
			if(phone.equals("������!!!")) {
				break;
			}
			
			switch(phone) {
			case "������":countList[0]++; break;
			case "����":countList[1]++;break;
			case "��Ƽ�ӽ�":countList[2]++;break;
			case "��̳�":countList[3]++;break;
			case"������":countList[4]++;break;
			}
			
			for(int i=0;i<5;i++) {
				System.out.println(countList[i]);
			}
			s.close();
		}
	}

}
