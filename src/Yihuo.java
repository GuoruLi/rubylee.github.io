import java.util.Scanner;


public class Yihuo {
	private static int[] a;
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();//n个数字
		int m = sc.nextInt();//整数m
		a = new int[n];
		int i = 0;
		while(n > 0){
			int num = sc.nextInt();//第k个数
			a[i++] = num;
			n--;
		}
		long start = System.currentTimeMillis();
		int result = findLarger(m);
		long end = System.currentTimeMillis();
		System.out.println(result + "时间：" + (end - start));
	}
	private static int findLarger(int m) {
		int num = 0;
		for(int i = 0; i < a.length; i++){
			for(int j = i + 1; j < a.length; j++){
				if((a[i] ^ a[j]) > m){
					num++;
				}
			}
		}
		return num;
	}
}
