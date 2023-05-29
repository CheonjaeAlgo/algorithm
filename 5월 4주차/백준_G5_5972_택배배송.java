package _5월4주차;

import java.io.*;
import java.util.*;

/**
 * https://www.acmicpc.net/problem/5972
 * 
 * @author Zizon_Yonni
 *
 */
public class 백준_G5_5972_택배배송 {

	static class Node {
		int node;
		int cost;

		public Node(int node, int cost) {
			this.node = node;
			this.cost = cost;
		}
	}

	static int N, M, dist[];
	static ArrayList<ArrayList<Node>> graph = new ArrayList<ArrayList<Node>>();
	static boolean visited[];

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		dist = new int[N + 1];
		visited = new boolean[N + 1];

		for (int i = 0; i < N + 1; i++) {
			graph.add(new ArrayList<Node>());
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());

			int cur = Integer.parseInt(st.nextToken());
			int next = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());

			graph.get(cur).add(new Node(next, cost));
			graph.get(next).add(new Node(cur, cost));
		}

		for (int i = 0; i < N + 1; i++) {
			dist[i] = Integer.MAX_VALUE;
		}
		dist[0] = dist[1] = 0;

		Dijkstra();
		//System.out.println(Arrays.toString(dist));
		System.out.println(dist[N]);
	}

	static public void Dijkstra() 
	{
		PriorityQueue<Node>  pq = new PriorityQueue<Node>((o1,o2)->Integer.compare(o1.cost, o2.cost));
		
		pq.offer(new Node(1,0));
		
		while(!pq.isEmpty()) 
		{
			Node cur = pq.poll();
			
//			if(!visited[cur.node])
//				visited[cur.node]=true;
//			else continue;
			
			if(dist[cur.node]<cur.cost)
				continue;
			
			for(int i=0; i<graph.get(cur.node).size();i++) 
			{
				Node next = graph.get(cur.node).get(i);
				
				if(dist[next.node]> cur.cost +next.cost) 
				{
					dist[next.node] = cur.cost+next.cost;
					pq.offer(new Node(next.node,dist[next.node]));
				}
			}
		}
	}
}
