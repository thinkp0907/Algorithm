package Backjoon.floodFill;

import java.io.*;
import java.util.*;

public class Main_3184_양 {
	
	static int R, C;
	static char[][] map;
	static boolean[][] visited;
	
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	
	static int totShip;
	static int totWolf;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new char[R][C];
		visited = new boolean[R][C];
		
		for(int i=0; i<R; i++) {
			String s = br.readLine();
			for(int j=0; j<C; j++) {
				map[i][j] = s.charAt(j);
			}
		}
		totShip = 0;
		totWolf = 0;
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				if(visited[i][j] == false && (map[i][j] == 'v' || map[i][j] == 'o')) {
					bfs(i,j,map[i][j]);
				}
			}
		}
		System.out.println(totShip +" "+totWolf);
		
	}

	private static void bfs(int i, int j, char c) {
		Queue<int[]> que = new LinkedList<>();
		que.add(new int[] {i, j, c});
		visited[i][j] = true;
		int ship = 0;
		int wolf = 0;
		while(!que.isEmpty()) {
			int[] cur = que.poll();
			
			if(cur[2] == 'v') {
				wolf++;
			} else if(cur[2] == 'o') {
				ship++;
			}
			
			for(int d=0; d<4; d++) {
				int nr = cur[0] + dr[d];
				int nc = cur[1] + dc[d];
				if(nr < 0 || nc < 0 || nr >= R || nc >= C) continue;
				if(visited[nr][nc] == false && (map[nr][nc] == 'v' || map[nr][nc] == 'o' || map[nr][nc] == '.')) {
					que.add(new int[] {nr, nc, map[nr][nc]});
					visited[nr][nc] = true;
				}
			}
		}
		if(ship > wolf) {
			totShip += ship;
		} else if(wolf >= ship) {
			totWolf += wolf;
		}		
	}

}
