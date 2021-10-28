package Backjoon.floodFill;

import java.io.*;
import java.util.*;

public class Main_6080_Bad_Grass {

	static int R, C;
	static int[][] map;
	static boolean[][] visited;
	
	static int[] dr = { -1, -1, 0, 1, 1, 1, 0, -1 };
	static int[] dc = { 0, 1, 1, 1, 0, -1, -1, -1 };
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new int[R][C];
		visited = new boolean[R][C];
		
		for(int i=0; i<R; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<C; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int cnt = 0;
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				if(map[i][j] != 0 && visited[i][j] == false) {
					bfs(i,j);
					cnt++;
				}
			}
		}
		
		System.out.println(cnt);
	}

	private static void bfs(int i, int j) {
		Queue<int[]> que = new LinkedList<int[]>();
		que.add(new int[] {i, j});
		visited[i][j] = true;
		while(!que.isEmpty()) {
			int[] cur = que.poll();
			
			for(int d=0; d<8; d++) {
				int nr = cur[0] + dr[d];
				int nc = cur[1] + dc[d];
				if(nr < 0 || nc < 0 || nr >= R || nc >= C) continue;
				if(map[nr][nc] != 0 && visited[nr][nc] == false) {
					que.add(new int[] {nr, nc});
					visited[nr][nc] = true;
				}
			}
		}
	}

}
