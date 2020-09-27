package pm2;

import java.util.Scanner;

public class DictionaryDemo {
	public static void main(String args[]) {
		Scanner s=new Scanner(System.in);
		
		Dictionary dict=new Dictionary();
		
		System.out.println("한영 단어 검색 프로그램입니다");
		while(true) {
		System.out.print("한글 단어?");
		String what=s.next();
		if(what.equals("그만"))
			break;
		System.out.println(dict.korToEngWord(what));
		
		
		}
	}

}
