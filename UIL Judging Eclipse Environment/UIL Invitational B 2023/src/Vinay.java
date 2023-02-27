import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;

public class Vinay {
	public static void main(String[] args) throws IOException {
		new Vinay().run();
	}
	
	public void run() throws IOException {
		BufferedReader file = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		int numTimes = Integer.parseInt(file.readLine());
		while(numTimes-->0) {
			String line = file.readLine();
			char[] arr = line.toLowerCase().replaceAll("[^a-zA-Z0-9]", "").toCharArray();
			HashMap<Character, Integer> numOcc = new HashMap<Character, Integer>();
			for(int i = 0; i < arr.length; i++) {
				if(numOcc.containsKey(arr[i])) {
					numOcc.put(arr[i], numOcc.get(arr[i]) + 1);
				} else {
					numOcc.put(arr[i], 1);
				}
			}
			int numOdd = 0;
			for(Character c : numOcc.keySet()) {
				if(numOcc.get(c) % 2 != 0) {
					numOdd++;
				}
				if(numOdd > 1) {
					break;
				}
			}
			if(numOdd > 1) {
				out.printf("%s can not be rearranged to form a palindrome.\n", line);
				continue;
			}
			
			long numerator = 0;
			long denominator = 1;
			for(Character c : numOcc.keySet()) {
				numerator += numOcc.get(c) / 2;
				denominator *= factorial(numOcc.get(c) / 2);
			}
			numerator = factorial(numerator);
			out.printf("%s can be rearranged to form %d distinct palindrome(s).\n", line, numerator / denominator);
		}
		file.close();
		out.close();
	}
	public long factorial(long n) {
		return (n <= 1) ? 1 : n * factorial(n-1); 
	}
}
