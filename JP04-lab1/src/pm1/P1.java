package pm1;

import java.util.Scanner;

public class P1 {
	public static void main(String []args) {
		Scanner s=new Scanner(System.in);
		String temp_ty=s.next();
		double temp_in=s.nextDouble();
		double temp_out=0;
		
		switch(temp_ty) {
		case "����":
			temp_out=temp_in *9.0 / 5.0 + 32.0;
			System.out.printf("ȭ�� �µ��� %.1f\n",temp_out);
			break;
			
		case "ȭ��":
			temp_out=(temp_in -32.0) *5.0/9.0;
			System.out.printf("���� �µ��� %.1f\n",temp_out);
			break;
			
		default:
			System.out.println("�߸��Է�");
			break;
			
		}
		
		
	}

}
