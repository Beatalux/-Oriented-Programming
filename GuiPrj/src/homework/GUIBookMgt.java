package homework;

//1876187 서유빈
//HW3

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.swt.SWT;

import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.List;
import org.eclipse.ui.forms.widgets.FormToolkit;

public class GUIBookMgt {
	// 변수 선언
	protected Shell shell;
	private static BookShelf bookShelf = new BookShelf();
	private List bookList;
	private Label lblBookCount;
	private final FormToolkit formToolkit = new FormToolkit(Display.getDefault());

	private static final String FileOutputStrean = null;// 파일 읽고 쓰기 위해

	/**
	 * Launch the application.
	 * 
	 * @param args
	 */
	public static void main(String[] args) throws IOException, ClassNotFoundException {// START of Main, 예외 처리

		try {
			readBooks();// 파일에서 책 읽어오기
		} catch (ClassNotFoundException | IOException e) {// 예외처리
			System.out.println(e.getMessage());
			return;
		}

		try {
			GUIBookMgt window = new GUIBookMgt();// gui 열어주기
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			writeBooks();// 파일에 정보 넣어주기
		} catch (IOException e) {
			System.out.println(e.getMessage());
			return;
		}

	}

	// end of Main

	@SuppressWarnings("unchecked")
	public static void readBooks() throws IOException, ClassNotFoundException {// 파일에서 책 읽어오기
		File bf = new File("myBookShelf.dat");
		if (!bf.exists())// 파일 존재 않는 경우
			return;

		// 파일이 있으면 파일에 있는 책 정보 읽어와 ArrayList 에 담음
		FileInputStream f = new FileInputStream("myBookShelf.dat");
		ObjectInputStream fin = new ObjectInputStream(f);

		bookShelf.setBooks((ArrayList<Book>) fin.readObject());

		fin.close();
	}

	@SuppressWarnings("static-access")
	public static void writeBooks() throws IOException {// 파일에 쓰기
		FileOutputStream f1 = new FileOutputStream("myBookShelf.dat");
		ObjectOutputStream fout = new ObjectOutputStream(f1);

		fout.writeObject(bookShelf.getBookArray());
		fout.close();// 파일 닫아주기
	}

	public void insertBookInfo(Shell shell) {// 리스트에 책 삽입
		DlgAddBook dlg = new DlgAddBook(shell);// 열어 줄 다이얼로그
		if (dlg.open() != Dialog.OK) {// 다이얼로그 안 열릴 경우
			return;
		}
		// DlgAddBook 에 넣을 정보들 선언
		String title = dlg.title;
		String publisher = dlg.publisher;
		String type = dlg.bookType;

		String name = dlg.authorName;
		String birthdate = dlg.birthDate;
		String career = dlg.career;
		Gender gender = dlg.gender;
		// 객체
		Author author = new Author(name, birthdate, gender, career);
		Book book = new Book(title, publisher, type, author);

		bookShelf.addBook(book);
		showAllBookInfo();// 넣으면 바로 리스트에 보일 수 있도록
	}

	public void showAllBookInfo() {// 책 목록 보여주는 메서드
		String[] bookInfos = bookShelf.getBooks();

		lblBookCount.setText(Integer.toString(bookShelf.getBookCount()) + "권");//권 수 보여주기
		bookList.removeAll();
		for (String s : bookInfos) {
			bookList.add(s);
		}
	}

	public void updateBookInfo(Shell shell) {//책 정보 업데이트
		int index = bookList.getSelectionIndex();// list제공함수
		if (index == -1) {//아무 책도 선택하지 않은 경우
			JOptionPane.showMessageDialog(null, "책목록에서 상세정보 볼 책 선택", "메시지", JOptionPane.ERROR_MESSAGE);
			return;
		}
		Book selectedBook = bookShelf.selectBook(index);//

		DlgDetailInfo dlg = new DlgDetailInfo(shell);
		// DlgDetailInfo 에 넣을 정보들 선언
		dlg.title = selectedBook.getTitle();
		dlg.publisher = selectedBook.getPublisher();
		dlg.bookType = selectedBook.getType();
		dlg.authorName = selectedBook.getAuthor().getName();
		dlg.birthDate = selectedBook.getAuthor().getBirthdate();
		dlg.gender = selectedBook.getAuthor().getGender();
		dlg.career = selectedBook.getAuthor().getCareer();

		if (dlg.open() != Dialog.OK) {
			return;
		}
		selectedBook.update(dlg.title, dlg.publisher);//바뀐 정보 업데이트
		showAllBookInfo();//바뀐 즉시 보여주기
	}

