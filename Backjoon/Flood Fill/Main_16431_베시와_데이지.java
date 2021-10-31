package Backjoon.floodFill;

import java.io.*;
import java.util.*;

public class Main_16431_베시와_데이지 {

	static int Br, Bc, Dr, Dc, Jr, Jc;
	
	static int[] Brdr = {-1, -1, 0, 1, 1, 1, 0, -1};
	static int[] Brdc = {0, 1, 1, 1, 0, -1, -1, -1};
	
	static int[] Drdr = {-1, 0, 1, 0};
	static int[] Drdc = {0, 1, 0, -1};
	
	static int[][] map;
	static int[][] dist;
	
	static int bessie;
	static int daisy;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		map = new int[1001][1001];
		dist = new int[1001][1001];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		Br = Integer.parseInt(st.nextToken());
		Bc = Integer.parseInt(st.nextToken());
	
		st = new StringTokenizer(br.readLine());
		Dr = Integer.parseInt(st.nextToken());
		Dc = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		Jr = Integer.parseInt(st.nextToken());
		Jc = Integer.parseInt(st.nextToken());
		
		for(int i=0; i<dist.length; i++) {
			Arrays.fill(dist[i], Integer.MAX_VALUE);
		}
		bessie = 0;
		daisy = 0;
		
		dist[Br][Bc] = 0;	
		bfs(Br, Bc, 'B');
		for(int i=0; i<dist.length; i++) {
			Arrays.fill(dist[i], Integer.MAX_VALUE);
		}
		
		dist[Dr][Dc] = 0;
		bfs(Dr, Dc, 'D');
		dist[Dr][Dc] = Integer.MAX_VALUE;
		
		System.out.println(bessie > daisy ? "daisy" : (bessie == daisy) ? "tie" : "bessie");
	}

	private static void bfs(int r, int c, char who) {
		Queue<int[]> que = new LinkedList<int[]>();
		que.add(new int[] {r,c});
		
		while(!que.isEmpty()) {
			int[] now = que.poll();
			
			if(now[0] == Jr && now[1] == Jc) {
				if(who == 'B') {
					bessie = dist[now[0]][now[1]];
					return;
				} else {
					daisy = dist[now[0]][now[1]];
					return;
				}
			}
			
			if(who == 'B') {
				for(int d=0; d<8; d++) {
					int nr = now[0] + Brdr[d];
					int nc = now[1] + Brdc[d];
					if(nr < 1 || nc < 1 || nr >= 1001 || nc >= 1001) continue;
					if(dist[nr][nc] > dist[now[0]][now[1]] + 1) {
						dist[nr][nc] = dist[now[0]][now[1]] + 1;
						que.add(new int[] {nr, nc});
					}
				}
			} else {
				for(int d=0; d<4; d++) {
					int nr = now[0] + Drdr[d];
					int nc = now[1] + Drdc[d];
					if(nr < 1 || nc < 1 || nr >= 1001 || nc >= 1001) continue;
					if(dist[nr][nc] > dist[now[0]][now[1]] + 1) {
						dist[nr][nc] = dist[now[0]][now[1]] + 1;
						que.add(new int[] {nr, nc});
					}
				}
			}
			
		}
		
	}

}
