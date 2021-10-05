import java.io.*;
import java.util.*;

public class Solution_1249_보급로 {
	
	static class Road implements Comparable<Road>{
		int x;
		int y;
		int time;
		
		public Road(int x, int y, int time) {
			this.x = x;
			this.y = y;
			this.time = time;
		}

		@Override
		public int compareTo(Road o) {
			return this.time - o.time;
		}		
	}

	static int T, N;
	static int[] dr = {1, 0, -1, 0};
	static int[] dc = {0, 1, 0, -1};
	static int[][] map;
	static int[][] move;
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			N = Integer.parseInt(br.readLine());
			
			map = new int[N][N];
			move = new int[N][N];
			
			for(int i=0; i<N; i++) {
				Arrays.fill(move[i], Integer.MAX_VALUE);
			}
			
			for(int i=0; i<N; i++) {
				String s = br.readLine();
				for(int j=0; j<N; j++) {
					map[i][j] = s.charAt(j) - '0';
				}
			}
			
			bfs(0, 0);
			System.out.println("#"+t+" "+move[N-1][N-1]);
		}
	}


	private static void bfs(int r, int c) {
		PriorityQueue<Road> pq = new PriorityQueue<>();
		pq.add(new Road(r, c, map[r][c]));
		move[r][c] = map[r][c];
		
		while(!pq.isEmpty()) {
			Road curr = pq.poll();
			
			int x = curr.x;
			int y = curr.y;
			int time = curr.time;
		
			if(x == N-1 && y == N-1) {
				break;
			}
			
			for(int d=0; d<4; d++) {
				int nr = x + dr[d];
				int nc = y + dc[d];
				if(nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
				if(move[nr][nc] > time + map[nr][nc]) {
					move[nr][nc] = time + map[nr][nc];
					pq.add(new Road(nr, nc, time+map[nr][nc]));
				}
			}
		}
		
	}

}
