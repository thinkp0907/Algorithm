package Backjoon.floodFill;

import java.io.*;
import java.util.*;

public class Main_11123_양한마리양두마리 {
	
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1 ,0, -1};

	static int T, H, W;
	static char[][] map;
	static boolean[][] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		
		T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			st = new StringTokenizer(br.readLine());
			
			H = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			
			map = new char[H][W];
			visited = new boolean[H][W];
			
			for(int i=0; i<H; i++) {
				map[i] = br.readLine().toCharArray();
			}
			
			int cnt = 0;
			for(int i=0; i<H; i++) {
				for(int j=0; j<W; j++) {
					if(map[i][j] == '#' && visited[i][j] == false) {
						bfs(i,j);
						cnt++;
					}
				}
			}
			sb.append(cnt).append("\n");
		}
		System.out.println(sb.toString());
	}
	private static void bfs(int i, int j) {
		Queue<int[]> que = new LinkedList<int[]>();
		
		que.add(new int[] {i, j});
		visited[i][j] = true;
		
		while(!que.isEmpty()) {
			int[] cur = que.poll();
			
			for(int d=0; d<4; d++) {
				int nr = cur[0] + dr[d]; 
				int nc = cur[1] + dc[d];
				if(nr < 0 || nc < 0 || nr >= H || nc >= W) continue;
				if(map[nr][nc] == '#' && visited[nr][nc] == false) {
					que.add(new int[] {nr,nc});
					visited[nr][nc] = true;
				}
			}
		}
	}

}
