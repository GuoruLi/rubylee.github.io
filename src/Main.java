import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Scanner;



public class Main {
//	static int ch;
	static int[] input;
	static int len;
    public static void main(String args[]){
    	/*boolean flag , Flag;
    	flag = 6 > 7;
    	Flag = flag || !flag;
    	System.out.println(flag+ "   " + Flag);*/
    	String s = " 欢迎Java";
    	System.out.println(Math.round(-10.5));
    	
    	
    	Scanner scanner = new Scanner(System.in);
    	int n = scanner.nextInt();// 一共n行
    	input = new int[n];
    	len = n;
    	int m = 0;
    	while(n > 0){
    		input[m++] = scanner.nextInt();
    		n--;
    	}
    	/*for(int j = 0; j < input.length; j++){
    		System.out.println(input[j]);
    	}*/
    	int result = 0;
    	for(int i = 0; i < len; i++){
    		for(int j = i + 1; j < len; j++){
    			int start = input[i], end = input[j];
    			for(;start < end; start++){
    				if(start / 2 != 0 && isPrime(start)){
    					result++;
    				}
    			}
    		}
    	}
    	System.out.println(result + "");
    }
    public static boolean isPrime(int n){
		for(int i=2;i<n;i++){
			if(n%i==0){
				return false;
			}
		}
		if(n==1){
			return false;
		}
		return true;
	}
}

/*//    	try {
Scanner scanner = new Scanner(System.in);
String str = scanner.next();// 一共n行
Reader reader=new FileReader("C:/Users/Guoru/Desktop/Main.txt");
ch = reader.read();
StringBuffer buffer=new StringBuffer();
while(ch!=-1){ //读取成功
    buffer.append((char)ch);
    ch=reader.read();
}
//String str = buffer.toString();
int len = str.length(), maxLen = -1;
for(int i = 0; i < len; i++){
	for(int j = i; j < len; j++){
		int start = i;
		int end = j;
		boolean flag = true;
		while(start <= end){
			if(str.charAt(start) != str.charAt(end)){  
                flag = false;   //首尾不相等 退出循环
                break;  
            } 
			start++;
			end--;
		}
		int subLen = j - i + 1;
		if(flag && subLen > maxLen){
			maxLen = subLen;
		}
	}
}
System.out.println(maxLen + "");
} catch (IOException e) {
// TODO Auto-generated catch block
e.printStackTrace();
}
*/