import java.util.Scanner;
import java.util.Vector;


public class JiaoChaSort {
	private static Vector<Integer> s = new Vector<Integer>();
	public static void main(String[] arg){
		Scanner sc = new Scanner(System.in);
		
		String str = sc.nextLine();
		String[] a = str.split("\\s+");
		for(int i = 0; i < a.length; i++){
			int num = Integer.parseInt(a[i]);
			s.add(num);
		}
		
		//偶数位降序
		for(int i = 0; i < s.size(); i += 2){
			for(int j = i + 2; j < s.size(); j += 2){
				if(s.get(i) < s.get(j)){
					int temp = s.get(i);
					s.set(i, s.get(j));
					s.set(j, temp);
				}
			}
		}
		/*for(int i = 0; i < s.size(); i += 2){
			for(int j = 0; j < s.size() - i - 1; j += 2){
				if(s.get(j) < s.get(j+1)){
					int temp = s.get(j);
					s.set(j, s.get(j+1));
					s.set(j+1, temp);
				}
			}
		}*/
		
		//奇数位升序
		for(int i = 1; i < s.size(); i += 2){
			for(int j = i + 2; j < s.size(); j += 2){
				if(s.get(i) > s.get(j)){
					int temp = s.get(i);
					s.set(i, s.get(j));
					s.set(j, temp);
				}
			}
		}
		
		for(int i = 0; i < s.size(); i++){
			System.out.println(s.get(i));
		}
		
	}
}
