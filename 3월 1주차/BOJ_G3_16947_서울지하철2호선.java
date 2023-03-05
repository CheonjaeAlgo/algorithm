package _3월1주차;

import java.util.*;
import java.io.*;
import java.lang.reflect.Array;

/**
 * https://www.acmicpc.net/problem/16947
 * 
 * @author Zizon_Yonni
 *
 */
public class BOJ_G3_16947_서울지하철2호선 {

	static int N;
	static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
	static boolean[] visited,cycle;
	static int dist;
	static int [] ans;
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N + 1; i++) {
			graph.add(new ArrayList<Integer>());
		}

		visited = new boolean[N + 1];
		cycle = new boolean[N+1];
		ans = new int[N+1];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());

			int num1 = Integer.parseInt(st.nextToken());
			int num2 = Integer.parseInt(st.nextToken());

			graph.get(num1).add(num2);
			graph.get(num2).add(num1);

		}
		

		for (int i = 1; i < N + 1; i++) {
			if(isCycle(i,-1,i))
				break;
			else
				visited=new boolean[N+1];
			
			//System.out.println(isCycle(-1,i,i));
		}
		
		//System.out.println(Arrays.toString(cycle));
		
		BFS();
		
		for (int i = 1; i < N+1; i++) {
			int num =ans[i];
			sb.append(num).append(" ");
		}
		System.out.println(sb);

	}
	
	public static void BFS() 
	{
		Queue<Integer> q = new LinkedList<Integer>();
		visited = new boolean[N+1];
		
		for (int i = 1; i < N+1; i++) {
			if(cycle[i]) 
			{
				visited[i]=true;
				q.offer(i);
			}
		}
		
		while(!q.isEmpty()) 
		{
			int n = q.poll();
			
			for(int next : graph.get(n)) 
			{
				if(!visited[next]) 
				{
					q.offer(next);
					visited[next]=true;
					ans[next]=ans[n]+1;
				}
				
			}
		}
		
	}

	public static boolean isCycle(int cur, int prev, int start) {
		
		visited[cur]=true;
		
		for (int next : graph.get(cur)) {
			if (!visited[next]) {
				
				if(isCycle(next,cur,start)) 
				{
					cycle[next]=true;
					//return true;
				}
			}
			else if(prev!=next && start== next) 
			{
				cycle[next]=true;
				return true;
			}
		}
		
		return false;
	}

}
