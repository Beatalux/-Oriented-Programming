package pm2;

import java.util.Scanner;

public class p2 {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		
		System.out.println("�? û�ҳ�? ���? :");
		String what= s.next();
		
		switch(what) {
		case "�":
		case "û�ҳ�":
		case "���":
			System.out.println(what + "��� �����մϴ�");
			break;
		default:
			System.out.println("�߸� �Է� �ϼ̽��ϴ�");
			break;
				
		}
	}
}
