package mmm;
//1876187 ������
import java.util.Calendar;

public class Person {
	String name;//�̸�
	String birth;//�������
	private Gender gender;//����

	enum Gender {//������ enum ���� �����ؼ� ���
		MAN, WOMAN, UNKNOWN
	}

	public Person(String name, String birth, Gender gender) {//Person ������ ȣ��
		this.name = name;
		this.gender = gender;
		if (birth.substring(4,5).equals("-") && birth.substring(7,8).equals("-"))
			this.birth = birth;
		else
			this.birth = "1900-1-1";
			
		
	}

	public Person() {
		this("�͸�", "1900-1-1", Gender.UNKNOWN);// ���� ������ ȣ��

	}

	public String getName() {//�̸� getter
		return name;
	}

	public String getBirth() {//������� getter
		return this.birth;
	}

	public Gender getGender() {//���� getter
		return gender;
	}

	public int getAge() {//����⵵-�¾ �⵵=����
		int year = Calendar.getInstance().get(Calendar.YEAR);//���� ��¥ ���� ���ϱ�
		int birthyear = Integer.parseInt((this.birth).substring(0, 4));//String ������ ��������� int ������ �ٲ��ֱ�
		return (year - birthyear);//year-birthyear�� ���� ���ϱ�
	}

	public void showInfo() {//�̸�, ���� ,���� ���
		System.out.println("�����̸�: " + this.name);
		System.out.println("���ڼ���: " + this.gender);
		System.out.println("���ڳ���: " + getAge());

	}

}
