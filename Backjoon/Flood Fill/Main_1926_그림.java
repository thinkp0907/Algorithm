package Backjoon.floodFill;

import java.io.*;
import java.util.*;

public class Main_1926_그림 {

	static int N, M;
	static int[][] map;
	static boolean[][] visited;
	static int totCnt;
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		int oneCnt = 0;
		
		map = new int[N][M];
		visited = new boolean[N][M];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 1) oneCnt++;
			}
		}
		
//		if(oneCnt == 0) {
//			sb.append(0).append("\n").append(0);
//			System.out.println(sb.toString());
//			return;
//		}
		
		int cnt = 0;
		int tot = 0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(map[i][j] == 1 && visited[i][j] == false) {
					totCnt = 0;
					floodFill(i,j);
					cnt++;
					tot = Math.max(totCnt, tot);
				}
			}
		}
		sb.append(cnt).append("\n").append(tot);
		System.out.println(sb.toString());
	}

	private static void floodFill(int i, int j) {
		visited[i][j] = true;
		totCnt++;
		
		for(int d=0; d<4; d++) {
			int nr = i + dr[d];
			int nc = j + dc[d];
			if(nr < 0 || nc < 0 || nr >= N || nc >= M) continue;
			if(map[nr][nc] == 1 && visited[nr][nc] == false) {
				floodFill(nr, nc);
			}
		}
		
	}

}
