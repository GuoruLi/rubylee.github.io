import java.util.Scanner;


public class Chuti {
	private static int[] a;
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();//出了几个题
		int len = n;
		a = new int[n];
		int i = 0;
		while(n > 0){
			int d = sc.nextInt();//难度系数
			a[i++] = d;
			n--;
		}
		sort(len);
		/*for(int j = 0; j < n; j++){
			System.out.println(a[j] + "");
		}*/
		int result = getLeast(len);
		System.out.println(result);
	}
	private static int getLeast(int len) {
		int num1 = 0;//需要的题目数
		int num = 1;//一套题中已有的数目
		int i = 0;
		while(i < len - 1){
			while(i < len - 1 && a[i + 1] - a[i] <= 10 && num < 3 ){
				 num++;
				 i++;
			}
			if(num < 3){
				num1 += 3 - num;
				num = 1;
			} else if(i < len - 1 && a[i + 1] - a[i] > 10){
				num = 1;
			}
			i++;
		}
		return num1;
	}
	private static void sort(int len) {
		int[] d = new int[100];
		for(int i = 0; i < len; i++){
			d[a[i]] = 1;
		}
		int index = 0;
		for(int i = 0; i < 100; i++){
			if(d[i] == 1){
				a[index++] = i;
			}
		}
	}
}
