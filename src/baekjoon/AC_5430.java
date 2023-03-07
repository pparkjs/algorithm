package baekjoon;

import java.util.LinkedList;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class AC_5430 {
	public static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//테스트 케이스
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		//테스트 케이스 반복
		for(int i = 0; i < T; i++) {
			LinkedList<Integer> deq = new LinkedList<>();

			String f = br.readLine(); // 함수RDD어쩌구
			int N = Integer.parseInt(br.readLine()); // 배열 개수
			
			char last = f.charAt(f.length()-1);
			char first = f.charAt(0);

			 st = new StringTokenizer(br.readLine(),"[],"); //구분자로 [], 제외함

			for(int j = 0; j<N; j++) {
				deq.add(Integer.parseInt(st.nextToken())); //deq에 데이터 삽입
			}

			int ac = AC(f, i,deq);
			//함수를 인자로 전달
			if(ac==1) {
				System.out.print("[");
				for(int j = 0; j < deq.size(); j++) {
					Integer d = deq.get(j);
					if(j==deq.size()-1) {
						System.out.print(d);
					}else {
					System.out.print(d + ",");
					}
				}
				System.out.println("]");
			}else if(ac==2){
				System.out.print("[");
				int size = deq.size();
				for(int j = size-1; j > 0; j--) {
					System.out.print(deq.pollLast() +",");

					if(j==1) {
						System.out.print(deq.pollLast());
					}
				}
				System.out.println("]");
			}
		}
	}

	public static int AC(String f, int i, LinkedList<Integer> deq) {

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
						System.out.println("error");
						return 0;
					}
					deq.pollFirst(); //앞에 데이터 삭제
					isRight = true;

				}else { //isRight가 false이자 D인경우
					//deq 사이즈가 0인경우
					if(deq.size() == 0) {
						System.out.println("error");
						return 0;
					}
					deq.pollLast(); //뒤에 데이터 삭제

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







