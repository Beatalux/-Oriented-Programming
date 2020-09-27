package pm1;

public class Employee {
	private String id;
	private String name;
	private int workHours;
	private int overTimeHours;
	private PayManager payManager;
	
	public Employee(String id, String name,int workHouse, int overTimeHours) {
		this.id=id;
		this.name=name;
		this.workHours=workHours;
		this.overTimeHours=overTimeHours;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getWorkHours() {
		return workHours;
	}

	public void setWorkHours(int workHours) {
		this.workHours = workHours;
	}

	public int getOverTimeHours() {
		return overTimeHours;
	}

	public void setOverTimeHours(int overTimeHours) {
		this.overTimeHours = overTimeHours;
	}

	public long calculatePay() {
		long pay=payManager.calculatePay(this);
		return pay;
	}
	
	public void setPayManager(PayManager payManager) {
		
	}
	

}
