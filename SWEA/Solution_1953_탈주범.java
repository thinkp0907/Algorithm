

import java.util.Scanner;

public class Solution_1953_탈주범 {
	static int N, M,R, C, L;
	static int [][] map;
	static int [][] visited;  //int -> 거리나 시간을 저장할 때 사용 
	static int T;
	static int cnt;
	                //상0좌1우2하3
	static int[] dr={-1,0,0, 1};
	static int[] dc={0,-1,1,0};
	static int[][] shape = {{3,4,7}, {2,6,7}, {2,4,5}, {3,5,6} };
	static int[][] dd={{0},{0,1,2,3},{0,3},{1,2},{0,2},{2,3},{1,3},{0,1}};
	
	// bfs 인데 방향을 파이프 상황(dd)에 맞추어 델타(dr, dc)
	// 를 찾는 것이 관건 
	
	public static void main(String[] args) {
		
		Scanner scann=new Scanner(System.in);
		T=scann.nextInt();
		for (int t = 1; t <= T; t++) {
			N=scann.nextInt();
			M=scann.nextInt();
			R=scann.nextInt();
			C=scann.nextInt();
			L=scann.nextInt();
			map=new int[N][M];
			visited=new int[N][M];
			for (int i = 0; i <N; i++) {
				for (int j = 0; j < M; j++) {
					map[i][j]=scann.nextInt();
				}
			}
			cnt=0;
			bfs();
			counting();
			System.out.println("#"+t+" "+cnt);
		}

	}

	private static void counting() {
		// TODO Auto-generated method stub
		
	}

	private static void bfs() {
		//r,c, d의 방향, 시간 que에 저장
		// que.add(new int[] {R,C,map[R][C],1});
		
	}

}
