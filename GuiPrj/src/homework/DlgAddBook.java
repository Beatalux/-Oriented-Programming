package homework;
//1876187 서유빈

import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.DateTime;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class DlgAddBook extends TitleAreaDialog {
	private Text txtTitle;
	private Text txtPublisher;
	private Text txtAuthor;
	private Text txtCareer;
	private Combo cboBookType;
	private Button rbtnWoman;
	private Button rbtnMan;
	private DateTime dtBirthday;
	
	public String title;
	public String publisher;
	public String bookType;
	public String authorName;
	public String career;
	public String birthDate;
	public Gender gender;
	
	

	/**
	 * Create the dialog.
	 * @param parentShell
	 */
	public DlgAddBook(Shell parentShell) {
		super(parentShell);
	}

	/**
	 * Create contents of the dialog.
	 * @param parent
	 */
	@Override
	protected Control createDialogArea(Composite parent) {//배치할 컴포넌트들 성정
		setMessage("\uCC45 \uC815\uBCF4\uC640 \uC800\uC790 \uC815\uBCF4\uB97C \uC785\uB825\uD558\uC138\uC694");
		setTitle("\uCC45 \uCD94\uAC00");
		Composite area = (Composite) super.createDialogArea(parent);
		Composite container = new Composite(area, SWT.NONE);
		container.setLayoutData(new GridData(GridData.FILL_BOTH));
		
		Label label = new Label(container, SWT.NONE);//책제목
		label.setBounds(10, 10, 56, 34);
		label.setText("\uCC45 \uC81C\uBAA9");
		
		Label lblNewLabel_1 = new Label(container, SWT.NONE);//출판사
		lblNewLabel_1.setBounds(10, 50, 56, 28);
		lblNewLabel_1.setText("\uCD9C\uD310\uC0AC");
		
		Label lblNewLabel_2 = new Label(container, SWT.NONE);//종류
		lblNewLabel_2.setBounds(10, 95, 56, 33);
		lblNewLabel_2.setText("\uC885\uB958");
		
		cboBookType = new Combo(container, SWT.NONE);//책 종류 입력
		cboBookType.setItems(new String[] {"\uC18C\uC124", "\uC790\uAE30\uACC4\uBC1C", "\uC2DC"});
		cboBookType.setBounds(107, 92, 281, 23);
		cboBookType.select(0);
		
		Label lblNewLabel_4 = new Label(container, SWT.NONE);//저자
		lblNewLabel_4.setBounds(10, 142, 56, 34);
		lblNewLabel_4.setText("\uC800\uC790");
		
		Label lblNewLabel_5 = new Label(container, SWT.NONE);//생년월일
		lblNewLabel_5.setBounds(10, 182, 93, 31);
		lblNewLabel_5.setText("\uC0DD\uB144\uC6D4\uC77C");
		
		Label lblNewLabel_6 = new Label(container, SWT.NONE);//경력
		lblNewLabel_6.setBounds(10, 219, 56, 40);
		lblNewLabel_6.setText("\uACBD\uB825");
		
		Label lblNewLabel_7 = new Label(container, SWT.NONE);//성별
		lblNewLabel_7.setBounds(10, 265, 56, 32);
		lblNewLabel_7.setText("\uC131\uBCC4");
		
		//이하 dlgDetailIfo 와 동일
		txtAuthor = new Text(container, SWT.BORDER);
		txtAuthor.setBounds(107, 142, 283, 34);
		
		dtBirthday = new DateTime(container, SWT.BORDER);
		dtBirthday.setBounds(109, 182, 281, 24);
		
		rbtnWoman = new Button(container, SWT.RADIO);
		rbtnWoman.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		rbtnWoman.setBounds(107, 269, 91, 28);
		rbtnWoman.setText("\uB0A8\uC790");
		
		rbtnMan = new Button(container, SWT.RADIO);
		rbtnMan.setBounds(252, 269, 91, 29);
		rbtnMan.setText("\uC5EC\uC790");
		

		
		txtCareer = new Text(container, SWT.BORDER);
		txtCareer.setBounds(107, 219, 281, 28);
		
		txtTitle = new Text(container, SWT.BORDER);
		txtTitle.setBounds(107, 7, 281, 37);
		
		txtPublisher = new Text(container, SWT.BORDER);
		txtPublisher.setBounds(109, 50, 281, 35);		
		

		return area;
	}

	/**
	 * Create contents of the button bar.
	 * @param parent
	 */
	@Override
	protected void createButtonsForButtonBar(Composite parent) {
		createButton(parent, IDialogConstants.OK_ID, IDialogConstants.OK_LABEL, true);
		createButton(parent, IDialogConstants.CANCEL_ID, IDialogConstants.CANCEL_LABEL, false);
	}

	
	@Override
	protected void okPressed() {
		title=txtTitle.getText();
		publisher=txtPublisher.getText();
		bookType=cboBookType.getText();
		authorName=txtAuthor.getText();
		career=txtCareer.getText();
		birthDate=String.format("%4d-%2d-%2d", dtBirthday.getYear(),dtBirthday.getMonth(),dtBirthday.getDay());
		if(rbtnMan.getSelection()==true)gender =Gender.MAN;
		else gender=Gender.WOMAN;
		
		super.okPressed();
	}

	/**
	 * Return the initial size of the dialog.
	 */
	@Override
	protected Point getInitialSize() {
		return new Point(450, 568);
	}
}
