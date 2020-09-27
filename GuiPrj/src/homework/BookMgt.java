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
	private static BookShelf bookShelf=new BookShelf();//bookShelf 객체 생성
	
	public static void main(String[] args) throws IOException, ClassNotFoundException {//IOException, ClassNotFoundException 예외처리

		try {
			readBooks();//파일에서 책 읽어오기
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
				
				else if(menu<1||menu>7) {//범위 밖의 숫자를 입력할 경우
					System.out.println("범위 내의 숫자를 입력하세요");
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
				
			}catch (NumberFormatException e) {//NumberFormatException 예외 처리
				System.out.println("숫자입력!");
			}catch(ClassNotFoundException e)//ClassNotFoundException 예외 처리
			{System.out.println(e.getMessage());
			}catch(IOException e)//IOException 예외 처리
			{System.out.println(e.getMessage());
			}
			catch(Exception e)//Exception 예외 처리
			{System.out.println(e.getMessage());
			continue;
			}
			System.out.println();
		}

		System.out.println("프로그램을 종료합니다.");
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
	public static void readBooks() throws IOException, ClassNotFoundException {//파일에서 책 읽어오기
		File bf = new File("myBookShelf.dat");
		if (!bf.exists())
			return;

		// 파일이 있으면 파일에 있는 책 정보 읽어와 ArrayList 에 담음
		FileInputStream f = new FileInputStream("myBookShelf.dat");
		ObjectInputStream fin = new ObjectInputStream(f);

		bookShelf.setBooks((ArrayList<Book>) fin.readObject());

		fin.close();
	}

	@SuppressWarnings("static-access")
	public static void writeBooks() throws IOException {//파일에 쓰기
		FileOutputStream f1 = new FileOutputStream("myBookShelf.dat");
		ObjectOutputStream fout = new ObjectOutputStream(f1);

		fout.writeObject(bookShelf.getBookArray());
		fout.close();//파일 닫아주기
	}

	public static int showMenu() throws NumberFormatException{//메뉴 보여주기
		System.out.println("========================================================");
		System.out.println("1.책 추가 2.모든 책 검색 3.책 검색 4.책 수정 5.책 삭제 6.모든 책 삭제 7.종료");
		System.out.println("========================================================");
		int menu = -1;

		System.out.print("메뉴를 선택하세요 >> ");

		menu = Integer.parseInt(scan.nextLine());//메뉴 입력받기

		System.out.println();
		return menu;

	}

	public static void insertBookInfo() throws IOException {// 1번-책 추가

		// 책 정보 입력
		System.out.println("책의 정보를 입력하세요.(제목, 출판사, 책종류 순으로 입력)");
		System.out.print("제목 >> ");
		String title = scan.nextLine();
		System.out.print("출판사 >> ");
		String publisher = scan.nextLine();
		System.out.print("책종류 >> ");
		String type = scan.nextLine();

		System.out.println();
		System.out.println("저자 정보를 입력하세요.(이름, 생년월일, 성별(남:1, 여:2), 경력 순으로 입력)");
		System.out.print("이름 >> ");
		String name = scan.nextLine();
		System.out.print("생년월일 >> ");
		String birthdate = scan.nextLine();
		System.out.print("성별 >> ");
		int g = Integer.parseInt(scan.nextLine());
		System.out.print("경력 >> ");
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
		System.out.println("책을 저장했습니다");

	}// end of choice 1

	public static void showAllBookInfo() throws IOException, ClassNotFoundException { // 2번-파일에서 읽어오기

		String[] bookInfos = bookShelf.getBooks();

		String deco = new String(new char[60]).replace("\0", "=");
		System.out.println(deco);
		System.out.println(String.format("총 %d권의 책이 있습니다.", bookShelf.getBookCount()));
		System.out.println(deco);

		for (String s : bookInfos) {//모든 책 정보 입력
			System.out.println(s);
		}

	}

	public static void selectBookInfo() throws IOException, ClassNotFoundException {// 3번 책 검색

		System.out.print("검색할 책의 제목을 입력하세요 >> ");
		String title = scan.nextLine();

		Book selectedBook = bookShelf.selectBook(title);
		if (selectedBook == null) {//검색된 책이 없는 경우
			System.out.println("검색된 책이 없습니다.");
			return;
		}

		System.out.println(selectedBook.printDetail());//검색된 책이 있는 경우는 정보 print

	}// end of-choice 3

	public static void updateBookInfo() {// 4번 : 책 수정
		System.out.print("수정할 책의 제목을 입력하세요 >> ");
		String title = scan.nextLine();
	

		Book selectedBook = bookShelf.selectBook(title);
		if (selectedBook == null) {//없는 책 제목을 입력한 경우
			System.out.println("수정할 책이 없습니다.");
			return;
		}

		System.out.print("새 제목을 입력하세요 >> ");//수정할 책 제목 입력
		String newtitle = scan.nextLine();

		System.out.print("출판사도 수정하시겠습니까?(y or n) >> ");
		String confirm = scan.nextLine().toLowerCase();

		if (confirm.equals("y")) {//y 입력시 출판사도 수정
			System.out.print("새 출판사를 입력하세요 >> ");
			String newpublisher = scan.nextLine();

			selectedBook.update(newtitle, newpublisher);//책 제목, 출판사 수정
		} else {
			selectedBook.update(newtitle);//책 제목 수정
		}

		System.out.println("수정이 완료되었습니다.");

	}

	public static void removeBookFromBookShelf() {// 5번 : 책 삭제
		System.out.print("삭제할 책의 제목을 입력하세요 >> ");
		String title = scan.nextLine();

		Book selectedBook = bookShelf.selectBook(title);
		if (selectedBook == null) {
			System.out.println("삭제할 책이 없습니다.");
			return;
		}

		System.out.println(selectedBook.printDetail());
		System.out.print("책을 정말 삭제하세겠습니까?(y or n) >> ");//y를 누른 경우 확실히 삭제
		String confirm = scan.nextLine().toLowerCase();

		if (confirm.equals("n"))//n을 누른 경우 다시 메뉴를 보여준다
			return;

		int msg = bookShelf.deleteBook(title);
		if (msg == 1) {
			System.out.println("책을 삭제하였습니다.");
		}

	}// end of choice 5

	public static void clearBookShelf() {// 6번 전체삭제
		System.out.print("책을 모두 삭제하세겠습니까?(y or n) >> ");
		String confirm = scan.nextLine().toLowerCase();

		if(confirm.equals("y")){//y를 누른 경우 확실히 삭제
			bookShelf.clearBookShelf();
			System.out.println("책을 모두 삭제하였습니다.");
		}
	}//end of choice 6
}
