package Backjoon.floodFill;

import java.io.*;
import java.util.*;

public class Main_2583_영역_구하기 {

	static int N, M, K;
	static int[][] map;
	static int[] area;
	static boolean[][] visited;
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		visited = new boolean[N][M];
		
		for(int i=0; i<K; i++) {
			st = new StringTokenizer(br.readLine());
			int fx = Integer.parseInt(st.nextToken());	// 0
			int fy = Integer.parseInt(st.nextToken());	// 2
			int lx = Integer.parseInt(st.nextToken());	// 4
			int ly = Integer.parseInt(st.nextToken());	// 4
			
			// 0 ~ 3, 2 ~ 3
			for(int x=fx; x<lx; x++) {
				for(int y=fy; y<ly; y++) {
					map[x][y] = -1;
				}
			}

		}
		int cnt = 0;
		for(int i=0; i<map.length; i++) {
			for(int j=0; j<map[i].length; j++) {
				if(map[i][j] == 0) {
					dfs(i,j, ++cnt);
				}
			}
		}
		area = new int[cnt];
		for(int i=0; i<map.length; i++) {
			for(int j=0; j<map[i].length; j++) {
				if(map[i][j] > -1) {
					area[map[i][j]-1]++;
				}
			}
		}
		
		Arrays.sort(area);
		
		sb.append(cnt).append("\n");
		for(int i=0; i<cnt; i++) {
			sb.append(area[i]).append(" ");
		}
		System.out.println(sb.toString());
	}

	private static void dfs(int i, int j, int cnt) {
		map[i][j] = cnt;
		
		for(int d=0; d<4; d++) {
			int nr = i + dr[d];
			int nc = j + dc[d];
			if(nr < 0 || nc < 0 || nr >= N || nc >= M) continue;
			if(map[nr][nc] == 0) {
				dfs(nr, nc, cnt);
			}
		}
	}

}
