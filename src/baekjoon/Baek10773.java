package baekjoon;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.io.IOException;

public class Baek10773 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Integer> stack = new Stack<>();
		int sum = 0;
		int K = Integer.parseInt(br.readLine());

		for (int i = 0; i < K; i++) {
			int n = Integer.parseInt(br.readLine());
			
			if(n == 0) {
				stack.pop();
			}else {
				stack.push(n);
			}

		}
		
		for (Integer integer : stack) {
			sum += integer;
		}
		System.out.println(sum);

	}

}
