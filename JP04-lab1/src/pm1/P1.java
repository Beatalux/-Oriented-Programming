package pm1;

import java.util.Scanner;

public class P1 {
	public static void main(String []args) {
		Scanner s=new Scanner(System.in);
		String temp_ty=s.next();
		double temp_in=s.nextDouble();
		double temp_out=0;
		
		switch(temp_ty) {
		case "¼·¾¾":
			temp_out=temp_in *9.0 / 5.0 + 32.0;
			System.out.printf("È­¾¾ ¿Âµµ´Â %.1f\n",temp_out);
			break;
			
		case "È­¾¾":
			temp_out=(temp_in -32.0) *5.0/9.0;
			System.out.printf("¼·¾¾ ¿Âµµ´Â %.1f\n",temp_out);
			break;
			
		default:
			System.out.println("Àß¸øÀÔ·Â");
			break;
			
		}
		
		
	}

}
