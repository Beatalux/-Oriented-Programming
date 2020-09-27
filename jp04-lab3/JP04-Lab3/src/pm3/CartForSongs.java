package pm3;

public class CartForSongs {
	final public int MAXCNT=100;
	private String userId;
	private String SongCart[];
	private int songCnt;
	
	public CartForSongs(String userId) {
		this.userId=userId;
	}

	
	
	
	public String getUserId() {
		return userId;
	}
	
	public int getSongCnt() {
		return songCnt;
	}
	
	
	
	
	public double calculateTotalPrice(int price, String mode) {
		
		
	}
	
	public addSong(int song) {
		this.songCnt++;
	}

}
