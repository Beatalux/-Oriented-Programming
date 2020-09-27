package EX1;

public class ForeachEx {
	enum  Color{Blue, White, Red, Black, Yellow}
	
	public static void main(String[] args) {
		int[] nums = {1,2,3,4,5};
		String[] fruits=  {"banana", "pineapple","apple", "grape", "strawberry"};
		int sum=0;
		
		for(int k:nums) {
			sum+=k;
		}
		
		System.out.println("Total of nums : "+sum);
		System.out.println();
		
		System.out.println("My favorite fruits: ");
		for(String s: fruits) {
			System.out.println(s+ " ");
		}
		System.out.println();
		
		System.out.println("Five Cardinal colors; ");
		for(Color c: Color.values()) {
			System.out.println(c+ " ");
		}
		System.out.println();
	}

}
