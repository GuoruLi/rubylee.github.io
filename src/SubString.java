
public class SubString {
	public static void main(String[] args){
		/*int len = lengthOfLongestSubString("cdcde", 2);
		System.out.println(len);*/
		
		/*String c = "credit" + "ease";
		String h = "credit" + getTail();
		System.out.println(c==h?true:false);
		final String d = "ease";
		String f = "credit" + d;
		System.out.println(c==f?true:false);*/
		System.out.println(getTail());
		
	}
	
	private static int getTail() {
		int i = 1;
		try{
			return i++;
		}finally{
			if(i == 1){
				System.out.println("a");
				i = 10;
			}
			else if(i == 2){
				System.out.println("b");
				i = 15;
			}
		}
	}

	public static int lengthOfLongestSubString(String s, int n){
		byte[] b = s.getBytes();
		int[] a;
		int maxLen = 0;
		
		for(int i = 0; i< b.length; i++){
			for(int j = i + 1; j < b.length; j++){
				a = new int[256];
				int index = i;
				while(index <= j){
					a[b[index]]++;
					index++;
				}
				int currentN = 0;
				int len = 0;
				for(int m = 0; m < a.length; m++){
					if(a[m] != 0){
						currentN++;
						len+=a[m];
					}
				}
				if(currentN > n){
					break;
				}else if(currentN == n){
					if(len > maxLen){
						maxLen = len;
					}
				}
			}
		}
		return maxLen;
	}
}
