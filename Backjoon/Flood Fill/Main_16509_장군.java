package Backjoon.floodFill;

import java.io.*;
import java.util.*;

public class Main_16509_장군 {

	static int sangR, sangC, kingR, kingC;
	static boolean[][] visited;
	
	static int[][] dr = { { -1, -2, -3 }, { -1, -2, -3 }, { 0, -1, -2 }, { 0, 1, 2 }, { 1, 2, 3 }, { 1, 2, 3 },	{ 0, 1, 2 }, { 0, 1, -2 } };
	static int[][] dc = { { 0, -1, -2 }, { 0, 1, 2 }, { 1, 2, 3 }, { 1, 2, 3 }, { 0, 1, 2 }, { 0, -1, -2 },	{ -1, -2, -3 }, { -1, -2, -3 } };

	static int[][] map;
	static int answer;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 입력
		sangR = sc.nextInt();
		sangC = sc.nextInt();
		kingR = sc.nextInt();
		kingC = sc.nextInt();
		
		map = new int[10][9];
		map[kingR][kingC] = 1;
		answer = -1;
		bfs();
		System.out.println(answer);
	}
	private static void bfs() {
		visited = new boolean[10][9];
		Queue<int[]> que = new LinkedList<int[]>();
		
		que.add(new int[] {sangR, sangC, 0});
		visited[sangR][sangC] = true;
		
		while(!que.isEmpty()) {
			int[] now = que.poll();
			
			for(int d=0; d<8; d++) {
				for(int w=0; w<3; w++) {
					int nr = now[0] + dr[d][w];
					int nc = now[1] + dc[d][w];
					if(nr < 0 || nc < 0 || nr >= 10 || nc >= 9) break;
					if((w != 2 && map[nr][nc] != 0)) break;
					if(w==2) {
						if(map[nr][nc] == 1) {
							answer = now[2] + 1;
							return;
						} else if(!visited[nr][nc]) {
							que.add(new int[] {nr, nc, now[2]+1});
							visited[nr][nc] = true;
						}
					}
				}
			}
		}
		
		
	}

}
