package pm6;

import java.util.Scanner;

public class p6 {
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int n1=s.nextInt();
		int n2=s.nextInt();
		int common=0;
		
		for(int num=1;num<=1000;num++) {
			if(num%n1==0 && num%n2==0) {
				common++;
			}
			System.out.println("두 수의 공배수 개수는"+common);
		}
	}

}
