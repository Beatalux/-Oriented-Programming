package pm3;

import java.util.Scanner;

public class p3 {
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		
		int intArray[] =new int[5];
		intArray[0]=s.nextInt();
	
		int biggest=intArray[0];
		int sum=intArray[0];
		for(int idx=1;idx<5;idx++) {
			intArray[idx]=s.nextInt();
			if(biggest <intArray[idx])
				biggest=intArray[idx];
			sum+=intArray[idx];
		}
		
		System.out.println("가장 큰 수="+biggest);
		System.out.println("합계= "+sum);
	}

}
