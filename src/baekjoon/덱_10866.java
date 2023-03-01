package baekjoon;

import java.util.Deque;
import java.util.LinkedList;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class 덱_10866{

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Deque<Integer> deq = new LinkedList<>();
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			switch (st.nextToken()) {
			case "push_back":
				//뒤에 값 추가
				deq.addLast(Integer.parseInt(st.nextToken()));
				break;
				//앞에 값 추가
			case "push_front":
				deq.addFirst(Integer.parseInt(st.nextToken()));
				break;
				//앞에 값 확인
			case "front":
				if(deq.isEmpty()) //비어있는 경우
					sb.append(-1).append("\n");
				else {
					//비어있지 않는경우
					sb.append(deq.getFirst()).append("\n");
				}
				break;
				//뒤에 값 확인
			case "back":
				if(deq.isEmpty())
					sb.append(-1).append("\n");
				else
					sb.append(deq.getLast()).append("\n");
				break;
				//Deq의 크기 반환
			case "size":
				sb.append(deq.size()).append("\n");
				break;
				//Deq이 비어있는지 확인
			case "empty":
				if(deq.isEmpty())
					sb.append(1).append("\n");
				else
					sb.append(0).append("\n");
				break;
				//맨뒤 원소 제거
			case "pop_back":
				if(deq.isEmpty())
					sb.append(-1).append("\n");
				else
					sb.append(deq.removeLast()).append("\n");
				break;
				//맨앞 원소 제거
			case "pop_front":
				if(deq.isEmpty())
					sb.append(-1).append("\n");
				else
					sb.append(deq.removeFirst()).append("\n");
				break;

			default:
				break;
			}
		}
		System.out.println(sb);
	}

}
