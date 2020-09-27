package pm7;

import java.util.Scanner;

public class p7 {
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int asc=0,dsc=0;
		
		String sequ=s.nextLine();
		String[] notes_str=sequ.split(" ");
		int[] notes_int=new int[notes_str.length];
		
		for(int i=0;i<notes_str.length;i++) {
			String note=notes_str[i];
			notes_int[i]=Integer.parseInt(note);
		}
		
		for(int idx=1;idx<notes_int.length;idx++) {
			if(notes_int[idx-1]<notes_int[idx])
				asc++;
			else if(notes_int[idx-1]>notes_int[idx])
				dsc++;
		}
		if(dsc ==0)
			System.out.println("ascending");
		else if(asc==0)
			System.out.println("DESCENDING");
		else
			System.out.println("mixed");
	}

}
