package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.io.IOException;

public class 스택수열_1874 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		Stack<Integer> stack = new Stack<>();
		int n = Integer.parseInt(br.readLine());
		int start = 1;
		
		// 수열 n개 입력을 위한 반복
		for (int i = 0; i < n; i++) {
	
			//n번째 숫자 입력
			int num = Integer.parseInt(br.readLine());
			
			//num을 얻기 위한 push반복
			for (int j = start; j <= num; j++) {
				stack.push(j);
				sb.append('+').append('\n');
				start = num+1;
				
			}
			if(stack.peek() != num) {
				System.out.println("NO");
				return;
			}
			sb.append('-').append('\n');
			stack.pop();
			
							
		}

		System.out.println(sb);

	}

}
