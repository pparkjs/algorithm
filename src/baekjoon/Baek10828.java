package baekjoon;

import java.util.Stack;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.StringTokenizer;

public class Baek10828 {

	public static void main(String[] args) throws IOException {
		Stack<Integer> stack = new Stack<>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine()); //n개의 줄
		
		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			switch (st.nextToken()) {
			case "push":
				//해당 스택에 push
				stack.push(Integer.parseInt(st.nextToken()));
				break;
				
			case "pop":
				if(stack.isEmpty()) {
					bw.write(-1 + "\n");
				}else {
					bw.write(stack.pop() + "\n");					
				}
				break;
				
			case "top":
				if(stack.isEmpty()) {
					bw.write(-1 + "\n");
				}else {
					bw.write(stack.peek() + "\n");
				}
				break;
				
			case "size":
				bw.write(stack.size() + "\n");
				break;
				
			case "empty":
				if(stack.isEmpty()) {
					bw.write(1 + "\n");
				}else {
					bw.write(0 + "\n");
				}
				break;
			}
		}
		bw.flush();
		bw.close();
		
		
	}

}
