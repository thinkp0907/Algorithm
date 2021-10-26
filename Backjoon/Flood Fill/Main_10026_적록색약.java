package Backjoon.floodFill;

import java.io.*;
import java.util.*;

public class Main_10026_적록색약 {

	static int N;
	static char[][] map;
	static boolean[][] noRedVisited;
	static boolean[][] yesRedVisited;
	
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	
	static int noRed;
	static int yesRed;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		map = new char[N][N];
		noRedVisited = new boolean[N][N];
		yesRedVisited = new boolean[N][N];
		
		for(int i=0; i<N; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				// 적록색약인 사람
				if(map[i][j] == 'B' && noRedVisited[i][j] == false) {
					Rbfs(i,j, map[i][j]);
					noRed++;
				} else if((map[i][j] == 'R' || map[i][j] == 'G') && noRedVisited[i][j] == false) {
					Rbfs(i,j, map[i][j]);
					noRed++;
				}
				
			}
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				// 적록색약이 아닌 사람
				if(map[i][j] == 'B' &&  yesRedVisited[i][j] == false) {
					bfs(i,j,map[i][j]);
					yesRed++;
				} else if(map[i][j] == 'R' && yesRedVisited[i][j] == false) {
					bfs(i,j,map[i][j]);
					yesRed++;
				} else if(map[i][j] == 'G' && yesRedVisited[i][j] == false) {
					bfs(i,j,map[i][j]);
					yesRed++;
				}
				
			}
		}
		System.out.println(yesRed + " " + noRed);
	}

	private static void Rbfs(int i, int j, char c) {
		Queue<int[]> que = new LinkedList<int[]>();
		que.add(new int[] {i, j});
		noRedVisited[i][j] = true;
		
		while(!que.isEmpty()) {
			int[] cur = que.poll();
			
			for(int d=0; d<4; d++) {
				int nr = cur[0] + dr[d];
				int nc = cur[1] + dc[d];
				if(nr < 0 || nc < 0 || nr >= N || nc >= N) continue;
				if(c == 'B') {
					if(map[nr][nc] == 'B' && noRedVisited[nr][nc] == false) {
						que.add(new int[] {nr, nc});
						noRedVisited[nr][nc] = true;
					}
				} else {
					if(noRedVisited[nr][nc] == false && (map[nr][nc] == 'G' || map[nr][nc] == 'R')) {
						que.add(new int[] {nr, nc});
						noRedVisited[nr][nc] = true;
					}
				}
			}
		}
	}

	private static void bfs(int i, int j,  char c) {
		Queue<int[]> que = new LinkedList<int[]>();
		que.add(new int[] {i, j});
		noRedVisited[i][j] = true;
		
		while(!que.isEmpty()) {
			int[] cur = que.poll();
			
			for(int d=0; d<4; d++) {
				int nr = cur[0] + dr[d];
				int nc = cur[1] + dc[d];
				if(nr < 0 || nc < 0 || nr >= N || nc >= N) continue;
				if(map[nr][nc] == c && yesRedVisited[nr][nc] == false) {
					que.add(new int[] {nr, nc});
					yesRedVisited[nr][nc] = true;
				}
			}
		}
	}

}
