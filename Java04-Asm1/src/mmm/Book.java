package mmm;
//1876187 ������

public class Book {
	private String title, where, type;// ����, ���ǻ�, Ÿ��
	private Author author;//Author Ÿ���� �۰�

	public Book(String title, String where, String type, Author author) {//Book ������
		super();
		this.title = title;
		this.where = where;
		this.type = type;
		this.author = author;
	}

	public Book() {// �ʵ� �� �ʱ�ȭ
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

	public void print() {//å ����(����, ���ǻ�, Ÿ��, �����̸�)�� ���
		System.out.println("����: " + getTitle());
		System.out.println("���ǻ�: " + getWhere());
		System.out.println("Ÿ��: " + getType());
		System.out.println("�����̸�: " + getAuthor().name);

	}

	public void printDetail() {//å�� ������ ���� ������ ����Ѵ�(����, ���ǻ�, Ÿ��, �����̸�, ���ڳ���, ���ڰ��)
		System.out.println("����: " + getTitle());
		System.out.println("���ǻ�: " + getWhere());
		System.out.println("Ÿ��: " + getType());
		System.out.println("�����̸�: " + getAuthor().name);
		System.out.println("���ڼ���: " + author.getGender());
		System.out.println("���ڳ���: " + author.getAge());
		System.out.println("���ڰ��: " + author.getExp());
	}

	public void update(String title) {// å ���� ����
		this.title = title;
	}

	public void update(String title, String where) {// å ���ǻ� ����
		this.title = title;
		this.where = where;
	}

}
