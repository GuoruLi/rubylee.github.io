import java.util.Scanner;

public class Dist {
	private static int[][] A;// 邻接矩阵
	private static String str;
	private static int n;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();// 有几个国家
		A = new int[n][n];
		int row = 0;
		while (n > 0) {
			str = sc.next();// 读取一行
			String[] strArray = str.split(",");
			for (int i = 0; i < strArray.length; i++) {
				A[row][i] = Integer.parseInt(strArray[i]);
			}
			row++;
			n--;
		}
		/*
		 * for(int i = 0; i < a.length; i++){ for(int j = 0; j < a.length; j++){
		 * System.out.println(a[i][j]); } }
		 */
		Dijkstra(A[0][0]);
	}

	private static void Dijkstra(int v0)
	{
		n = n + 1;
		int dist[] = new int[n];
		int prev[] = new int[n];
		boolean S[] = new boolean[n];                                  // 判断是否已存入该点到S集合中
		for(int i=1; i<=n; ++i)
		{
			dist[i] = A[v0][i];
			S[i] = false;                                // 初始都未用过该点
			if(dist[i] == n)    
	            prev[i] = -1;
			else 
	            prev[i] = v0;
		}
		dist[v0] = 0;
		S[v0] = true;
		for(int i=2; i<=n; i++)
		{
			int mindist = n;
			int u = v0;  // 找出当前未使用的点j的dist[j]最小值
	      	for(int j=1; j<=n; ++j)
	      		if((!S[j]) && dist[j]<mindist)
	      	 {
	         	      u = j;                             // u保存当前邻接点中距离最小的点的号码 
	        	      mindist = dist[j];
	      	}
	       S[u] = true; 
	      	for(int j=1; j<=n; j++){
	      		if((!S[j]) && A[u][j]<n){
	      			if(dist[u] + A[u][j] < dist[j]){
	      				dist[j] = dist[u] + A[u][j];    //更新dist 
	                   	prev[j] = u; 
	      			}
	      		}
	      	}
		}
		for(int m = 0; m < dist.length; m++){
			System.out.println(dist[m] + "");
		}
	}
}
