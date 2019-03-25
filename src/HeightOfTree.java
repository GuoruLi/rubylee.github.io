import java.util.Scanner;

class TreeNode{
	int value;
	TreeNode left;
	TreeNode right;
	
	public TreeNode(int value){
		this.value = value;
	}
}

public class HeightOfTree {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();//结点编号0~n-1
		int i = 0;
		TreeNode root = new TreeNode(0);
		TreeNode root1 = root;
		while(i < n - 1){
			int father = sc.nextInt();
			int child = sc.nextInt();
			
			if(father == 0 && root.left == null){
				root.left = new TreeNode(child);
			}else if(father == 0 && root.right == null){
				root.right = new TreeNode(child);
			}
			else if(root != null){
				if(root.left != null && father == root.left.value){
					root = root.left;
					if(root.left == null){
						root.left = new TreeNode(child);
					}else{
						root.right = new TreeNode(child);
					}
				}
				else if(root.right != null && father == root.right.value){
					root = root.right;
					if(root.left == null){
						root.left = new TreeNode(child);
					}else{
						root.right = new TreeNode(child);
					}
				}
			}
			i++;
		}
		
		//求树的高度
		int height = getHeight(root1);
		System.out.println(height);
	}

	private static int getHeight(TreeNode root1) {
		if(root1 == null){
			return 0;
		}
		int leftHeight = getHeight(root1.left);
		int rightHeight = getHeight(root1.right);
		return (leftHeight>rightHeight ? leftHeight : rightHeight) + 1;
	}
}
