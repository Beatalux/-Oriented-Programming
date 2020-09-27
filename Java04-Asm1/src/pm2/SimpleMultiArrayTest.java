package pm2;

import java.util.Scanner;

public class SimpleMultiArrayTest {
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int row=s.nextInt();
		int col=s.nextInt();
		
		char[][]arr=new char[row][col];
		
		s.nextLine();
		
		for(int i=0;i<row;i++) {
			String k=s.nextLine();
			for(int j=0;j<col;j++) {
				arr[i][j]=k.charAt(j);
			}
		}
		
		System.out.println();
		
		for(int i=0;i<row;i++) {
			for(int j=0;j<col;j++) {
				System.out.println(arr[i][j]);
			}
			System.out.println();
		}
	}

}
