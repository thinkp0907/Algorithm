package Backjoon.floodFill;

import java.io.*;
import java.util.*;

public class Main_17129_윌리암슨수액빨이딱따구리가_정보섬에_올라온_이유 {

	static int[] dr = {1, 0, -1, 0};
	static int[] dc = {0, 1, 0, -1};
	
	static int n, m;
	static int[][] map;
	static boolean isFood;
	
	static int answer;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		int sx = 0;
		int sy = 0;
		
		map = new int[n][m];
		
		// 입력
		for(int i=0; i<n; i++) {
			String s = br.readLine();
			for(int j=0; j<m; j++) {
				map[i][j] = s.charAt(j) - '0';
				if(map[i][j] == 2) {
					sx = i;
					sy = j;
				}
			}
		}
		
		// 로직
		answer = -1;
		bfs(sx, sy);
		if(answer == -1) System.out.println("NIE");
		else {
			System.out.println("TAK");
			System.out.println(answer);
		}
	}
	private static void bfs(int sx, int sy) {
		Queue<int[]> que = new LinkedList<int[]>();
		que.add(new int[] {sx, sy, 0});
		
		while(!que.isEmpty()) {
			int[] now = que.poll();
			
			for(int d=0; d<4; d++) {
				int nr = now[0] + dr[d];
				int nc = now[1] + dc[d];
				if(nr < 0 || nc < 0 || nr >= n || nc >= m || map[nr][nc] == 1 || map[nr][nc] == 9) continue;
				if(map[nr][nc] == 3 || map[nr][nc] == 4 || map[nr][nc] ==  5) {
					answer = now[2]+1;
					return;
				}
				que.add(new int[] {nr, nc, now[2]+1});
				map[nr][nc] = 9;
			}
		}
		
	}

}
