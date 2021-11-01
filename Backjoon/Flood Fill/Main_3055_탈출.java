package Backjoon.floodFill;

import java.io.*;
import java.util.*;

public class Main_3055_탈출 {

	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };

	static int R, C;
	static char[][] map;
	static int[][] water;
	static int[][] beaver;
	static int dx;
	static int dy;

	static int distance;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		// 원본, 고슴도치, 물
		map = new char[R][C];
		water = new int[R][C];
		beaver = new int[R][C];

		for (int i = 0; i < R; i++) {
			map[i] = br.readLine().toCharArray();
		}
		Queue<int[]> waterque = new LinkedList<int[]>();
		Queue<int[]> beaverque = new LinkedList<int[]>();

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j] == 'D') {
					dx = i;
					dy = j;
				}
				if (map[i][j] == '*') {
					waterque.add(new int[] { i, j });
				} else if (map[i][j] == 'S') {
					beaverque.add(new int[] { i, j });
				}
			}
		}

		while (!waterque.isEmpty()) {
			int[] cur = waterque.poll();

			for (int d = 0; d < 4; d++) {
				int nr = cur[0] + dr[d];
				int nc = cur[1] + dc[d];
				if (nr < 0 || nc < 0 || nr >= R || nc >= C)
					continue;
				if (map[nr][nc] == 'X' || map[nr][nc] == 'D')
					continue;
				if (water[nr][nc] == 0 && map[nr][nc] == '.') {
					water[nr][nc] = water[cur[0]][cur[1]] + 1;
					waterque.add(new int[] { nr, nc });
				}
			}
		}

		while (!beaverque.isEmpty()) {
			int[] cur = beaverque.poll();

			for (int d = 0; d < 4; d++) {
				int nr = cur[0] + dr[d];
				int nc = cur[1] + dc[d];
				if (nr < 0 || nc < 0 || nr >= R || nc >= C)
					continue;
				if (beaver[nr][nc] == 0 && (map[nr][nc] == '.' || map[nr][nc] == 'D')) {
					if (water[nr][nc] == 0) {
						beaver[nr][nc] = beaver[cur[0]][cur[1]] + 1;
						beaverque.add(new int[] { nr, nc });
					} else {

						if (water[nr][nc] > beaver[cur[0]][cur[1]] + 1) {
							beaver[nr][nc] = beaver[cur[0]][cur[1]] + 1;
							beaverque.add(new int[] { nr, nc });
						}

					}
				}
			}
		}
//		
//		for(int[][] a : dist) {
//			for(int b [] : a) {
//				System.out.println(Arrays.toString(b));
//			}
//		}

		if (beaver[dx][dy] == 0)
			System.out.println("KAKTUS");
		else
			System.out.println(beaver[dx][dy]);

	}
}
