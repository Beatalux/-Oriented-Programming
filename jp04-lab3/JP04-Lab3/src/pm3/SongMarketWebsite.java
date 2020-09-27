package pm3;

import java.util.Scanner;

public class SongMarketWebsite {
	public static void main (String args[]) {
		Scanner s=new Scanner(System.in);
		String id=s.next();
		
		CartForSongs cart=new CartForSongs(id);
		Song song[]=new Song[cart.MAXCNT];
		
		System.out.println("Strat Shopping- cart of "+id);
		
		for(int i=0;i<cart.MAXCNT;i++)
			{
			song[i]=new Song();
			System.out.print("Input Song Information(title singer price)>>");
			String title=s.next();
			String singer=s.next();
			double price=s.nextDouble();
			
			if(singer=="0") {
				song[i]=new Song(title);
			}
			else if(singer=="0"&&price==0.00) {
				song[i]=new Song(singer);
			}
			
			else
				song[i]=new Song(title,singer,price);
			
			System.out.println("Input Sale Mode(NonDiscounted(1) or OnSale(2) or TodayEvent(3)  )>>" );
			song[i].setMode(s.next());
			
			
			if(title.equals("±×¸¸")) {
				
				cart.calculateTotalPrice(,mode);
				break;
			};
			
		
			
		
		}
		
		System.out.println("Total Price("+id+"):"+cart.calculateTotalPrice());
		
		
		
		
	}

}
