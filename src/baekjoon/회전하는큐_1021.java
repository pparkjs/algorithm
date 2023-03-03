package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class 회전하는큐_1021 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		Deque<Integer> deq = new LinkedList<>();
		
		int N = Integer.parseInt(st.nextToken()); //큐의 크기
		int M = Integer.parseInt(st.nextToken()); //뽑으려는 개수 M
		
		StringTokenizer st2 = new StringTokenizer(br.readLine());
		
		for (int i = 1; i <= N; i++) {
			deq.addLast(i);; // N개의 원소 담음 
		}
		
		
		
	}

	static class Node{
		public int index;
		public int value;
		
		
		
	}
}

