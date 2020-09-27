package mmm;
//1876187 서유빈

public class Book {
	private String title, where, type;// 제목, 출판사, 타입
	private Author author;//Author 타임의 작가

	public Book(String title, String where, String type, Author author) {//Book 생성자
		super();
		this.title = title;
		this.where = where;
		this.type = type;
		this.author = author;
	}

	public Book() {// 필드 값 초기화
		setTitle(null);
		setWhere(null);
		setType(null);
		setAuthor(null);
	}

	public String getTitle() {//title getter
		return title;
	}

	public void setTitle(String title) {//title setter
		this.title = title;
	}

	public String getWhere() {//where getter
		return where;
	}

	public void setWhere(String where) {//where setter
		this.where = where;
	}

	public String getType() {//type getter
		return type;
	}

	public void setType(String type) {//type setter
		this.type = type;
	}

	public Author getAuthor() {//author getter
		return author;
	}

	public void setAuthor(Author author) {//author setter
		this.author = author;
	}

	public void print() {//책 정보(제목, 출판사, 타입, 저자이름)을 출력
		System.out.println("제목: " + getTitle());
		System.out.println("출판사: " + getWhere());
		System.out.println("타입: " + getType());
		System.out.println("저자이름: " + getAuthor().name);

	}

	public void printDetail() {//책의 정보와 저자 정보를 출력한다(제목, 출판사, 타입, 저자이름, 저자나이, 저자경력)
		System.out.println("제목: " + getTitle());
		System.out.println("출판사: " + getWhere());
		System.out.println("타입: " + getType());
		System.out.println("저자이름: " + getAuthor().name);
		System.out.println("저자성별: " + author.getGender());
		System.out.println("저자나이: " + author.getAge());
		System.out.println("저자경력: " + author.getExp());
	}

	public void update(String title) {// 책 제목 수정
		this.title = title;
	}

	public void update(String title, String where) {// 책 출판사 수정
		this.title = title;
		this.where = where;
	}

}
