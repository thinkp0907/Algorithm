import java.io.*;
import java.util.*;

public class Main_18442_우체국1 {

	static int V, P;
	static long L;
	static long[] map;
	static long[] num;
	static long[] answers;
	static long result;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		P = Integer.parseInt(st.nextToken());
		L = Long.parseLong(st.nextToken());

		map = new long[V];
		num = new long[P];
		answers = new long[P];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < V; i++) {
			map[i] = Long.parseLong(st.nextToken());
		}

		result = Long.MAX_VALUE;
		comb(0, 0);
		System.out.println(result);
		for (long b : answers) {
			System.out.print(b + " ");
		}
		System.out.println();
		br.close();
	}

	private static void comb(int cnt, int start) {
		if (cnt == P) {
			long sum = 0L;
			for (int i = 0; i < map.length; i++) {
				long answer = Long.MAX_VALUE;
				for (int j = 0; j < num.length; j++) {
					answer = Math.min(Math.min(Math.abs(map[i] - num[j]), L - Math.abs(map[i] - num[j])), answer);
				}
				sum += answer;
				if (sum > result)
					return;

			}
			if (result > sum) {
				result = sum;
				answers = num.clone();
			}
			return;
		}

		for (int i = start; i < V; i++) {
			num[cnt] = map[i];
			comb(cnt + 1, i + 1);
		}
	}
}
