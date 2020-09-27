package mmm;
//1876187 ������
public class BookShelf {
	private int MAXCOUNT = 100;//��� 100���� �ʱ�ȭ
	private Book book[] = new Book[MAXCOUNT];// å�忡 MAXCOUNT�� å�� ������ �� ����
	private int nowbook = 0;// ���� ������ å�� ��

	public BookShelf() {//������. �켱 å�� ��ü ������
	};

	public BookShelf(int MAXCOUNT, Book[] book, int nowbook) {//������ 
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

	public int getNowbook() {//������ å�� �� ��ȯ
		return this.nowbook;
	}

	public void getBooks() {//å�忡 ä���� å���� ������ ���
		for (int i = 0; i < nowbook; i++) {
			book[i].print();//���� print
			System.out.println();
		}

	}

	public Book selectBook(String title) {//���� �ش��ϴ� å�� ã�� ���
		int i;
		for (i = 0; i < nowbook; i++) {//start of for
			if (title.equals(book[i].getTitle())) {//�Է°��� å ���� ��
				book[i].printDetail();
				return book[i];
			} 
				continue;//�� ã�� ��� Ž�� ��� ����
		}//end of for
		if(i==nowbook)//å ã�� ������ ��� �޽��� ���
			System.out.println("ã�� ���߽��ϴ�");
		return null;
				
	}

	public void addBook(Book newbook) {// å�忡 å �߰�
		book[nowbook++] = newbook;
	}

	public void deleteBook(String title) {//���� �ش��ϴ� å ����
		for (int i = 0; i < this.nowbook; i++) {
			if (title.equals(book[i].getTitle())) {
				book[i] = null;
				System.out.println("�����Ͽ����ϴ�");
				this.nowbook--;//��ü å ���� 1 ����
					for(;i<this.nowbook;i++)
					book[i]=book[i+1];//�迭�̹Ƿ� ��ĭ�� ������ ����ֱ�
					
				}
			
				
			}
		}

	public void clearBookShelf() {//å�忡 ��� å ����
		for (int i = 0; i < this.nowbook; i++) {//for�� �����鼭 ��� å null�� �����
			book[i] = null;
			this.nowbook = 0;//���� å ���� 0
		}

	}
}
