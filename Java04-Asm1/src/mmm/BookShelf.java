package mmm;
//1876187 서유빈
public class BookShelf {
	private int MAXCOUNT = 100;//상수 100으로 초기화
	private Book book[] = new Book[MAXCOUNT];// 책장에 MAXCOUNT의 책을 보관할 수 있음
	private int nowbook = 0;// 현재 보관된 책의 수

	public BookShelf() {//생성자. 우선 책장 객체 생성용
	};

	public BookShelf(int MAXCOUNT, Book[] book, int nowbook) {//생성자 
		super();
		this.book = book;
		this.nowbook = nowbook;
	}

	public int getMAXCOUNT() {//MAXCOUNT getter
		return MAXCOUNT;
	}

	public Book[] getBook() {//Book[] getter
		return book;
	}

	public int getNowbook() {//보관된 책의 수 반환
		return this.nowbook;
	}

	public void getBooks() {//책장에 채워진 책들의 정보를 출력
		for (int i = 0; i < nowbook; i++) {
			book[i].print();//정보 print
			System.out.println();
		}

	}

	public Book selectBook(String title) {//제목에 해당하는 책을 찾아 출력
		int i;
		for (i = 0; i < nowbook; i++) {//start of for
			if (title.equals(book[i].getTitle())) {//입력값과 책 제목 비교
				book[i].printDetail();
				return book[i];
			} 
				continue;//못 찾은 경우 탐색 계속 진행
		}//end of for
		if(i==nowbook)//책 찾지 못했을 경우 메시지 출력
			System.out.println("찾지 못했습니다");
		return null;
				
	}

	public void addBook(Book newbook) {// 책장에 책 추가
		book[nowbook++] = newbook;
	}

	public void deleteBook(String title) {//제목에 해당하는 책 삭제
		for (int i = 0; i < this.nowbook; i++) {
			if (title.equals(book[i].getTitle())) {
				book[i] = null;
				System.out.println("삭제하였습니다");
				this.nowbook--;//전체 책 개수 1 감소
					for(;i<this.nowbook;i++)
					book[i]=book[i+1];//배열이므로 한칸씩 앞으로 당겨주기
					
				}
			
				
			}
		}

	public void clearBookShelf() {//책장에 모든 책 삭제
		for (int i = 0; i < this.nowbook; i++) {//for문 돌리면서 모든 책 null로 만들기
			book[i] = null;
			this.nowbook = 0;//남은 책 수는 0
		}

	}
}
