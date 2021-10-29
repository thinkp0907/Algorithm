package Backjoon.floodFill;

import java.io.*;
import java.util.*;

public class Main_7562_나이트의_이동 {

	static int[] dr = {-2, -2, -1, 1, 2, 2, 1, -1};
	static int[] dc = {-1, 1, 2, 2, 1, -1, -2, -2};
	static int T, N;
	static int[][] map;
	
	static int targetX;
	static int targetY;
	static int totCnt;
	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();

		T = sc.nextInt();
		

		for (int t = 0; t < T; t++) {
			N = sc.nextInt();
			map = new int[N][N];
			
			int x = sc.nextInt();
			int y = sc.nextInt();
			
			targetX = sc.nextInt();
			targetY = sc.nextInt();
			totCnt = 0;
			bfs(x, y);
			sb.append(totCnt).append("\n");
		}
		System.out.println(sb.toString());
	}

	private static void bfs(int x, int y) {
		Queue<int[]> que = new LinkedList<int[]>();
		que.add(new int[] {x, y, 0});
		
		while(!que.isEmpty()) {
			int[] cur = que.poll();
			
			if(cur[0] == targetX && cur[1] == targetY) {
				totCnt = cur[2];
				return;
			}
			
			for(int d=0; d<8; d++) {
				int nr = cur[0] + dr[d];
				int nc = cur[1] + dc[d];
				if(nr < 0 || nc < 0 || nr >= N || nc >= N) continue;
				if(map[nr][nc] == 0) {
					que.add(new int[] {nr, nc, cur[2]+1});
					map[nr][nc] = 1;
				}
			}
		}
	}

}
