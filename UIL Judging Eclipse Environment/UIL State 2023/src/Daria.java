import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Daria {
	public static void main(String[] args) throws IOException {
		new Daria().run();
	}
	
	public void run() throws IOException {
		BufferedReader file = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		
		int numTimes = Integer.parseInt(file.readLine());
		for(int num = 1; num <= numTimes; num++) {
			StringTokenizer st = new StringTokenizer(file.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int[] numCorrect = new int[a];
			double total = 0.0;
			
			String key = file.readLine();
			for(int i = 0; i < a; i++) {
				String test = file.readLine();
				for(int j = 0; j < b; j++) {
					if(key.charAt(j) == test.charAt(j)) {
						numCorrect[i]++;
					}
				}
				total += numCorrect[i];
			}
			
			Arrays.sort(numCorrect);
			double average = total / a;
			double median = (a % 2 == 0) ? ((numCorrect[(a/2) - 1] + numCorrect[a/2]) / 2.0) : (numCorrect[a/2]);
			
			out.printf("Assigment #%d:\n", num);
			out.printf("Mean Score: %.2f\n", (average/b) * 100);
			out.printf("Median Score: %.1f\n\n", (median/b) * 100);
		}
		file.close();
		out.close();
	}
}
