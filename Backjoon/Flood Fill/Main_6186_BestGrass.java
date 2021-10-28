package Backjoon.floodFill;

import java.io.*;
import java.util.*;

public class Main_6186_BestGrass {

	static int R, C;
	static char[][] map;
	
	static int[] dr = { -1, 0, 1, 0};
	static int[] dc = { 0, 1, 0, -1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new char[R][C];
		
		for(int i=0; i<R; i++) {
			map[i] = br.readLine().toCharArray();
		}
		int cnt = 0;
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				if(map[i][j] == '#') {
					cnt++;
					dfs(i,j);
				}
			}
		}
		System.out.println(cnt);
	}

	private static void dfs(int r, int c) {
		map[r][c] = '.';
		
		for(int d=0; d<4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d]; 
			if(nr < 0 || nc < 0 || nr >= R || nc >= C) continue;
			if(map[nr][nc] == '#') {
				dfs(nr,nc);
			}
		}
		
	}

}
