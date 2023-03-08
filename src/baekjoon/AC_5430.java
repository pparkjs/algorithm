package baekjoon;

import java.util.LinkedList;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class AC_5430 {
	public static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException{
		LinkedList<Integer> deq = new LinkedList<>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//테스트 케이스
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		//테스트 케이스 반복
		for(int i = 0; i < T; i++) {

			String f = br.readLine(); // 함수RDD어쩌구
			int N = Integer.parseInt(br.readLine()); // 배열 개수

			st = new StringTokenizer(br.readLine(),"[],"); //구분자로 [], 제외함

			for(int j = 0; j<N; j++) {
				deq.add(Integer.parseInt(st.nextToken())); //deq에 데이터 삽입
			}

			int ac = AC(f,deq);
			//함수를 인자로 전달
			if(ac==1) {
				sb.append("[");
				int size = deq.size();
				for(int j = 0; j < size; j++) {
					if(j==size-1) {
						sb.append(deq.pollFirst());
					}else {
						sb.append(deq.pollFirst()+",");
					}
				}
				sb.append("]").append("\n");
			}
			
			else if(ac==2){
				sb.append("[");
				int size = deq.size();
				for(int j = 0; j < size; j++) {
					if(j==size-1) {
						sb.append(deq.pollLast());
					}else {
						sb.append(deq.pollLast() + ",");
					}
				}
				sb.append("]").append("\n");
			}
		}
		System.out.println(sb);
	}

	public static int AC(String f, LinkedList<Integer> deq) {

		//덱의 front를 왼쪽 또는 오른쪽에 주는 역할
		boolean isRight = true;

		for (char func : f.toCharArray()) {
			if(func == 'R') {
				isRight=!isRight; //방향 바꿔줌
				continue;

			}else {
				// isRight가 true이자  D인 경우
				if(isRight) {
					//deq 사이즈가 0인경우
					if(deq.size() == 0) {
						sb.append("error").append("\n");
						return 0;
					}
					deq.pollFirst();
					isRight = true;
				}
				else { //isRight가 false이자 D인경우
					//deq 사이즈가 0인경우
					if(deq.size() == 0) {
						sb.append("error").append("\n");
						return 0;
					}
					deq.pollLast();

				}
			}
		}
		//만약 isRight가 true이면 앞이front인 반환
		if(isRight) {
			return 1;
			//아니면 뒤가 front인 반환
		}else {
			return 2;
		}
	}
}







