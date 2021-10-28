package Backjoon.floodFill;

import java.io.*;
import java.util.*;

public class Main_22352_항체인식 {

	static int N, M;
	static int[][] before;
	static int[][] after;
	static boolean[][] visited;
	
	
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		before = new int[N][M];
		after = new int[N][M];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				before[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				after[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		boolean isInjected = false;
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(before[i][j] != after[i][j] && isInjected == false) {
					// before
					bfs(i,j, after[i][j], before[i][j]);
					isInjected = true;
				} 
			}
		}
		boolean isSame = true;
		for(int i=0; i<N; i++) {
			if(!(Arrays.equals(before[i], after[i]))) isSame = false; 
		}
		if(isSame) System.out.println("YES");
		else System.out.println("NO");
		
	}


	private static void bfs(int i, int j, int c, int k) {
		before[i][j] = c;
		Queue<int[]> que = new LinkedList<int[]>();
		que.add(new int[] {i,j});
		while(!que.isEmpty()) {
			int[] cur = que.poll();
			
			for(int d=0; d<4; d++) {
				int nr = cur[0] + dr[d];
				int nc = cur[1] + dc[d];
				if(nr < 0 || nc < 0 || nr >= N || nc >= M) continue;
				if(before[nr][nc] == k) {
					que.add(new int[] {nr, nc});
					before[nr][nc] = c;
				}
			}
		}
		
	}

}
