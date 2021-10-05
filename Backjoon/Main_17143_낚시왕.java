import java.io.*;
import java.util.*;

public class Main_17143_낚시왕 {

	static class Shark {
		int x;
		int y;
		int velocity;
		int direction;
		int size;
		
		public Shark(int x, int y, int velocity, int direction, int size) {
			super();
			this.x = x;
			this.y = y;
			this.velocity = velocity;
			this.direction = direction;
			this.size = size;
		}

		@Override
		public String toString() {
			return "Shark [x=" + x + ", y=" + y + ", velocity=" + velocity + ", direction=" + direction + ", size="
					+ size + "]";
		}
	}
	
	static int N, M, K;
	static int R,C,S,D,W;
	static Shark[][] map;
	static int[] dr = {0, -1, 1, 0, 0};
	static int[] dc = {0, 0, 0, 1, -1};
	static int[] person = {0,0};
	static ArrayList<Shark> catched;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		map = new Shark[N+1][M+1];
		catched = new ArrayList<>();
		
		for(int i=0; i<K; i++) {
			st = new StringTokenizer(br.readLine());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			S = Integer.parseInt(st.nextToken());
			D = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			
			
			if (D <= 2) S %= (N - 1) * 2;
			// D = 1 or 2 (위 아래 면) 
			// S = 1000 가정 하면
			// 1000 % (4 - 1) * 2 = 4 
			else S %= (M - 1) * 2;
			// r c s d w
			// 1 5 8 4 3
			// D = 3 or 4 (좌, 우) 
			// S = 8 가정 하면
			// 8 % (6 - 1) * 2 = 8
			
			map[R][C] = new Shark(R,C,S, D, W);
		}
		
		for(int i=0; i<M; i++) {
			// 사람이 이동
			movePerson();
			// 땅에서 제일 가까운 물고기 잡음
			catchShark();
			// 물고기가 이동함
			moveShark();
		}
		int answer = 0;
		// 잡은 물고기 무게 합
		for(int i=0; i<catched.size(); i++) {
			answer += catched.get(i).size;
		}
		System.out.println(answer);
	}

	private static void moveShark() {
		ArrayList<Shark> list = new ArrayList<>();
		
		for(int i=1; i<map.length; i++) {
			for(int j=1; j<map[i].length; j++) {
				if(map[i][j] != null) {
					list.add(map[i][j]);
					map[i][j] = null;
				}
			}
		}
		for(Shark shark : list) {
			move(shark);
		}
	}

	private static void move(Shark shark) {
		int r = shark.x, c = shark.y;
		int d = shark.direction, v = shark.velocity;
		int velocity = v;
		while(velocity != 0) {
			r = r + dr[d];
			c = c + dc[d];
			if(check(r, c)) {
				velocity--;
			}
			else {
				if(d == 1) d = 2;
				else if(d == 2) d = 1;
				else if(d == 3) d = 4;
				else if(d == 4) d = 3;
				velocity++;
			}
		}
		
		if(map[r][c] != null) {
			Shark prev = map[r][c];
			Shark now = shark;
			if(prev.size > now.size) {
				map[r][c] = prev;
			} else {
				map[r][c] = new Shark(r, c, v, d, now.size);
			}
		} else {
			map[r][c] = new Shark(r,c,v,d,shark.size);
		}
		
	}

	private static boolean check(int r, int c) {
		return r >= 1 && r < N+1 && c >= 1 && c < M+1;
	}

	private static void catchShark() {
		for(int i=1; i<N+1; i++) {
			if(map[i][person[1]] != null) {
				catched.add(map[i][person[1]]);
				map[i][person[1]] = null;
				break;
			}
		}
	}

	private static void movePerson() {
		person[1] += 1;
	}

}
