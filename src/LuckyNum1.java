import java.util.Scanner;


public class LuckyNum1 {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();//有几行
		while(n > 0){
			int k = sc.nextInt();//找第k个幸运数
			String result = getLuckyNum(k);
			System.out.println(result);
			n--;
		}
	}

	private static String getLuckyNum(int k) {
		int i = 0;//在第几行
		int c = (k + 1) / 2;
		while( c >= 1){
			i++;
			c /= 2;
		}
		int j = (int) ((k + 1) - Math.pow(2, i));//在第几列
		byte[] a = new byte[i];
		for(int m = 0; m < i; m++){
			a[m] = 0;
		}
		while(j > 0){
			for(int m = 0; m < i && j > 0; m++){
				if(a[m] + 1 >= 2){
					a[m] = 0;
				} else {
					a[m] = 1;
					break;
				}
			}
			j--;
		}
		StringBuilder sb = new StringBuilder();
		for(int m = i - 1; m >= 0; m--){
			if(a[m] == 0){
				sb.append(4);
			}else {
				sb.append(7);
			}
		}
		return sb.toString();
	}
}
