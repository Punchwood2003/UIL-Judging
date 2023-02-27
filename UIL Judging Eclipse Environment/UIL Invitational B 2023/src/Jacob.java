import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Jacob {
	public static void main(String[] args) throws IOException {
		new Jacob().run();
	}
	
	public void run() throws IOException {
		BufferedReader file = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		int numTimes = Integer.parseInt(file.readLine());
		double[] ans = new double[1001];
		ans[0] = 3;
		for(int i = 1; i < ans.length; i++) {
			double start = 2 * i;
			double denominator = (start) * (start + 1) * (start + 2);
			ans[i] = (i % 2 == 0) ? (ans[i-1] - ((4.0) / denominator)) : (ans[i-1] + (4.0 / denominator));
		}
		
		while(numTimes-->0) {
			out.printf("%.13f\n", ans[Integer.parseInt(file.readLine())]);
			
		}
		file.close();
		out.close();
	}
}
