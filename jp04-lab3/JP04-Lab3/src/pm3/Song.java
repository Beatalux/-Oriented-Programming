package pm3;

public class Song {
	private String mode;
	private String title, singer; 
	private double price;
	


	public Song(String title) {
		this.title=title;
	}
	public Song(String title, int price) {
		
	}

	public Song(String title,String singer,double price) {
		this.title="";
		this.singer="¿Õ∏Ì";
		this.price=10.0;	
	}
	
	public String getMode() {
		return mode;
	}
	
	public void setMode(String mode) {
		this.mode = mode;
		if(mode=="1") {
			this.price=price;
		}
		else if(mode=="2") {
			this.price=0.9*price;
		}
		else
			this.price=0.7*price;
	}
	

	
	
	public String getTitle() {
		return title;
	}


	public String getSinger() {
		return singer;
	}
	
	public double getPrice() {
		return price;
	}



	
	

}
