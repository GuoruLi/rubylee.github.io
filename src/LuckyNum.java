import java.util.Scanner;


public class LuckyNum {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();//有几行
		while(n > 0){
			int k = sc.nextInt();
			long result = getLuckyNum(k);
			System.out.println(result);
			n--;
		}
	}

	private static long getLuckyNum(int k) {
		int i = 0;//第几个幸运数
		long num = 0;
		while(i < k){
			if(isLucky(num)){
				i++;
			}
			num++;
		}
		return --num;
	}

	private static boolean isLucky(long num) {
		String str = String.valueOf(num);
		byte[] bytes = str.getBytes();
		for(int i = 0; i < bytes.length; i++){
			if((bytes[i] - '0') != 4 && (bytes[i] - '0') != 7){
				return false;
			}
		}
		return true;
	}
}
