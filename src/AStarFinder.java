import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class AStarFinder {

	// 前四个是上下左右，后四个是斜角
	public static final int[] dx = { 0, -1, 0, 1, -1, -1, 1, 1 };
	public static final int[] dy = { -1, 0, 1, 0, 1, -1, -1, 1 };
	
	static int[][] map;
	
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();// 一共n行
		int[][] matrix = new int[n][n];
		int i = 0, j = 0;
		while (n >= 0) {
			j = 0;
			while(j < n){
				matrix[i][j++] = scanner.nextInt();
			}
			i++;
			n--;
		}
		
		/*for(int p = 0; p < matrix.length; p++){
			for(int q = 0; q < matrix[0].length; q++){
				System.out.println(matrix[p][q] + "");
			}
		}*/
		
		map = new int[n+1][n+1];
		for(int m = 0; m <= n+1; m++){
			map[0][m] = 1;
			map[n][m] = 1;
			map[m][0] = 1;
			map[m][n] = 1;
 		}
		
		for(int m = 1; m <= n; m++){
			for(int k = 1; k <= n; k++){
				map[m][k] = matrix[m-1][k-1];
			}
		}
		
		Point start = new Point(1, 1);
		Point end = new Point(n, n);

	 Stack<Point> stack = printPath(start, end);
	 int result = 0;
	 if(null==stack) {
		 System.out.println("不可达");
	 } else{
		 while(!stack.isEmpty()) {
			 System.out.print(stack.pop()+" -> ");
			 result++;
		 }
		 System.out.println(result +"");
	 }
	}
	 public static Stack<Point> printPath(Point start, Point end){
		 ArrayList<Point> openTable = new ArrayList<Point>();
		 ArrayList<Point> closeTable = new ArrayList<Point>();
		 openTable .clear();
		 closeTable.clear();
		 Stack<Point> pathStack = new Stack<Point>();
		 start.parent = null;
		 Point currentPoint = new Point(start.x, start.y);
		 boolean flag = true;
		 while(flag) {
			       for (int i = 0; i < 8; i++) {
			          int fx = currentPoint.x + dx[i];
			          int fy = currentPoint.y + dy[i];
			         Point tempPoint = new Point(fx,fy);
			          if (map[fx][fy] == 1) {
			            // 由于边界都是1中间障碍物也是1，，这样不必考虑越界和障碍点扩展问题
			            //如果不设置边界那么fx >=map.length &&fy>=map[0].length判断越界问题
			            continue;
			          } else {
			            if(end.equals(tempPoint)) {
			              flag = false;
			             //不是tempPoint，他俩都一样了此时
			              end.parent = currentPoint;
			              break;
			            }
			           if(i<4) {
			              tempPoint.G = currentPoint.G + 10;
			            }else {
			              tempPoint.G = currentPoint.G + 14;
			            }
			            tempPoint.H = Point.getDis(tempPoint,end);
			           tempPoint.F = tempPoint.G + tempPoint.H;
			           //因为重写了equals方法，所以这里包含只是按equals相等包含
			            //这一点是使用java封装好类的关键
			            if(openTable.contains(tempPoint)) {
			              int pos = openTable.indexOf(tempPoint );
			             Point temp = openTable.get(pos);
			              if(temp.F > tempPoint.F) {
			                openTable.remove(pos);
			                openTable.add(tempPoint);
			                tempPoint.parent = currentPoint;
			              }
			           }else if(closeTable.contains(tempPoint)){
			             int pos = closeTable.indexOf(tempPoint );
			             Point temp = closeTable.get(pos);
			             if(temp.F > tempPoint.F) {
			               closeTable.remove(pos);
			               openTable.add(tempPoint);
			               tempPoint.parent = currentPoint;
			             }
			           }else {
			            openTable.add(tempPoint);
			             tempPoint.parent = currentPoint;
			           }
			 
			         }
			       }//end for
			       
			       if(openTable.isEmpty()) {
			         return null;
			       }//无路径
			       if(false==flag) {
			         break;
			       }//找到路径
			       openTable.remove(currentPoint);
			       closeTable.add(currentPoint);
			       Collections.sort(openTable);
			       currentPoint = openTable.get(0);
			       
			     }//end while
			    Point node = end;
			     while(node.parent!=null) {
			       pathStack.push(node);
			      node = node.parent;
			    }    
			    return pathStack;
			   }
	}




class Point implements Comparable<Point>{
   int x;
   int y;
   Point parent;
   int F, G, H;
 
   public Point(int x, int y) {
     super();
     this.x = x;
     this.y = y;
     this.F = 0;
     this.G = 0;
     this.H = 0;
   }
 
   @Override
   public int compareTo(Point o) {
     // TODO Auto-generated method stub
     return this.F  - o.F;
  }
 
   @Override
   public boolean equals(Object obj) {
     Point point = (Point) obj;
     if (point.x == this.x && point.y == this.y)
       return true;
     return false;
   }
 
   public static int getDis(Point p1, Point p2) {
    int dis = Math.abs(p1.x - p2.x) * 10 + Math.abs(p1.y - p2.y) * 10;
    return dis;
   }
 
   @Override
   public String toString() {
    return "(" + this.x + "," + this.y + ")";
   }
   
 }
