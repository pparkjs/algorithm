package baekjoon;

import java.util.LinkedList;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class AC_5430 {
	public static LinkedList<Integer> deq = new LinkedList<>();
	public static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException{
		int[] arr = new int[4];
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//테스트 케이스
		int T = Integer.parseInt(br.readLine());
		String f = br.readLine(); // 함수RDD어쩌구
		int N = Integer.parseInt(br.readLine()); // 배열 개수
		StringTokenizer st = new StringTokenizer(br.readLine(),"[],"); //구분자로 [], 제외함

		for(int i = 0; i<N; i++) {
		deq.add(Integer.parseInt(st.nextToken())); //deq에 데이터 삽입
		}
		
		//테스트 케이스 반복
		for(int i = 0; i < T; i++) {
			//함수를 인자로 전달
			AC(f);
		}
	}
	
	public static void AC(String f) {
		
		//덱의 front를 왼쪽 또는 오른쪽에 주는 역할
		boolean isRight = true;
		
		for (char func : f.toCharArray()) {
			
			if(func == 'R') {
				// R인경우 front를 맨앞이 아닌 맨뒤로 바꿈
				isRight = false;
				continue;
			}
			
			// isRight가 true이자  D인 경우
			if(isRight) {
				//deq 사이즈가 0인경우
				if(deq.size() == 0) {
					sb.append("error").append("\n");
					return;
				}
				
				
				
			}
			
		}
		
	}
}
