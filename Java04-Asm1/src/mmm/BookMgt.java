package mmm;
//1876187 서유빈
//에플리케이션 진입 메소드 main을 갖는 클래스

import java.util.Scanner;
import mmm.Person.Gender;


public class BookMgt {
	public static void main(String args[]) {// 메인클래스 시작
		Scanner s = new Scanner(System.in);
		BookShelf bookShelf = new BookShelf();// 책장 bookShelf 객체 생성

		do {// start of do-while
			System.out.println("========================================");
			System.out.println("1: 책 추가, 2: 모든 책 검색, 3: 책 검색, 4: 책 수정, 5: 책 삭제, 6: 모든 책 삭제, 7: 종료");
			System.out.println("========================================");
			System.out.print("메뉴를 선택하세요 >>>");
			int n = s.nextInt();// 메뉴 입력받기
			Book b;// 책 선언
			Author a;// 작가 선언

			switch (n) {// switch문 시작: 책 추가, 책 검색, 수정, 삭제, 모든 책 검색, 삭제, 종료 기능
			case 1:// 1-책 추가

				b = new Book();// 책 객체 생성
				a = new Author();// 작가 객체 생성

				System.out.println("\n책의 정보를 입력하세요.(제목, 출판사, 책종류 순으로 입력)");
				String title = s.next();// 제목 입력 받기
				String where = s.next();// 발행처 입력 받기
				String type = s.next();// 타입 입력 받기

				System.out.println("저자 정보를 입력하세요.(이름, 생년월일(yyyy-mm-dd), 성별(남:1, 여:2), 경력 순으로 입력)");
				String name = s.next();// 저자 이름 입력받기
				String birth = s.next();// 생년월일 입력받기

				int gender = s.nextInt();// 성별 입력 받기
				String exp = s.next();// 경력 입력받기

				if (gender == 1)// 성별 1을 입력했을 경우 남자
					a = new Author(name, birth, Gender.MAN, exp);
				else if (gender == 2)// 성별 2를 입력했을 경우 여자
					a = new Author(name, birth, Gender.WOMAN, exp);
				else// 그 외 입력했을시 성별 unknown
					a = new Author(name, birth, Gender.UNKNOWN, exp);
				b = new Book(title, where, type, a);// 입력 받은 정보를 넣은 최종 책 객체 생성
				bookShelf.addBook(b);// 책장에 책 넣기
				break;// case 1 종료

			case 2:// 2-모든 책 검색
				System.out.println("\n[총 " + bookShelf.getNowbook() + "권]");
				bookShelf.getBooks();// bookShelf의 getBooks 메소드 호출
				break;// case 2 종료

			case 3:// case 3- 책 검색
				System.out.println("검색할 책의 제목을 입력하세요.");
				b=bookShelf.selectBook(s.next());// bookShelf의 selectBook의 메소드 호출
				break;// case 3 종료

			case 4:// case 4- 책 수정
				System.out.println("수정할 책의 제목을 입력하세요.");
				String fixedtitle = s.next();// 수정하고 싶은 책 제목 입력
				b = bookShelf.selectBook(fixedtitle);// 그 책 정보 출력
				if(b==null)
					break;

				System.out.println("새로운 제목을 입력하세요.");
				String fixingtitle = s.next();// 새로 수정할 책 제목 임력
				b.update(fixingtitle);// 제목 수정하여 책 정보 update
				System.out.println("출판사를 수정하시겠습니까?(y or n)");
				if (s.next().equals("n")) {// n 입력시 case 4 종료
					b.print();
					break;
				} else {// y 입력시 출판사 명 변경
					System.out.println("\n새로운 출판사를 입력하세요.");
					b.update(fixingtitle, s.next());// 제목, 출판사 수정하여 책 정보 update
					b.print();// 바뀐 정보 프린트
					break;
				}

			case 5:// case 5- 책 삭제
				System.out.println("삭제할  책의 제목을 입력하세요.");
				String rvtitle = s.next();// 삭제할 책 제목 임력
				b = bookShelf.selectBook(rvtitle);// 삭제할 책 정보 출력
				if(b==null)
					break;
				System.out.println("정말 책을 삭제하시겠습니까?(y or n)");
				if (s.next().equals("y"))// 정말 삭제할 경우 그 책 삭제
					bookShelf.deleteBook(rvtitle);
				break;// case 5 종료

			case 6:// case 6- 모든 책 삭제
				System.out.println("정말 모든 책을 삭제하시겠습니까?(y or n)");
				if (s.next().equals("y"))// y 선택 시 모든 책 삭제
					bookShelf.clearBookShelf();
				break;// case 6 종료
			case 7:// case 7- 7선택 시 종료
				System.out.println("\n\n***프로그램을 종료합니다***");
				break;// case 7 끝
			}

			if (n == 7)
				break;// 위 switch 문에서 7선택시 while문 종료
		} while (bookShelf.getMAXCOUNT() > bookShelf.getNowbook());// 책의 수가 Maxcount 넘지 않는 선에서 계속 선택 가능

		s.close();// 스캐너 닫기

	}

}
