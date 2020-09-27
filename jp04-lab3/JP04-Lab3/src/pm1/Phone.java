package pm1;

public class Phone {
	private String name,phoneNum;
	
	public String getPhoneNum() {
		return phoneNum;
	}

	public Phone(){
	
	}
	
	public Phone(String name, String phoneNum) {
		this.name="annonymous";
		this.phoneNum="000";
	}
	
	public boolean isYourName(String name) {
		if(name.contentEquals(this.name))
			return true;
		else
			return false;
		
	}
	

}
