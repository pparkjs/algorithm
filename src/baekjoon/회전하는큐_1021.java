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
		LinkedList<Integer> deq = new LinkedList<>();
		int N = Integer.parseInt(st.nextToken()); //큐의 크기
		int M = Integer.parseInt(st.nextToken()); //뽑으려는 개수 M
		int minCnt = 0; //2,3번의 연산 최소횟수 초기화
		
		StringTokenizer st2 = new StringTokenizer(br.readLine()); //위치 값
		
		for (int i = 1; i <= N; i++) {
			deq.addLast(i);; // N개의 원소 담음
		}
		
		for(int i = 1; i<=M; i++) { // 뽑을 개수 만큼만 반복
			boolean check = false;
			int loc = Integer.parseInt(st2.nextToken()); //위치 값 순서대로 뽑아서 저장
			// deq의 절반 + 1 만큼만 반복 (deq의 크기가 홀수이며 가장 가운데 숫자가 찾을 숫자이면 앞쪽이 최소방법)
			for(int j=1; j<=deq.size()/2+1; j++) {
				
				//deq크기가 홀수면 ex 9 deq.size()/2+1 => 5.5인데 int형은 5되므로 double써줌    
				double odd = (double)deq.size()/2+1;
				// 10인경우 찾을값이 6인데 저 반복문은 홀수를 위한것이므로 바로 브레이크해줌
				if(j == odd) break;
				//deq의 사이즈의 절반까지 원하는 수 나오면 최소 수 이므로 true
				if(loc == deq.get(j-1)) {
					check=true;
					break;
				}
			}
				//절반 앞에서 원하는 수 나올경우 실행
				if(check) {
					int front = 0; // deq 맨앞에서 꺼낸수 저장할 변수
					while(true) {
						front = deq.pollFirst(); //맨앞 변수 삭제후 front에 저장
						
						//꺼낸 front가 해당 위치 값일경우 탈출
						if(front == loc) break;
						//아닐경우 deq맨뒤에 추가
						else {
							deq.offerLast(front); 
							minCnt++; // 2번 동작 수행 ++
						}
					}
					//절반 뒤에서 원하는 수 나올 경우 
				}else {
					int back = 0; //deq맨뒤에서 꺼낸 수 저장할 변수
					while(true) {
						back = deq.pollLast(); //맨뒤 변수 삭제후 back에 저장
						
						//꺼낸 back이 해당 위치 값일 겨우 탈출
						if(back == loc) {
							minCnt++; // 3번동작 수행 ++1번하고 탈출
							break;
						}else {
							deq.offerFirst(back);
							minCnt++; //3번 동작 수행 ++
						}
						
					}
				}
				
			}
		
		System.out.println(minCnt);
		
	}

}

