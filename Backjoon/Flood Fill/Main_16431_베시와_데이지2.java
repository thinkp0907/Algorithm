package Backjoon.floodFill;

import java.io.*;
import java.util.*;

public class Main_16431_베시와_데이지2 {

	static int Br, Bc, Dr, Dc, Jr, Jc;
		
	static int bessie;
	static int daisy;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		Br = Integer.parseInt(st.nextToken());
		Bc = Integer.parseInt(st.nextToken());
	
		st = new StringTokenizer(br.readLine());
		Dr = Integer.parseInt(st.nextToken());
		Dc = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		Jr = Integer.parseInt(st.nextToken());
		Jc = Integer.parseInt(st.nextToken());
		
		bessie =  Math.max(Math.abs(Br-Jr), Math.abs(Bc-Jc));
		daisy = Math.abs(Dr - Jr) + Math.abs(Dc- Jc);

		
		System.out.println(bessie > daisy ? "daisy" : (bessie == daisy) ? "tie" : "bessie");
	}

}
