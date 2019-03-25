import java.util.Scanner;

public class Search {
	static int x, n;
	static int[] a;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		x = sc.nextInt();// 要查找的数
		n = sc.nextInt();// 数组长度
		a = new int[n];
		int i = 0;
		while (i < n) {
			int k = sc.nextInt();// 数组第k个数
			a[i] = k;
			i++;
		}
		/*
		 * for(int m = 0; m < n; m++){ System.out.println(a[m]); }
		 */

		int index = findIndex(x);
		System.out.println(index + "");
	}

	private static int findIndex(int x) {
		int index = getFirstKey(a, n, x, 0, n - 1);
		
		return index;
	}

	private static int getFirstKey(int[] arr, int length, int key, int start,
			int end) {
		if (start > end) {
			return -1 - start;
		}
		int mid = start + (end - start >> 1);
		if (arr[mid] == key) {
			// 当前一个数字不等于key,说明arr[mid]就是第一次出现，前提是存在前一个数字，即mid>0;
			// 如果没有前一个数字，说明arr[mid]是第一次出现。
			if ((mid > 0 && arr[mid - 1] != key) || mid == 0) {
				return mid;
			} else {
				end = mid - 1;// 如果前一个数字也等于key,说明key第一次出现在mid前面
			}
		} else if (arr[mid] > key) {
			end = mid - 1;
		} else {
			start = mid + 1;
		}
		return getFirstKey(arr, length, key, start, end);
	}
}
