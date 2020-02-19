package Graph;

import java.util.*;


import java.util.HashMap;

public class DijkstraAlgo {
	
	public static HashMap<Integer, Character> map = new HashMap<>();
	
	public int findMinWeight(int[] weight, boolean[] inHeap)
	{
		int min = Integer.MAX_VALUE;
		int min_index = -1;
		for(int i = 0; i < weight.length; i++)
		{
			if(min > weight[i] && !inHeap[i])
			{
				min = weight[i];
				min_index = i;
			}
			
		}
		return min_index;
	}
	
	void printMinPath(int parent[], int weight[]) {
		System.out.println("Edge \tWeight");
		for (int i = 1; i < parent.length; i++)
			System.out.println(map.get(0) + " - " + map.get(i) + "\t" + weight[i]);
	}
	public void shortestPath(int[][] graph)
	{
		int vertices = graph.length;
		int weight[] = new int[vertices];
		boolean[] inHeap = new boolean[vertices];
		int[] parent = new int[vertices];
		
		for(int i =0; i < vertices; i++)
		{
			weight[i] = Integer.MAX_VALUE;
		}
		
		
		for(int i =0; i < vertices-1; i++)
		{
			weight[0] =0;
			parent[0] =-1;
			
			int u = findMinWeight(weight,inHeap);
			System.out.print("check " + u + "\n");
			inHeap[u] = true;
			
			for(int v =0; v< vertices; v++)
			{
				
				if(graph[u][v] != 0 && !inHeap[v] && weight[v] > (weight[u]+graph[u][v]))
				{
					weight[v] = weight[u]+ graph[u][v];
					parent[v] = u;
				}
			}
		}
		printMinPath(parent, weight);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[] vertices = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 's' };

		for (int i = 0; i < 9; i++) {
			map.put(i, vertices[i]);
		}

		DijkstraAlgo t = new DijkstraAlgo();
		int graph[][] = new int[][] { { 0, 0, 1, 6, 0, 0, 0, 0, 1 }, { 0, 0, 3, 5, 0, 0, 0, 0, 2 },
				{ 1, 3, 0, 0, 3, 2, 0, 0, 0 }, { 6, 5, 0, 0, 1, 0, 2, 0, 0 }, { 0, 0, 3, 1, 0, 8, 6, 0, 0 },
				{ 0, 0, 2, 0, 8, 0, 0, 9, 0 }, { 0, 0, 0, 2, 6, 0, 0, 3, 0 }, { 0, 0, 0, 0, 0, 9, 3, 0, 0 },
				{ 1, 2, 0, 0, 0, 0, 0, 0, 0 } };

		// Print the solution
		t.shortestPath(graph);
	}

}
