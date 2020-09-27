package pm4;

import java.util.Scanner;

public class p4 {
	
	public static void main(String[] args) {
		Scanner s= new Scanner(System.in);
		int countList[]= {0,0,0,0,0};
		
		while(true) {
			String phone=s.nextLine();
			if(phone.equals("끝났다!!!")) {
				break;
			}
			
			switch(phone) {
			case "갤럭시":countList[0]++; break;
			case "베가":countList[1]++;break;
			case "옵티머스":countList[2]++;break;
			case "루미나":countList[3]++;break;
			case"아이폰":countList[4]++;break;
			}
			
			for(int i=0;i<5;i++) {
				System.out.println(countList[i]);
			}
			s.close();
		}
	}

}
