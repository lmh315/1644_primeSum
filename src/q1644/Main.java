package q1644;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

	static ArrayList<Integer> pNum;
	static int N, count;

	public static void getPrime(int n) {
		int arr[] = new int[n + 1];

		for (int i = 2; i <= n; i++) {
			arr[i] = i;
		}

		for (int i = 2; i <= n; i++) {

			if (arr[i] == 0)
				continue;

			for (int j = i + i; j <= n; j += i) {
				arr[j] = 0;
			}
		}
		for (int i = 2; i <= n; i++) {
			if (arr[i] != 0) {
				pNum.add(arr[i]);
			}
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		int sum;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		count = 0;
		pNum = new ArrayList<>();
		getPrime(N);

		for (int i = 0; i < pNum.size(); i++) {
			sum = 0;
			for (int j = i; j < pNum.size(); j++) {
				sum += pNum.get(j);
				if(sum == N) {
					count++;
					break;
				}
				if(sum > N) break;
			}
		}
		
		System.out.println(count);

	}
}
