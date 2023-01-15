import java.util.Arrays;
import java.util.Scanner;

public class BOJ_S3_3273_두수의합 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int [] num = new int[N];
		int index=0;
		for(int i=0; i< N;i++) 
		{
			num[i]=sc.nextInt();
		}
		
		Arrays.sort(num);
		
		int target = sc.nextInt();
	
		int start =0;
		int end = N-1;
		int sum=0;
		
		while(start<end) 
		{
			sum =num[start]+num[end];
			
			if(target==sum) {
				index++;
			}
			if(sum<=target)
				start++;
			else end--;
		}
		
		System.out.println(index);	
	}
}
