package mmm;
//1876187 서유빈
import java.util.Calendar;

public class Person {
	String name;//이름
	String birth;//생년월일
	private Gender gender;//성별

	enum Gender {//성별은 enum 으로 정의해서 사용
		MAN, WOMAN, UNKNOWN
	}

	public Person(String name, String birth, Gender gender) {//Person 생성자 호출
		this.name = name;
		this.gender = gender;
		if (birth.substring(4,5).equals("-") && birth.substring(7,8).equals("-"))
			this.birth = birth;
		else
			this.birth = "1900-1-1";
			
		
	}

	public Person() {
		this("익명", "1900-1-1", Gender.UNKNOWN);// 위의 생성자 호출

	}

	public String getName() {//이름 getter
		return name;
	}

	public String getBirth() {//생년월일 getter
		return this.birth;
	}

	public Gender getGender() {//성별 getter
		return gender;
	}

	public int getAge() {//현재년도-태어난 년도=나이
		int year = Calendar.getInstance().get(Calendar.YEAR);//오늘 날짜 연도 구하기
		int birthyear = Integer.parseInt((this.birth).substring(0, 4));//String 형태의 생년월일을 int 형으로 바꿔주기
		return (year - birthyear);//year-birthyear로 나이 구하기
	}

	public void showInfo() {//이름, 나이 ,성별 출력
		System.out.println("저자이름: " + this.name);
		System.out.println("저자성별: " + this.gender);
		System.out.println("저자나이: " + getAge());

	}

}
