package pm2;

import java.util.Scanner;

public class p2 {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		
		System.out.println("어른? 청소년? 어린이? :");
		String what= s.next();
		
		switch(what) {
		case "어른":
		case "청소년":
		case "어린이":
			System.out.println(what + "요금 적용합니다");
			break;
		default:
			System.out.println("잘못 입력 하셨습니다");
			break;
				
		}
	}
}
