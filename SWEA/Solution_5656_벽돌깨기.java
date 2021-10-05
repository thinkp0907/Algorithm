import java.io.*;
import java.util.*;

public class Solution_5656_벽돌깨기 {

	static int T, N, W, H;
	static int[][] map;
	static int[] perm;
	static int[] nums;
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());

			map = new int[W][H];
			// 중복순열로 인해 선택되어진 값들
			perm = new int[N];
			// permutation에 사용될 선택될 값들
			nums = new int[W];

			for (int i = 0; i < W; i++) {
				nums[i] = i;
			}

			for (int i = 0; i < W; i++) {
				String[] s = br.readLine().split(" ");
				for (int j = 0; j < H; j++) {
					map[i][j] = Integer.parseInt(s[j]);
				}
			}

			permutation(0);

		}
	}

	private static void permutation(int cnt) {
		if (cnt == N) {
			// 선택된 값들이 순서. ex) 0 0 0 이면 0번 열만 3번 공이 떨어진다
			for (int i = 0; i < perm.length; i++) {
				// 1. 명중시 명중한 번호 위치와 번호 값 배열로 return 받기
				int[] num = checkNum(perm[i]);
				// 2. 명중한 번호만큼 제거
				eliminate(num);
			}
			return;
		}

		for (int i = 0; i < W; i++) {
			perm[cnt] = i;
			permutation(cnt + 1);
		}
	}

	private static void eliminate(int[] num) {
		Queue<int[]> que = new LinkedList<int[]>();
		
		que.add(new int[] {num[0], num[1], num[2]});
		
		while(!que.isEmpty()) {
			int[] cur = que.poll();
			
			// 맞은 공 지우기
			map[cur[0]][cur[1]] = 0;
			
			// 공의 크기가 1이였으면 return
			if(cur[2] == 1) {
				return;
			} else {
				for(int d=0; d<4; d++) {
					int nr = cur[0] + dr[d] * (cur[2]-1);
					int nc = cur[1] + dc[d] * (cur[2]-1);
				}
			}
			
		}
	}

	private static int[] checkNum(int n) {
		for(int i=0; i<H; i++) {
			if(map[i][n] == 0) continue;
			else {
				return new int[] {i, n, map[i][n]};
			}
		}
		return new int[] {-1};
	}

}
