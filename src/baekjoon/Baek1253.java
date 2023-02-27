package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baek1253 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); //N개수 초기화
		long[] arr = new long[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Long.parseLong(st.nextToken());
		}
		Arrays.sort(arr); //오름차순 정렬
		
		int point = 2; //배열의 3번째 인덱스부터 시작
		int start = 0;
		int end = point-1; //point직전을 end로 둠
		int good = 0; //좋은수 카운팅 초기화
		
		while(point <= N-1) {
			// start와 end가 point와 같은 경우 좋은 수 
			if(arr[start]+arr[end] == arr[point]) {
				point++;
				start=0; //start를 다시 0으로 초기화
				end = point-1;
				good++;
				//start와 end더한게 point보다 큰경우
			}else if(arr[start]+arr[end] > arr[point]) {
				end--;
			}else if(arr[start]+arr[end] < arr[point]){
				start++;
			}
			//start와end가 같을 때 까지 서로 다른 수를 더해서 point가 안되면 point++
			if(start==end) {
				point++;
				start=0;
				end = point-1;
			}
		}
		System.out.println(good);
	}

}