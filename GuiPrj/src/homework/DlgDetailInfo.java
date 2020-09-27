package homework;

import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.DateTime;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public class DlgDetailInfo extends TitleAreaDialog {

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
		public DlgDetailInfo(Shell parentShell) {
			super(parentShell);
		}

		/**
		 * Create contents of the dialog.
		 * @param parent
		 */
		@Override
		protected Control createDialogArea(Composite parent) {//다이얼로그에 배치될 컴포넌트들
			setMessage("\uCC45\uC758 \uC0C1\uC138\uC815\uBCF4\uC785\uB2C8\uB2E4\r\n\uC81C\uBAA9\uACFC \uCD9C\uD310\uC0AC\uB97C \uC218\uC815\uD558\uB824\uBA74 \uC0C8\uB85C\uC6B4 \uC815\uBCF4\uB97C\uC785\uB825\uD558\uC138\uC694");
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
			
			cboBookType = new Combo(container, SWT.NONE);//저자 입력받기
			cboBookType.setEnabled(false);
			cboBookType.setItems(new String[] {"\uC18C\uC124", "\uC790\uAE30\uACC4\uBC1C", "\uC2DC"});
			cboBookType.setBounds(109, 95, 281, 23);
			cboBookType.select(0);
			
			Label lblNewLabel_4 = new Label(container, SWT.NONE);//저자
			lblNewLabel_4.setBounds(10, 148, 56, 28);
			lblNewLabel_4.setText("\uC800\uC790");
			
			Label lblNewLabel_5 = new Label(container, SWT.NONE);//생년월일
			lblNewLabel_5.setBounds(10, 182, 78, 40);
			lblNewLabel_5.setText("\uC0DD\uB144\uC6D4\uC77C");
			
			Label lblNewLabel_6 = new Label(container, SWT.NONE);//경력
			lblNewLabel_6.setBounds(10, 228, 56, 31);
			lblNewLabel_6.setText("\uACBD\uB825");
			
			Label lblNewLabel_7 = new Label(container, SWT.NONE);//성별
			lblNewLabel_7.setBounds(10, 265, 56, 32);
			lblNewLabel_7.setText("\uC131\uBCC4");
			
			txtAuthor = new Text(container, SWT.BORDER);
			txtAuthor.setEnabled(false);
			txtAuthor.setBounds(107, 134, 283, 42);
			
			dtBirthday = new DateTime(container, SWT.BORDER);//생년월일 입력받기
			dtBirthday.setEnabled(false);
			dtBirthday.setBounds(109, 182, 281, 24);
			
			rbtnWoman = new Button(container, SWT.RADIO);//성별-여성
			rbtnWoman.addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetSelected(SelectionEvent e) {
				}
			});
			rbtnWoman.setBounds(107, 265, 91, 32);
			rbtnWoman.setText("\uB0A8\uC790");
			
			rbtnMan = new Button(container, SWT.RADIO);//성별-남자
			rbtnMan.setBounds(252, 265, 91, 33);
			rbtnMan.setText("\uC5EC\uC790");
			

			
			txtCareer = new Text(container, SWT.BORDER);//경력입력받기
			txtCareer.setEnabled(false);
			txtCareer.setBounds(109, 228, 281, 21);
			
			txtTitle = new Text(container, SWT.BORDER);//제목 입력받기
			txtTitle.setBounds(109, 7, 281, 34);
			
			txtPublisher = new Text(container, SWT.BORDER);//작가 입력받기
			txtPublisher.setBounds(109, 50, 281, 28);		
			
			setBookInfo();

			return area;
		}

		/**
		 * Create contents of the button bar.
		 * @param parent
		 */
		@Override
		protected void createButtonsForButtonBar(Composite parent) {
			Button button = createButton(parent, IDialogConstants.OK_ID, IDialogConstants.OK_LABEL, true);
			button.setText("Update");
			Button button_1 = createButton(parent, IDialogConstants.CANCEL_ID, IDialogConstants.CANCEL_LABEL, false);
			button_1.setText("Close");
		}
		
		private void setBookInfo() {
			txtTitle.setText(title);
			txtPublisher.setText(publisher);
			cboBookType.setText(bookType);
			txtAuthor.setText(authorName);
			txtCareer.setText(career);
			
			int y=Integer.parseInt(birthDate.substring(0,4));
			int m=Integer.parseInt(birthDate.substring(5,7).trim());
			int d=Integer.parseInt(birthDate.substring(8).trim());
			
			dtBirthday.setDate(y, m, d);
			
			if(gender==Gender.MAN)rbtnMan.setSelection(true);
			else rbtnMan.setSelection(true);
		}

		
		@Override
		protected void okPressed() {//ok를 눌렀을 시 title,publisher 업데이트
			title=txtTitle.getText();
			publisher=txtPublisher.getText();
			
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


