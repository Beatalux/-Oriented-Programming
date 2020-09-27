package mmm;
//1876187 서유빈
public class Author extends Person {
	private String exp;// 경력

	public Author(String name, String birth, Gender gender, String exp) {//Author 생성자
		super(name, birth, gender);
		this.exp = exp;
	}

	public Author() {//경력 필드 초기화
		super();
		this.exp = null;
	}

	public String getExp() {//경력 getter
		return exp;
	}

	public void setExp(String exp) {//경력 setter
		this.exp = exp;
	}

	public void showInfo() {//Person 메소드 오바라이딩
		super.showInfo();// 슈퍼클래스 메소드 호출
		System.out.println("저자경력: " + getExp());
	}

}
