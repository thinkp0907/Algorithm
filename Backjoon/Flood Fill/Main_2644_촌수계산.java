import java.io.*;
import java.util.*;

public class Main_2644_촌수계산 {

	static int N, M;
	static int A, B;
	static int[][] map;
	static int[] d;
	static boolean[] visited;
	static final int INF = Integer.MAX_VALUE / 10;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		N = Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine());
		
		// 찾아야하는 관계
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		
		M = Integer.parseInt(br.readLine());
		
		map = new int[N+1][N+1];
		
		// map 초기화
		for(int i=0; i<N+1; i++) {
			for(int j=0; j<N+1; j++) {
				if(i == j) map[i][j] = 0;
				else map[i][j] = INF;
			}
		}
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			map[from][to] = 1;
			map[to][from] = 1;
		}
//		for(int[] b : map) {
//			System.out.println(Arrays.toString(b));
//		}
		d = map[A];
		//System.out.println(Arrays.toString(d));
		visited = new boolean[d.length];
		visited[A] = true;
		
		for(int i=1; i<N+1; i++) {
			int min = INF;
			int index = 0;
			for(int j=0; j<d.length; j++) {
				if(d[j] < min && !visited[j]) {
					min = d[j];
					index = j;
				}
			}
			visited[index] = true;
			for(int j=0; j<d.length; j++) {
				if(d[j] > d[index] + map[index][j]) {
					d[j] = d[index] + map[index][j];
				}
			}
		}
		if(d[B] == INF) System.out.println(-1);
		else System.out.println(d[B]);
	}

}
