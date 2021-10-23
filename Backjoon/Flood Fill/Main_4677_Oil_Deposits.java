package Backjoon.floodFill;

import java.io.*;
import java.util.*;

public class Main_4677_Oil_Deposits {
	
	static int m, n;
	static char[][] map;
	
	static int[] dr = {-1, -1, 0, 1, 1, 1, 0, -1};
	static int[] dc = {0, 1, 1, 1, 0, -1, -1, -1};
	
	static boolean[][] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			m = Integer.parseInt(st.nextToken());
			n = Integer.parseInt(st.nextToken());
			
			if(m == 0) break;
			
			map = new char[m][n];
			visited = new boolean[m][n];
			
			for(int i=0; i<m; i++) {
				String s = br.readLine();
				for(int j=0; j<n; j++) {
					map[i][j] = s.charAt(j);
				}
			}
			int cnt = 0;
			for(int i=0; i<m; i++) {
				for(int j=0; j<n; j++) {
					if(map[i][j] == '@' && visited[i][j] == false)  {
						cnt++;
						bfs(i,j);
					}
				}
			}
			sb.append(cnt).append("\n");
		}
		System.out.println(sb.toString());
	}

	private static void bfs(int i, int j) {
		Queue<int[]> que = new LinkedList<>();
		que.add(new int[] {i,j});
		visited[i][j] = true;
		
		while(!que.isEmpty()) {
			int now[] = que.poll();
			
			for(int d=0; d<8; d++) {
				int nr = now[0] + dr[d];
				int nc = now[1] + dc[d];
				if(nr < 0 || nc < 0 || nr >= m || nc >= n) continue;
				if(map[nr][nc] == '@' && visited[nr][nc] == false) {
					que.add(new int[] {nr,nc});
					visited[nr][nc] = true;
				}
			}
		}
	}

}
