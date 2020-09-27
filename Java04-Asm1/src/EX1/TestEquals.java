package EX1;

public class TestEquals {
	
	public static void setArrValues(int[] arr) {
		for(int i=0;i<arr.length;i++)
			arr[i]=i;
	}
	
	public static boolean contentEquals(int[] arr1, int[] arr2) {
		if(arr1.length != arr2.length) return false;
		
		for(int i=0;i<arr1.length;i++) {
			if(arr1[i] != arr2[i])
				return false;
		}
		return true;
	}
	
	
	public static void main(String[] args) {
		int[] arr1 = new int[3];
		int[] arr2 = new int [3];
		
		setArrValues(arr1);
		setArrValues(arr2);
		
		if(arr1 == arr2) System.out.println("Equal by ==");
		else System.out.println("Not equal by ==");
		
		if(contentEquals(arr1, arr2)) System.out.println("Equal by the contentEquals method.");
		else System.out.println("Not equal by the contentEquals method.");
		
	}

}
