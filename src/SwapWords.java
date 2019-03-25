import java.util.Scanner;

public class SwapWords {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		
		System.out.println(swapWords(str));
	}

	private static String swapWords(String str) {
		char[] c = str.toCharArray();
		//翻转整个字符串
		swap(c, 0, c.length - 1);
		int begin = 0;
		for(int i = 1; i < c.length; i++){
			if(c[i] == ' '){
				swap(c, begin, i - 1);
				begin = i + 1;
			}
		}
		swap(c, begin, c.length-1);
		return new String(c);
	}

	private static void swap(char[] c, int i, int j) {
		while(i < j){
			char temp = c[i];
			c[i] = c[j];
			c[j] = temp;
			i++;
			j--;
		}
	}
}
