package pm2;

import java.util.Scanner;

public class DictionaryDemo {
	public static void main(String args[]) {
		Scanner s=new Scanner(System.in);
		
		Dictionary dict=new Dictionary();
		
		System.out.println("�ѿ� �ܾ� �˻� ���α׷��Դϴ�");
		while(true) {
		System.out.print("�ѱ� �ܾ�?");
		String what=s.next();
		if(what.equals("�׸�"))
			break;
		System.out.println(dict.korToEngWord(what));
		
		
		}
	}

}
