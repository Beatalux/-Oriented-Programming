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
			
			System.out.println("��ȭ��ȣ �Է� ���α׷��Դϴ�");
			
			while(true) {
				System.out.println("�̸� ��ȭ��ȣ>>");
				String line=s.nextLine();
				if(line.equals("�׸�"))
					break;
				fw.write(line+"\n");
			}
			System.out.println(f.getPath()+"�� �����Ͽ����ϴ�");
			s.close();
			fw.close();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}

}
