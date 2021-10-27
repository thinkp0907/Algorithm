package Backjoon.floodFill;

import java.io.*;
import java.util.*;

public class Main_13565_침투 {
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};

	static int M, N;
	static int[][] map;
	static boolean[][] visited;
	
	static boolean canGo;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		map = new int[M][N];
		visited = new boolean[M][N];
		
		for(int i=0; i<M; i++) {
			String s = br.readLine();
			for(int j=0; j<N; j++) {
				map[i][j] = s.charAt(j) - '0';
			}
		}
		canGo = false;
		for (int j = 0; j < map[0].length; j++) {
			if (map[0][j] == 0 && visited[0][j] == false) {
				bfs(0, j);
			}
		}
		
		System.out.println(canGo == false ? "NO" : "YES");
	}
	private static void bfs(int i, int j) {
		Queue<int[]> que = new LinkedList<int[]>();
		que.add(new int[] {i, j});
		visited[i][j] = true;
		
		while(!que.isEmpty()) {
			int[] cur = que.poll();
			
			if(cur[0] == M-1) {
				canGo = true;
				return;
			}
			
			for(int d=0; d<4; d++) {
				int nr = cur[0] + dr[d];
				int nc = cur[1] + dc[d];
				if(nr < 0 || nc < 0 || nr >= M || nc >= N) continue;
				if(map[nr][nc] == 0 && visited[nr][nc] == false) {
					que.add(new int[] {nr, nc});
					visited[nr][nc] = true;
				}
			}
		}
	}

}
