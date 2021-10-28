package Backjoon.floodFill;

import java.io.*;
import java.util.*;

public class Main_14716_현수막 {

	static int M, N;
	static int[][] map;
	static boolean[][] visited;

	static int[] dr = { -1, -1, 0, 1, 1, 1, 0, -1 };
	static int[] dc = { 0, 1, 1, 1, 0, -1, -1, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());

		map = new int[M][N];
		visited = new boolean[M][N];
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int cnt = 0;
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 1 && visited[i][j] == false) {
					bfs(i, j);
					cnt++;
				}
			}
		}
		System.out.println(cnt);
	}

	private static void bfs(int i, int j) {
		Queue<int[]> que = new LinkedList<int[]>();
		que.add(new int[] { i, j });
		visited[i][j] = true;

		while (!que.isEmpty()) {
			int[] cur = que.poll();

			for (int d = 0; d < 8; d++) {
				int nr = cur[0] + dr[d];
				int nc = cur[1] + dc[d];
				if (nr < 0 || nc < 0 || nr >= M || nc >= N)
					continue;
				if (map[nr][nc] == 1 && visited[nr][nc] == false) {
					que.add(new int[] { nr, nc });
					visited[nr][nc] = true;
				}
			}
		}
	}

}
