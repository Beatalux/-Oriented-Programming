package homework;

import java.util.ArrayList;

public class BookShelf {
	public static final int MAXCOUNT = 100;
	private ArrayList<Book> books = new ArrayList<Book>();//Book arrayList 선언
	private int bookCount = 0;//bookCount=0으로 시작

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

	public Book selectBook(String title) {//책 제목을 받으면 같은 제목 돌려주기

		for (Book book : books) {
			if (title.equals(book.getTitle()))
				return book;
		}

		return null;
	}

	public int selectedBookIndex(String title) {//제목을 입력한 책의 인덱스 반환
		for (int i = 0; i < books.size(); i++) {

			if (title.equals(books.get(i).getTitle()))
				return i;
		}

		return -1;//동일한 책이 없는 경우 -1반환

	}

	public void addBook(Book book) {//책 증가하는 함수
		books.add(book);
		bookCount++; // 책장의 책 증가
	}

	public int deleteBook(String title) {//책 삭제
		if (bookCount == 0)
			return 0;

		int selectedIndex = selectedBookIndex(title);
		if (selectedIndex == -1)
			return -1;

		books.remove(selectedIndex);//책 삭제
		bookCount--;

		return 1;
	}

	public void clearBookShelf() {//책장 정리

		books.clear();

		bookCount = 0;//clear로 됐으므로 책 수는 0
	}
}
