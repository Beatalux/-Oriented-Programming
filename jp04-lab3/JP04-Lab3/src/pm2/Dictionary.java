package pm2;

//���� �ѿ�����
//1876187 ������
public class Dictionary {
	static private String kor[]= {"���","�Ʊ�","��","�̷�","���"};
	static private String eng[]= {"love","baby","money","future","hope"};
	static private int WORDCOUNT;
	
	final static public String korToEngWord(String korWord) {

		//int num=0;
	
		for(int i=0;i<5;i++) {
		if(korWord.equals(kor[i]))
		{
			return (korWord+"��"+eng[i]);
			}
		
		
	
		}
		return (korWord+"�� �� ������ ����");
		
	
		
		
	
	}

}
