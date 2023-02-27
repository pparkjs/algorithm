package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Stack;
import java.util.StringTokenizer;

public class Baek2493 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine()); // 타워 개수
		int[] tower = new int[N]; //타워 저장공간
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		//tower공간에  tower저장
		for (int i = 0; i < N; i++) {
			tower[i] = Integer.parseInt(st.nextToken());
		}
		
		//중복 for문 쓰면 시간초과 나기에 stack이용
		Stack<int[]> stack = new Stack<>();
		
		//타워 하나하나 꺼내서 stack에 넣은거랑 비교하기 위한 반복
		for (int i = 0; i < N; i++) {
			
			//stack에 값이 있을때 
			while(!stack.empty()) {
				//전타워보다 현재 타워가더 큰경우
				if(tower[i] > stack.peek()[1]) {
					stack.pop(); //스택에 현재 타워 높이보다 작은 것들은 다 제거
				}else {
					sb.append(stack.peek()[0]).append(' ');// 타워보다 높은 타워에 위치값 저장
					break;
				}
				
			}
			//stack에 값이 비어있을 때
			if(stack.empty()) 
			sb.append(0).append(' ');

			stack.push(new int[] {i+1, tower[i]}); //[0] 타워 위치 ,[1] 타워 높이
			
		} 
		System.out.println(sb);
		
	}
}
