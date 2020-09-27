package pm2;

//예제 한영사전
//1876187 서유빈
public class Dictionary {
	static private String kor[]= {"사랑","아기","돈","미래","희망"};
	static private String eng[]= {"love","baby","money","future","hope"};
	static private int WORDCOUNT;
	
	final static public String korToEngWord(String korWord) {

		//int num=0;
	
		for(int i=0;i<5;i++) {
		if(korWord.equals(kor[i]))
		{
			return (korWord+"은"+eng[i]);
			}
		
		
	
		}
		return (korWord+"는 제 사전에 없음");
		
	
		
		
	
	}

}
