import java.io.*;
import java.util.*;

public class Main_2577_회전초밥 {

	static int N, D, K, C;
	static int[] map;
	static int[] eat;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); 
		D = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		map = new int[N];
		eat = new int[D + 1];
		
		for(int i=0; i<N; i++) {
			map[i] = Integer.parseInt(br.readLine());
		}
		System.out.println(find());
	}

	private static int find() {
		int cnt = 0;
		for(int i=0; i<K; i++) {
			if(eat[map[i]] == 0) {
				cnt++;
			}
			eat[map[i]]++;
		}
		int max = cnt;
		for(int i=1; i<N; i++) {
			if(max <= cnt) {
				if(eat[C] == 0) {
					max = cnt + 1;
				} else {
					max = cnt;
				}
			}
			eat[map[i-1]]--;
			if(eat[map[i-1]] == 0) cnt--;
			if(eat[map[(i + K - 1)%N]] == 0) cnt++;
			eat[map[(i + K - 1)%N]]++;
		}
		return max;
	}
}
