package Backjoon.floodFill;

import java.io.*;
import java.util.*;

public class Main_4963_섬의_개수 {
	
	static int w, h;
	
	static int[][] map;
	static boolean[][] visited;
	
	static int[] dr = {-1, -1, 0, 1, 1, 1, 0, -1};
	static int[] dc = {0, 1, 1, 1, 0, -1, -1, -1};
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		while(true) {
			st = new StringTokenizer(br.readLine());
			
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			
			if(w == 0 && h == 0) break;
			
			map = new int[h][w];
			visited = new boolean[h][w];
			
			for(int i=0; i<map.length; i++) {
				String[] s = br.readLine().split(" ");
				for(int j=0; j<map[i].length; j++) {
					map[i][j] = Integer.parseInt(s[j]);
				}
			}
			int landCnt = 0;
			for(int i=0; i<map.length; i++) {
				for(int j=0; j<map[i].length; j++) {
					if(map[i][j] == 1 && visited[i][j] == false) {
						bfs(i,j);
						landCnt++;
					}
				}
			}
			sb.append(landCnt).append("\n");
		}
		System.out.println(sb.toString());
	}


	private static void bfs(int i, int j) {
		Queue<int[]> que = new LinkedList<int[]>();
		
		que.add(new int[] {i,j});
		visited[i][j] = true;
		
		while(!que.isEmpty()) {
			int[] now = que.poll();
			int x = now[0];
			int y = now[1];
			
			for(int d=0; d<8; d++) {
				int nr = x + dr[d];
				int nc = y + dc[d];
				if(nr < 0 || nc < 0 || nr >= h || nc >= w) continue;
				if(map[nr][nc] == 1 && visited[nr][nc] == false) {
					visited[nr][nc] = true;
					que.add(new int[] {nr, nc});
				}
			}
		}
	}
}
