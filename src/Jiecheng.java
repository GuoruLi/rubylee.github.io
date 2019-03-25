import java.util.Scanner;


public class Jiecheng {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();//正整数n
		int num = 0;
	    int i,j;
	    
	    for (i = 5;i <= n;i += 5)
	    {
	        j = i;
	        while (j % 5 == 0)
	        {
	            num++;
	            j /= 5;
	        }
	    }
	    System.out.println(num);
	}
}
