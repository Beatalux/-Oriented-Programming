package homework;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class BookMgt {
	private static final String FileOutputStrean = null;
	private static Scanner scan = new Scanner(System.in);
	private static BookShelf bookShelf=new BookShelf();//bookShelf ��ü ����
	
	public static void main(String[] args) throws IOException, ClassNotFoundException {//IOException, ClassNotFoundException ����ó��

		try {
			readBooks();//���Ͽ��� å �о����
		} catch (ClassNotFoundException | IOException e) {
			System.out.println(e.getMessage());
			return;
		}
		

		while (true) {
			int menu;
			try{//start of try-catch
				menu = showMenu();
				if (menu == 7)
					break;
				
				else if(menu<1||menu>7) {//���� ���� ���ڸ� �Է��� ���
					System.out.println("���� ���� ���ڸ� �Է��ϼ���");
				}
				

				switch (menu) {//start of switch
				case 1:
					insertBookInfo();
					break;
				case 2:
					showAllBookInfo();
					break;
				case 3:
					selectBookInfo();
					break;
				case 4:
					updateBookInfo();
					break;
				case 5:
					removeBookFromBookShelf();
					break;
				case 6:
					clearBookShelf();
					break;
				}//end of switch
				
			}catch (NumberFormatException e) {//NumberFormatException ���� ó��
				System.out.println("�����Է�!");
			}catch(ClassNotFoundException e)//ClassNotFoundException ���� ó��
			{System.out.println(e.getMessage());
			}catch(IOException e)//IOException ���� ó��
			{System.out.println(e.getMessage());
			}
			catch(Exception e)//Exception ���� ó��
			{System.out.println(e.getMessage());
			continue;
			}
			System.out.println();
		}

		System.out.println("���α׷��� �����մϴ�.");
		scan.close();

		try {
			writeBooks();
		} catch (IOException e) {
			System.out.println(e.getMessage());
			return;
		}
		System.out.println("Bye~");
	}// end of Main

	
	@SuppressWarnings("unchecked")
	public static void readBooks() throws IOException, ClassNotFoundException {//���Ͽ��� å �о����
		File bf = new File("myBookShelf.dat");
		if (!bf.exists())
			return;

		// ������ ������ ���Ͽ� �ִ� å ���� �о�� ArrayList �� ����
		FileInputStream f = new FileInputStream("myBookShelf.dat");
		ObjectInputStream fin = new ObjectInputStream(f);

		bookShelf.setBooks((ArrayList<Book>) fin.readObject());

		fin.close();
	}

	@SuppressWarnings("static-access")
	public static void writeBooks() throws IOException {//���Ͽ� ����
		FileOutputStream f1 = new FileOutputStream("myBookShelf.dat");
		ObjectOutputStream fout = new ObjectOutputStream(f1);

		fout.writeObject(bookShelf.getBookArray());
		fout.close();//���� �ݾ��ֱ�
	}

	public static int showMenu() throws NumberFormatException{//�޴� �����ֱ�
		System.out.println("========================================================");
		System.out.println("1.å �߰� 2.��� å �˻� 3.å �˻� 4.å ���� 5.å ���� 6.��� å ���� 7.����");
		System.out.println("========================================================");
		int menu = -1;

		System.out.print("�޴��� �����ϼ��� >> ");

		menu = Integer.parseInt(scan.nextLine());//�޴� �Է¹ޱ�

		System.out.println();
		return menu;

	}

	public static void insertBookInfo() throws IOException {// 1��-å �߰�

		// å ���� �Է�
		System.out.println("å�� ������ �Է��ϼ���.(����, ���ǻ�, å���� ������ �Է�)");
		System.out.print("���� >> ");
		String title = scan.nextLine();
		System.out.print("���ǻ� >> ");
		String publisher = scan.nextLine();
		System.out.print("å���� >> ");
		String type = scan.nextLine();

		System.out.println();
		System.out.println("���� ������ �Է��ϼ���.(�̸�, �������, ����(��:1, ��:2), ��� ������ �Է�)");
		System.out.print("�̸� >> ");
		String name = scan.nextLine();
		System.out.print("������� >> ");
		String birthdate = scan.nextLine();
		System.out.print("���� >> ");
		int g = Integer.parseInt(scan.nextLine());
		System.out.print("��� >> ");
		String career = scan.nextLine();

		Gender gender = Gender.UNKNOWN;
		if (g == 1)
			gender = Gender.MAN;
		else if (g == 2)
			gender = Gender.WOMAN;

		Author author = new Author(name, birthdate, gender, career);
		Book book = new Book(title, publisher, type, author);
		bookShelf.addBook(book);
		System.out.println();
		System.out.println("å�� �����߽��ϴ�");

	}// end of choice 1

	public static void showAllBookInfo() throws IOException, ClassNotFoundException { // 2��-���Ͽ��� �о����

		String[] bookInfos = bookShelf.getBooks();

		String deco = new String(new char[60]).replace("\0", "=");
		System.out.println(deco);
		System.out.println(String.format("�� %d���� å�� �ֽ��ϴ�.", bookShelf.getBookCount()));
		System.out.println(deco);

		for (String s : bookInfos) {//��� å ���� �Է�
			System.out.println(s);
		}

	}

	public static void selectBookInfo() throws IOException, ClassNotFoundException {// 3�� å �˻�

		System.out.print("�˻��� å�� ������ �Է��ϼ��� >> ");
		String title = scan.nextLine();

		Book selectedBook = bookShelf.selectBook(title);
		if (selectedBook == null) {//�˻��� å�� ���� ���
			System.out.println("�˻��� å�� �����ϴ�.");
			return;
		}

		System.out.println(selectedBook.printDetail());//�˻��� å�� �ִ� ���� ���� print

	}// end of-choice 3

	public static void updateBookInfo() {// 4�� : å ����
		System.out.print("������ å�� ������ �Է��ϼ��� >> ");
		String title = scan.nextLine();
	

		Book selectedBook = bookShelf.selectBook(title);
		if (selectedBook == null) {//���� å ������ �Է��� ���
			System.out.println("������ å�� �����ϴ�.");
			return;
		}

		System.out.print("�� ������ �Է��ϼ��� >> ");//������ å ���� �Է�
		String newtitle = scan.nextLine();

		System.out.print("���ǻ絵 �����Ͻðڽ��ϱ�?(y or n) >> ");
		String confirm = scan.nextLine().toLowerCase();

		if (confirm.equals("y")) {//y �Է½� ���ǻ絵 ����
			System.out.print("�� ���ǻ縦 �Է��ϼ��� >> ");
			String newpublisher = scan.nextLine();

			selectedBook.update(newtitle, newpublisher);//å ����, ���ǻ� ����
		} else {
			selectedBook.update(newtitle);//å ���� ����
		}

		System.out.println("������ �Ϸ�Ǿ����ϴ�.");

	}

	public static void removeBookFromBookShelf() {// 5�� : å ����
		System.out.print("������ å�� ������ �Է��ϼ��� >> ");
		String title = scan.nextLine();

		Book selectedBook = bookShelf.selectBook(title);
		if (selectedBook == null) {
			System.out.println("������ å�� �����ϴ�.");
			return;
		}

		System.out.println(selectedBook.printDetail());
		System.out.print("å�� ���� �����ϼ��ڽ��ϱ�?(y or n) >> ");//y�� ���� ��� Ȯ���� ����
		String confirm = scan.nextLine().toLowerCase();

		if (confirm.equals("n"))//n�� ���� ��� �ٽ� �޴��� �����ش�
			return;

		int msg = bookShelf.deleteBook(title);
		if (msg == 1) {
			System.out.println("å�� �����Ͽ����ϴ�.");
		}

	}// end of choice 5

	public static void clearBookShelf() {// 6�� ��ü����
		System.out.print("å�� ��� �����ϼ��ڽ��ϱ�?(y or n) >> ");
		String confirm = scan.nextLine().toLowerCase();

		if(confirm.equals("y")){//y�� ���� ��� Ȯ���� ����
			bookShelf.clearBookShelf();
			System.out.println("å�� ��� �����Ͽ����ϴ�.");
		}
	}//end of choice 6
}
