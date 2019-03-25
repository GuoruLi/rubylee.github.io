import java.util.Scanner;


public class Migong {
	private static String str;
	private static int[][] array;
	private static int n, m, P;
	private static int maxLine;  
    private static int maxRow; 
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		str = sc.nextLine();
		String[] strArray = str.split(" ");
		n = Integer.parseInt(strArray[0]);//n行
		m = Integer.parseInt(strArray[1]);//m列
		P = Integer.parseInt(strArray[2]);//体力
		array = new int[n][m];
//		System.out.println(n + " " + m + " " + P);
		int i = 0;
		while(i < n){
			for(int j = 0; j < m; j++){
				array[i][j] = sc.nextInt();
			}
			i++;
		}
		
		/*for(int p = 0; p < array.length; p++){
			for(int q = 0; q < array[0].length; q++){
				System.out.println(array[p][q]);
			}
		}*/
		maxLine = m;
		maxRow = n;
		check(0,0);
		
	}
	
	private static int sum;
	private static  void check(int i, int j) {  
        //如果到达右上角出口  
        if (i == 0 && j == maxLine - 1) {  
            print();  
            return;  
        }  
  
        //向右走  
        if (canMove(i, j, i, j + 1)) {  
            array[i][j] = 5;
            check(i, j + 1);  
            array[i][j] = 0; 
            sum+=1;
        }  
        //向左走  
        if (canMove(i, j, i, j - 1)) {  
            array[i][j] = 5; 
            check(i, j - 1);  
            array[i][j] = 0;  
            sum+=1;
        }  
        //向下走  
        if (canMove(i, j, i + 1, j)) {  
            array[i][j] = 5; 
            check(i + 1, j);  
            array[i][j] = 0;  
        }  
        //向上走  
        if (canMove(i, j, i - 1, j)) {  
            array[i][j] = 5;  
            check(i - 1, j);  
            array[i][j] = 0; 
            sum+=3;
        }  
    }  
  
    private static boolean canMove(int i, int j, int targetI, int targetJ) {  
//        System.out.println("从第" + (i + 1) + "行第" + (j + 1) + "列，走到第" + (targetI + 1) + "行第" + (targetJ + 1) + "列");  
        if (targetI < 0 || targetJ < 0 || targetI >= maxRow || targetJ >= maxLine) {  
//            System.out.println("到达最左边或最右边，失败了");  
            return false;  
        }  
        if (array[targetI][targetJ] == 0) {  
//            System.out.println("目标是墙，失败了");  
            return false;  
        }  
        //避免在两个空格间来回走  
        if (array[targetI][targetJ] == 5) {  
//            System.out.println("来回走，失败了");  
            return false;  
        }  
  
        return true;  
    } 
    
    
    private static void print() {  
    	if(sum > P){
    		System.out.println("Can not escape!");
    		return;
    	}
        System.out.println("得到一个解：");  
        for (int i = 0; i < maxRow; i++) {  
            for (int j = 0; j < maxLine; j++) {  
//                System.out.print(array[i][j] + " "); 
                if(array[i][j] == 5){
                	System.out.print("["+ i + ","+ j + "]"); 
                }
            }  
        }  
        
    }  
}