	public void selectBookInfo(Shell shell, String title) {//책 선택 for search

		Book selectedBook = bookShelf.selectBook(title);
		if (selectedBook == null) {//선택된 책이 목록에 없을 경우
			return;
		}
		DlgDetailInfo dlg = new DlgDetailInfo(shell);
		//DlgDetailInfo에 넣어줄 정보 선택
		dlg.title = selectedBook.getTitle();
		dlg.publisher = selectedBook.getPublisher();
		dlg.bookType = selectedBook.getType();
		dlg.authorName = selectedBook.getAuthor().getName();
		dlg.birthDate = selectedBook.getAuthor().getBirthdate();
		dlg.gender = selectedBook.getAuthor().getGender();
		dlg.career = selectedBook.getAuthor().getCareer();

		if (dlg.open() != Dialog.OK) {
			return;
		}
		selectedBook.update(dlg.title, dlg.publisher);//정보 다시 입력했을 경우 UPDATE
		showAllBookInfo();
	}

	public void removeBookFromBookShelf(String name) {//책 삭제 메서드
		Book selectedBook = bookShelf.selectBook(name);
		if (selectedBook == null)//선택한 책이 목록에 없을 경우
			return;
		int msg = bookShelf.deleteBook(name);
		showAllBookInfo();
	}

	/**
	 * Open the window.
	 */
	public void open() {//WINDOW 여는 메서드
		Display display = Display.getDefault();
		createContents();//어떤 컴포넌들이 배치되어 있을 것인가?
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {//배치할 컴포넌트들 설정
		shell = new Shell();
		shell.setSize(816, 451);
		shell.setText("SWT Application");
		shell.setLayout(null);

		Label lblNewLabel = new Label(shell, SWT.NONE);//내가 소장하고 있는 책 목록
		lblNewLabel.setBounds(22, 20, 231, 32);
		lblNewLabel.setText("\uB0B4\uAC00 \uC18C\uC7A5\uD558\uACE0 \uC788\uB294 \uCC45 \uBAA9\uB85D");

		lblBookCount = new Label(shell, SWT.NONE);//권
		lblBookCount.setBounds(332, 10, 87, 32);

		Button btnAddBook = new Button(shell, SWT.NONE);//AddBook 버튼
		btnAddBook.setBounds(10, 343, 87, 25);
		btnAddBook.addSelectionListener(new SelectionAdapter() {//클릭시 insertBookInfo 호출
			@Override
			public void widgetSelected(SelectionEvent e) {
				insertBookInfo(shell);

			}
		});

		btnAddBook.setText("Add Book");

		Button btnGetAllBooks = new Button(shell, SWT.NONE);//GetAll Books 버튼
		btnGetAllBooks.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {//클릭시 모든 책 보여줌
				showAllBookInfo();
			}
		});
		btnGetAllBooks.setBounds(103, 343, 138, 25);
		btnGetAllBooks.setText("Get All Books");

		Button btnBookDetailInfo = new Button(shell, SWT.NONE);//Book Detail Info 버튼
		btnBookDetailInfo.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {//버튼 클릭시 updateBokkInfo 호출
				updateBookInfo(shell);
			}
		});
		btnBookDetailInfo.setBounds(247, 343, 201, 25);
		btnBookDetailInfo.setText("Book Detail Info");

		Button btnSearch = formToolkit.createButton(shell, "Search", SWT.NONE);//search버튼
		btnSearch.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {//버튼 클릭시 책 제목 입력 받아 selectBookInfo호출
				String name = JOptionPane.showInputDialog("책 제목 입력");//책제목입력 받는 다이얼로그 띄우기
				selectBookInfo(shell, name);
			}
		});
		btnSearch.setBounds(454, 343, 109, 25);

		Button btnDelete = formToolkit.createButton(shell, "Delete", SWT.NONE);//delete버튼
		btnDelete.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {//버튼 클릭시 책 제목 입력 받아 removeBookFromBookShelf호출
				String name = JOptionPane.showInputDialog("책 제목 입력");
				removeBookFromBookShelf(name);
			}
		});
		btnDelete.setBounds(569, 343, 109, 25);

		Button btnClose = new Button(shell, SWT.NONE);//close버튼
		btnClose.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {//버튼 클릭 시 창 닫기
				shell.close();
			}
		});
		btnClose.setBounds(684, 343, 86, 25);
		formToolkit.adapt(btnClose, true, true);
		btnClose.setText("Close");

		bookList = new List(shell, SWT.BORDER);
		bookList.setBounds(0, 55, 774, 268);

		showAllBookInfo();//제일 처음 화면에서도 기존에 넣어둔 책 목록보이도록

	}
}
