package mmm;
//1876187 ������
//���ø����̼� ���� �޼ҵ� main�� ���� Ŭ����

import java.util.Scanner;
import mmm.Person.Gender;


public class BookMgt {
	public static void main(String args[]) {// ����Ŭ���� ����
		Scanner s = new Scanner(System.in);
		BookShelf bookShelf = new BookShelf();// å�� bookShelf ��ü ����

		do {// start of do-while
			System.out.println("========================================");
			System.out.println("1: å �߰�, 2: ��� å �˻�, 3: å �˻�, 4: å ����, 5: å ����, 6: ��� å ����, 7: ����");
			System.out.println("========================================");
			System.out.print("�޴��� �����ϼ��� >>>");
			int n = s.nextInt();// �޴� �Է¹ޱ�
			Book b;// å ����
			Author a;// �۰� ����

			switch (n) {// switch�� ����: å �߰�, å �˻�, ����, ����, ��� å �˻�, ����, ���� ���
			case 1:// 1-å �߰�

				b = new Book();// å ��ü ����
				a = new Author();// �۰� ��ü ����

				System.out.println("\nå�� ������ �Է��ϼ���.(����, ���ǻ�, å���� ������ �Է�)");
				String title = s.next();// ���� �Է� �ޱ�
				String where = s.next();// ����ó �Է� �ޱ�
				String type = s.next();// Ÿ�� �Է� �ޱ�

				System.out.println("���� ������ �Է��ϼ���.(�̸�, �������(yyyy-mm-dd), ����(��:1, ��:2), ��� ������ �Է�)");
				String name = s.next();// ���� �̸� �Է¹ޱ�
				String birth = s.next();// ������� �Է¹ޱ�

				int gender = s.nextInt();// ���� �Է� �ޱ�
				String exp = s.next();// ��� �Է¹ޱ�

				if (gender == 1)// ���� 1�� �Է����� ��� ����
					a = new Author(name, birth, Gender.MAN, exp);
				else if (gender == 2)// ���� 2�� �Է����� ��� ����
					a = new Author(name, birth, Gender.WOMAN, exp);
				else// �� �� �Է������� ���� unknown
					a = new Author(name, birth, Gender.UNKNOWN, exp);
				b = new Book(title, where, type, a);// �Է� ���� ������ ���� ���� å ��ü ����
				bookShelf.addBook(b);// å�忡 å �ֱ�
				break;// case 1 ����

			case 2:// 2-��� å �˻�
				System.out.println("\n[�� " + bookShelf.getNowbook() + "��]");
				bookShelf.getBooks();// bookShelf�� getBooks �޼ҵ� ȣ��
				break;// case 2 ����

			case 3:// case 3- å �˻�
				System.out.println("�˻��� å�� ������ �Է��ϼ���.");
				b=bookShelf.selectBook(s.next());// bookShelf�� selectBook�� �޼ҵ� ȣ��
				break;// case 3 ����

			case 4:// case 4- å ����
				System.out.println("������ å�� ������ �Է��ϼ���.");
				String fixedtitle = s.next();// �����ϰ� ���� å ���� �Է�
				b = bookShelf.selectBook(fixedtitle);// �� å ���� ���
				if(b==null)
					break;

				System.out.println("���ο� ������ �Է��ϼ���.");
				String fixingtitle = s.next();// ���� ������ å ���� �ӷ�
				b.update(fixingtitle);// ���� �����Ͽ� å ���� update
				System.out.println("���ǻ縦 �����Ͻðڽ��ϱ�?(y or n)");
				if (s.next().equals("n")) {// n �Է½� case 4 ����
					b.print();
					break;
				} else {// y �Է½� ���ǻ� �� ����
					System.out.println("\n���ο� ���ǻ縦 �Է��ϼ���.");
					b.update(fixingtitle, s.next());// ����, ���ǻ� �����Ͽ� å ���� update
					b.print();// �ٲ� ���� ����Ʈ
					break;
				}

			case 5:// case 5- å ����
				System.out.println("������  å�� ������ �Է��ϼ���.");
				String rvtitle = s.next();// ������ å ���� �ӷ�
				b = bookShelf.selectBook(rvtitle);// ������ å ���� ���
				if(b==null)
					break;
				System.out.println("���� å�� �����Ͻðڽ��ϱ�?(y or n)");
				if (s.next().equals("y"))// ���� ������ ��� �� å ����
					bookShelf.deleteBook(rvtitle);
				break;// case 5 ����

			case 6:// case 6- ��� å ����
				System.out.println("���� ��� å�� �����Ͻðڽ��ϱ�?(y or n)");
				if (s.next().equals("y"))// y ���� �� ��� å ����
					bookShelf.clearBookShelf();
				break;// case 6 ����
			case 7:// case 7- 7���� �� ����
				System.out.println("\n\n***���α׷��� �����մϴ�***");
				break;// case 7 ��
			}

			if (n == 7)
				break;// �� switch ������ 7���ý� while�� ����
		} while (bookShelf.getMAXCOUNT() > bookShelf.getNowbook());// å�� ���� Maxcount ���� �ʴ� ������ ��� ���� ����

		s.close();// ��ĳ�� �ݱ�

	}

}
