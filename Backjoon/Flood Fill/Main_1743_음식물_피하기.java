package Backjoon.floodFill;

import java.io.*;
import java.util.*;

public class Main_1743_음식물_피하기 {

	static int N, M, K;
	static char[][] map;
	static int biggest;
	static boolean[][] visited;
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		map = new char[N][M];
		visited = new boolean[N][M];
		
		for(int i=0; i<N; i++) {
			Arrays.fill(map[i], '.');
		}
		
		for(int i=0; i<K; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			map[r-1][c-1] = '#';
		}
		
		
		int tot = 0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(map[i][j] == '#') {
					biggest = 0;
					int cnt = search2(i,j,1);
					tot = Math.max(cnt, tot);
				}
			}
		}
	
		System.out.println(tot);
	}
	
	private static int search2(int i, int j, int cnt) {
		visited[i][j] = true;
		biggest++;
				
		for(int d=0; d<4; d++) {
			int nr = i + dr[d];
			int nc = j + dc[d];
			if(nr < 0 || nc < 0 || nr >= N || nc >= M) continue;
			if(map[nr][nc] == '#' && visited[nr][nc] == false) {
				search2(nr, nc, cnt+1);
			}
		}
		
		return biggest;
		
	}

}
