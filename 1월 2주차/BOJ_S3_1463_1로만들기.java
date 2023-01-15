import java.util.Scanner;

public class BOJ_S3_1463_1로만들기{

	static int ans =Integer.MAX_VALUE;
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		//makeOne(n,0);
		makeOneDP(n);
		System.out.println(ans);
		
		
	}
	
	//재귀
	public static void makeOne(int n,int cnt) 
	{
		if(n==1) {
			ans=Math.min(ans, cnt);
			return;
		}
		if(ans<=cnt)
			return;
		
		if(n%6==0) {
			makeOne(n/3,cnt+1);
			makeOne(n/2,cnt+1);
		}
		else if(n%3==0) 
		{
			makeOne(n/3,cnt+1);
		}
		else if(n%2==0){
			makeOne(n/2,cnt+1);
		}
		makeOne(n-1,cnt+1);
	}
	
	public static void makeOneDP(int n) 
	{
		int dp[] = new int[n+1];
		dp[0]=dp[1]=0;
		
		for(int i=2; i<n+1;i++) 
		{
			dp[i]=dp[i-1]+1;
			if(i%6==0) 
			{
				dp[i]=Math.min(dp[i], dp[i/3]+1);
				dp[i]=Math.min(dp[i], dp[i/2]+1);
			}
			else if(i%3==0) 
			{
				dp[i]=Math.min(dp[i], dp[i/3]+1);
			}
			else if(i%2==0) 
			{
				dp[i]=Math.min(dp[i], dp[i/2]+1);
			}
			
		}
		
		ans=dp[n];
		
	}
	

}
