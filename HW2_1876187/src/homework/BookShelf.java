package homework;

import java.util.ArrayList;

public class BookShelf {
	public static final int MAXCOUNT = 100;
	private ArrayList<Book> books = new ArrayList<Book>();//Book arrayList ����
	private int bookCount = 0;//bookCount=0���� ����

	public void setBooks(ArrayList<Book> books) {//ArrayLsit setter
		this.books = books;
		bookCount = books.size();

	}

	public ArrayList<Book> getBookArray() {//ArrayLsit getter
		return books;
	}

	public int getBookCount() {
		return bookCount;
	}

	public String[] getBooks() {
		String[] booksInfoStr = new String[bookCount];
		for (int i = 0; i < bookCount; i++) {
			booksInfoStr[i] = (books.get(i)).print();
		}

		return booksInfoStr;
	}

	public Book selectBook(String title) {//å ������ ������ ���� ���� �����ֱ�

		for (Book book : books) {
			if (title.equals(book.getTitle()))
				return book;
		}

		return null;
	}

	public int selectedBookIndex(String title) {//������ �Է��� å�� �ε��� ��ȯ
		for (int i = 0; i < books.size(); i++) {

			if (title.equals(books.get(i).getTitle()))
				return i;
		}

		return -1;//������ å�� ���� ��� -1��ȯ

	}

	public void addBook(Book book) {//å �����ϴ� �Լ�
		books.add(book);
		bookCount++; // å���� å ����
	}

	public int deleteBook(String title) {//å ����
		if (bookCount == 0)
			return 0;

		int selectedIndex = selectedBookIndex(title);
		if (selectedIndex == -1)
			return -1;

		books.remove(selectedIndex);//å ����
		bookCount--;

		return 1;
	}

	public void clearBookShelf() {//å�� ����

		books.clear();

		bookCount = 0;//clear�� �����Ƿ� å ���� 0
	}
}
