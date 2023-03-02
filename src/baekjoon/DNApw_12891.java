package baekjoon;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class DNApw_12891 {
	static int[] pw; // 주어진 pw 담기위함
	static int[] myCheck; //실제 부분문자열에 해당 문자 개수 넣기 위함
	static int resultCheck;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int s = Integer.parseInt(st.nextToken()); // 문자열 길이
		int p = Integer.parseInt(st.nextToken()); // 부분문자열 길이
		pw = new int[4];
		myCheck = new int[4];
		int result = 0; //비번 만들 수 있는 횟수 초기화
		resultCheck = 0;
		String DNA = br.readLine(); // DNA문자열
		StringTokenizer st2 = new StringTokenizer(br.readLine()); //pw 입력할 것
		
		for (int i = 0; i < pw.length; i++) {
			pw[i] = Integer.parseInt(st2.nextToken()); // 비번 담아줌
			if(pw[i] == 0) {
				resultCheck++;
			}
		}
		//시작부터 부분문자열 길이 까지 처리해줌 0~p-1 (배열로 따질떄)
		for (int i = 0; i < p; i++) {
			//실제로 해당 부분 문자열에 ACGT의 각각 개수를 myCheck에 담아주는 메서드 사용
			add(DNA.charAt(i));
		}
		//초기 0~p~1까지 해서 해당 pw에 맞을 경우 result++해줌
		if(resultCheck == 4) {
			result++;
		}
		//초반 한번 처리 해줬으니 오른쪽으로 한칸씩 이동하면서 비교해주는 반복
		// i=p인 이유는 오른쪽으로 한칸씩 이동할때 새로 유입된 알파벳체크 하기 위함
		for (int i = p; i < s; i++) {
			// j = i-p인 이유는 오른쪽으로 슬라이딩윈도우 하면 0번부터 i가++할때마다 myCheck에서 해당문자 삭제하기위함
			int j = i-p;
			delete(DNA.charAt(j));
			add(DNA.charAt(i));
			if(resultCheck == 4) {
				result++;
			}
			
		}
		System.out.println(result);
		
	}
	
	//부분문자열에서 해당하면 문자가 있으면 myCheck에 담아줌
	private static void add(char a) {
		switch (a) {
		case 'A':
			myCheck[0]++;
			if(pw[0] == myCheck[0])
				resultCheck++;
			break;
		case 'C':
			myCheck[1]++;
			if(pw[1] == myCheck[1])
				resultCheck++;
			break;
		case 'G':
			myCheck[2]++;
			if(pw[2] == myCheck[2])
				resultCheck++;
			break;
		case 'T':
			myCheck[3]++;
			if(pw[3] == myCheck[3])
				resultCheck++;
			break;
		}
	}
	
	//부분문자열에서 해당하면 문자가 있으면 myCheck에서 빼줌
	private static void delete(char a) {
		switch (a) {
		case 'A':
			//해당 문자가 삭제되기 전에 그 문자가 있었어서 비번 체크 성공한거기 때문에 --해줌
			if(pw[0] == myCheck[0])
				resultCheck--;
			myCheck[0]--;
			break;
		case 'C':
			if(pw[1] == myCheck[1]) 
				resultCheck--;
			myCheck[1]--;
			break;
		case 'G':
			if(pw[2] == myCheck[2]) 
				resultCheck--;
			myCheck[2]--;
			break;
		case 'T':
			if(pw[3] == myCheck[3]) 
				resultCheck--;
			myCheck[3]--;
			break;
		}
	}

}
