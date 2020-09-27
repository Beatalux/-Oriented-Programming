package homework;

//1876187 ������
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
	// ���� ����
	protected Shell shell;
	private static BookShelf bookShelf = new BookShelf();
	private List bookList;
	private Label lblBookCount;
	private final FormToolkit formToolkit = new FormToolkit(Display.getDefault());

	private static final String FileOutputStrean = null;// ���� �а� ���� ����

	/**
	 * Launch the application.
	 * 
	 * @param args
	 */
	public static void main(String[] args) throws IOException, ClassNotFoundException {// START of Main, ���� ó��

		try {
			readBooks();// ���Ͽ��� å �о����
		} catch (ClassNotFoundException | IOException e) {// ����ó��
			System.out.println(e.getMessage());
			return;
		}

		try {
			GUIBookMgt window = new GUIBookMgt();// gui �����ֱ�
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			writeBooks();// ���Ͽ� ���� �־��ֱ�
		} catch (IOException e) {
			System.out.println(e.getMessage());
			return;
		}

	}

	// end of Main

	@SuppressWarnings("unchecked")
	public static void readBooks() throws IOException, ClassNotFoundException {// ���Ͽ��� å �о����
		File bf = new File("myBookShelf.dat");
		if (!bf.exists())// ���� ���� �ʴ� ���
			return;

		// ������ ������ ���Ͽ� �ִ� å ���� �о�� ArrayList �� ����
		FileInputStream f = new FileInputStream("myBookShelf.dat");
		ObjectInputStream fin = new ObjectInputStream(f);

		bookShelf.setBooks((ArrayList<Book>) fin.readObject());

		fin.close();
	}

	@SuppressWarnings("static-access")
	public static void writeBooks() throws IOException {// ���Ͽ� ����
		FileOutputStream f1 = new FileOutputStream("myBookShelf.dat");
		ObjectOutputStream fout = new ObjectOutputStream(f1);

		fout.writeObject(bookShelf.getBookArray());
		fout.close();// ���� �ݾ��ֱ�
	}

	public void insertBookInfo(Shell shell) {// ����Ʈ�� å ����
		DlgAddBook dlg = new DlgAddBook(shell);// ���� �� ���̾�α�
		if (dlg.open() != Dialog.OK) {// ���̾�α� �� ���� ���
			return;
		}
		// DlgAddBook �� ���� ������ ����
		String title = dlg.title;
		String publisher = dlg.publisher;
		String type = dlg.bookType;

		String name = dlg.authorName;
		String birthdate = dlg.birthDate;
		String career = dlg.career;
		Gender gender = dlg.gender;
		// ��ü
		Author author = new Author(name, birthdate, gender, career);
		Book book = new Book(title, publisher, type, author);

		bookShelf.addBook(book);
		showAllBookInfo();// ������ �ٷ� ����Ʈ�� ���� �� �ֵ���
	}

	public void showAllBookInfo() {// å ��� �����ִ� �޼���
		String[] bookInfos = bookShelf.getBooks();

		lblBookCount.setText(Integer.toString(bookShelf.getBookCount()) + "��");//�� �� �����ֱ�
		bookList.removeAll();
		for (String s : bookInfos) {
			bookList.add(s);
		}
	}

	public void updateBookInfo(Shell shell) {//å ���� ������Ʈ
		int index = bookList.getSelectionIndex();// list�����Լ�
		if (index == -1) {//�ƹ� å�� �������� ���� ���
			JOptionPane.showMessageDialog(null, "å��Ͽ��� ������ �� å ����", "�޽���", JOptionPane.ERROR_MESSAGE);
			return;
		}
		Book selectedBook = bookShelf.selectBook(index);//

		DlgDetailInfo dlg = new DlgDetailInfo(shell);
		// DlgDetailInfo �� ���� ������ ����
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
		selectedBook.update(dlg.title, dlg.publisher);//�ٲ� ���� ������Ʈ
		showAllBookInfo();//�ٲ� ��� �����ֱ�
	}

	public void selectBookInfo(Shell shell, String title) {//å ���� for search

		Book selectedBook = bookShelf.selectBook(title);
		if (selectedBook == null) {//���õ� å�� ��Ͽ� ���� ���
			return;
		}
		DlgDetailInfo dlg = new DlgDetailInfo(shell);
		//DlgDetailInfo�� �־��� ���� ����
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
		selectedBook.update(dlg.title, dlg.publisher);//���� �ٽ� �Է����� ��� UPDATE
		showAllBookInfo();
	}

	public void removeBookFromBookShelf(String name) {//å ���� �޼���
		Book selectedBook = bookShelf.selectBook(name);
		if (selectedBook == null)//������ å�� ��Ͽ� ���� ���
			return;
		int msg = bookShelf.deleteBook(name);
		showAllBookInfo();
	}

	/**
	 * Open the window.
	 */
	public void open() {//WINDOW ���� �޼���
		Display display = Display.getDefault();
		createContents();//� �����͵��� ��ġ�Ǿ� ���� ���ΰ�?
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
	protected void createContents() {//��ġ�� ������Ʈ�� ����
		shell = new Shell();
		shell.setSize(816, 451);
		shell.setText("SWT Application");
		shell.setLayout(null);

		Label lblNewLabel = new Label(shell, SWT.NONE);//���� �����ϰ� �ִ� å ���
		lblNewLabel.setBounds(22, 20, 231, 32);
		lblNewLabel.setText("\uB0B4\uAC00 \uC18C\uC7A5\uD558\uACE0 \uC788\uB294 \uCC45 \uBAA9\uB85D");

		lblBookCount = new Label(shell, SWT.NONE);//��
		lblBookCount.setBounds(332, 10, 87, 32);

		Button btnAddBook = new Button(shell, SWT.NONE);//AddBook ��ư
		btnAddBook.setBounds(10, 343, 87, 25);
		btnAddBook.addSelectionListener(new SelectionAdapter() {//Ŭ���� insertBookInfo ȣ��
			@Override
			public void widgetSelected(SelectionEvent e) {
				insertBookInfo(shell);

			}
		});

		btnAddBook.setText("Add Book");

		Button btnGetAllBooks = new Button(shell, SWT.NONE);//GetAll Books ��ư
		btnGetAllBooks.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {//Ŭ���� ��� å ������
				showAllBookInfo();
			}
		});
		btnGetAllBooks.setBounds(103, 343, 138, 25);
		btnGetAllBooks.setText("Get All Books");

		Button btnBookDetailInfo = new Button(shell, SWT.NONE);//Book Detail Info ��ư
		btnBookDetailInfo.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {//��ư Ŭ���� updateBokkInfo ȣ��
				updateBookInfo(shell);
			}
		});
		btnBookDetailInfo.setBounds(247, 343, 201, 25);
		btnBookDetailInfo.setText("Book Detail Info");

		Button btnSearch = formToolkit.createButton(shell, "Search", SWT.NONE);//search��ư
		btnSearch.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {//��ư Ŭ���� å ���� �Է� �޾� selectBookInfoȣ��
				String name = JOptionPane.showInputDialog("å ���� �Է�");//å�����Է� �޴� ���̾�α� ����
				selectBookInfo(shell, name);
			}
		});
		btnSearch.setBounds(454, 343, 109, 25);

		Button btnDelete = formToolkit.createButton(shell, "Delete", SWT.NONE);//delete��ư
		btnDelete.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {//��ư Ŭ���� å ���� �Է� �޾� removeBookFromBookShelfȣ��
				String name = JOptionPane.showInputDialog("å ���� �Է�");
				removeBookFromBookShelf(name);
			}
		});
		btnDelete.setBounds(569, 343, 109, 25);

		Button btnClose = new Button(shell, SWT.NONE);//close��ư
		btnClose.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {//��ư Ŭ�� �� â �ݱ�
				shell.close();
			}
		});
		btnClose.setBounds(684, 343, 86, 25);
		formToolkit.adapt(btnClose, true, true);
		btnClose.setText("Close");

		bookList = new List(shell, SWT.BORDER);
		bookList.setBounds(0, 55, 774, 268);

		showAllBookInfo();//���� ó�� ȭ�鿡���� ������ �־�� å ��Ϻ��̵���

	}
}
