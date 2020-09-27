package mmm;
//1876187 ������
public class Author extends Person {
	private String exp;// ���

	public Author(String name, String birth, Gender gender, String exp) {//Author ������
		super(name, birth, gender);
		this.exp = exp;
	}

	public Author() {//��� �ʵ� �ʱ�ȭ
		super();
		this.exp = null;
	}

	public String getExp() {//��� getter
		return exp;
	}

	public void setExp(String exp) {//��� setter
		this.exp = exp;
	}

	public void showInfo() {//Person �޼ҵ� ���ٶ��̵�
		super.showInfo();// ����Ŭ���� �޼ҵ� ȣ��
		System.out.println("���ڰ��: " + getExp());
	}

}
