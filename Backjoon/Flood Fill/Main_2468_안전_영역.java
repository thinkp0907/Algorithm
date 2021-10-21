package Backjoon.floodFill;

import java.io.*;
import java.util.*;

public class Main_2468_안전_영역 {

	static int N;
	static int[][] map;
	static boolean[][] visited;
	static int totCnt;
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		N = Integer.parseInt(br.readLine());
		
		map = new int[N][N];
		visited = new boolean[N][N];
		
		int maxNum = 0;
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				maxNum = Math.max(maxNum, map[i][j]);
			}
		}
		
		
		for(int k=0; k<=maxNum; k++) {
			int tot = 0;
			visited = new boolean[N][N];
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(map[i][j] > k && visited[i][j] == false) {
						dfs(i,j,k);
						tot++;
					}
				}
			}
			totCnt = Math.max(tot, totCnt);
		}
		System.out.println(totCnt);
	}

	private static void dfs(int i, int j, int k) {
		visited[i][j] = true;

		for(int d=0; d<4; d++) {
			int nr = i + dr[d];
			int nc = j + dc[d];
			if(nr < 0 || nc < 0 || nr >= N || nc >= N) continue;
			if(map[nr][nc] > k && visited[nr][nc] == false) {
				dfs(nr,nc, k);
			}
		}
		
	}

}
