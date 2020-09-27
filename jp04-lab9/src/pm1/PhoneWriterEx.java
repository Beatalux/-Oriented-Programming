package pm1;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class PhoneWriterEx {
	public static void main(String args[]) {
		FileWriter fw =null;
		File f=new File("phone.txt");
		
		try {
			fw=new FileWriter(f);
			Scanner s=new Scanner(System.in);
			
			System.out.println("전화번호 입력 프로그램입니다");
			
			while(true) {
				System.out.println("이름 전화번호>>");
				String line=s.nextLine();
				if(line.equals("그만"))
					break;
				fw.write(line+"\n");
			}
			System.out.println(f.getPath()+"에 저장하였습니다");
			s.close();
			fw.close();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}

}
