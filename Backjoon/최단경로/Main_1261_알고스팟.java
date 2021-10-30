import java.io.*;
import java.util.*;

public class Main_1261_알고스팟 {
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};

	static int N, M;
	static int[][] map;
	static int[][] dist;
	static int answer;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[M][N];
		dist = new int[M][N];
		for(int i=0; i<M; i++) {
			Arrays.fill(dist[i], Integer.MAX_VALUE);
		}
		for(int i=0; i<M; i++) {
			String s = br.readLine();
			for(int j=0; j<N; j++) {
				map[i][j] = s.charAt(j) - '0';
			}
		}
		answer = Integer.MAX_VALUE;
		dist[0][0] = 0;
		Queue<int[]> que = new LinkedList<int[]>();
		que.add(new int[] {0,0});
		while(!que.isEmpty()) {
			int[] cur = que.poll();
			
			for(int d=0; d<4; d++) {
				int nr = cur[0] + dr[d];
				int nc = cur[1] + dc[d];
				if(nr < 0 || nc < 0 || nr >= M || nc >= N) continue;
				if(map[nr][nc] == 1) {
					if(dist[nr][nc] > dist[cur[0]][cur[1]] + 1) {
						dist[nr][nc] = dist[cur[0]][cur[1]] + 1;
						que.add(new int[] {nr, nc});
					}
				} else if(map[nr][nc] == 0) {
					if(dist[nr][nc] > dist[cur[0]][cur[1]] + 0) {
						dist[nr][nc] = dist[cur[0]][cur[1]] + 0;
						que.add(new int[] {nr, nc});
					}
				}
			}
		}
		System.out.println(dist[M-1][N-1]);
	}


}
