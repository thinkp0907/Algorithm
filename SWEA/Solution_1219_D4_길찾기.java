import java.util.*;

public class Solution_1219_D4_길찾기 {

	static int T = 10;
	static int N;
	static int[][] map;
	static boolean[][] visited;
	static int flag;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for(int t=1; t<=T; t++) {
			int tc = sc.nextInt();
			N = sc.nextInt();
			
			map = new int[100][100];
			visited = new boolean[100][100];
			flag = 0;
			
			for(int i=0; i<N; i++) {
				int x = sc.nextInt();	// 0
				int y = sc.nextInt();	// 1
				visited[x][y] = true;
			}
			
			dfs(0);
			if(flag == 1) {
				System.out.println("#" + tc + " " + 1);
			} else {
				System.out.println("#" + tc + " " + 0);
			}
			
		}
	}
	private static void dfs(int start) {
		for(int i=0; i<100; i++) {
			if(visited[start][i] == true) {
				visited[start][i] = false;
				if(i == 99) {
					flag = 1;
					return;
				} else {
					dfs(i);
				}
			}
		}
	}

}