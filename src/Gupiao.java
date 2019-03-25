import java.util.Scanner;

public class Gupiao {
	private static String str;
	private static int[] a;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		str = sc.next();
		String[] strArray = str.split(",");
		a = new int[strArray.length];
		for(int i = 0; i < strArray.length; i++){
			a[i] = Integer.parseInt(strArray[i]);
		}
		
//		for(int m = 0; m < a.length; m++){ System.out.println(a[m]); }
		 
		int result = getMax(0, a[0]);
		System.out.println(result + "");
		
	}
	
	static int i = 1;
	private static int getMax(int curMax, int curMin) {
		if(i >= a.length)	return curMax;
		
		if(a[i] - curMin > curMax){
			curMax = a[i] - curMin;
		}
		if(a[i] < curMin){
			curMin = a[i];
		}
		
		i++;
		return getMax(curMax, curMin);
	}
}
